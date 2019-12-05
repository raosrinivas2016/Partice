package reading_endpoint;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.ConnectionType;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.http.HttpHost;
import org.apache.http.client.utils.URIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SecretsServiceUtil {

    private static final Logger log = LoggerFactory.getLogger( SecretsServiceUtil.class );
    public static final String SECRETS_URL = "https://gist.githubusercontent.com/philcampbell-qhr/bae6c3dde2d1d6fd6a4ddb851ea24fb9/raw/b54f005a3eeedeaa30bf301b24aaa4a60a2325ae/secrets_test.json";
    public static final String SECRETS_END_POINT_URL = "https://gist.githubusercontent.com/philcampbell-qhr/";
    //    public static final String SECRETS_END_POINT_URL = "https://testaccuro.free.beeceptor.com";


    private static SecretsAPIService createSecretService( ) throws NotAuthorizedException, NotFoundException {
        return createService( SECRETS_END_POINT_URL, SecretsAPIService.class );
    }

    public static AccuroSecrets getLatestSecretsFromEndPoint( String secretsVersion ) {
        AccuroSecrets AccuroSecretsList = new AccuroSecrets();
        try {
            SecretsAPIService service = createSecretService();
            if ( service != null ) {

                //                Response response = service.getFormsAndQueryAlerts( tokenManager.getAuthorizationHeader(), databaseUuid.toString() );

                Response response = service.getLatestSecrets();


                if ( response != null && response.getStatus() == Response.Status.OK.getStatusCode() ) {
                    //                    InputStream inputStream = ( InputStream ) response.getEntity();

                    AccuroSecretsList = response.readEntity( AccuroSecrets.class );
                } else {
                    log.error( "Forms and Alerts, Invalid response: " + ( response == null ? "response is null" : "status code of " + response.getStatus() ) );
                }
            } else {
                log.error( "Problem creating RegistryAPIService" );
            }
        } catch ( ProcessingException e ) {
            log.error( "Error calling Registry API web service: ", e );
        }
        return AccuroSecretsList;

    }

    /**
     * Creates a Service with the given endpoint url and interface.
     * All service calls are executed using an underlying executor.
     *
     * @param <T>
     * @param endpointUrl
     * @param serviceClass - service interface
     *
     * @return
     *
     * @throws NotAuthorizedException
     * @throws NotFoundException
     */
    public static <T> T createService( String endpointUrl, Class<T> serviceClass ) throws NotAuthorizedException, NotFoundException {
        JacksonJsonProvider provider = new JacksonJsonProvider();
        provider.enable( DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY );
        provider.enable( SerializationFeature.WRITE_NULL_MAP_VALUES );


        T service = JAXRSClientFactory.create( endpointUrl, serviceClass, Arrays.asList( provider ) );

        ClientConfiguration config = WebClient.getConfig( service );
        config.getOutInterceptors().add( new LoggingOutInterceptor() );
        config.getInInterceptors().add( new LoggingInInterceptor() );

        WebClient.client( service ).type( MediaType.APPLICATION_JSON ).accept( javax.ws.rs.core.MediaType.APPLICATION_JSON );

        TLSClientParameters params = new TLSClientParameters();
        params.setUseHttpsURLConnectionDefaultSslSocketFactory( true );
        params.setUseHttpsURLConnectionDefaultHostnameVerifier( true );
        if ( service != null ) {
            HTTPConduit conduit = WebClient.getConfig( service ).getHttpConduit();
            conduit.setTlsClientParameters( params );
            HTTPClientPolicy cp = conduit.getClient();
            cp.setConnection( ConnectionType.KEEP_ALIVE );
        }

        // Wrap service so the call is made on the correct thread.
        return ( T ) Proxy.newProxyInstance( serviceClass.getClassLoader(),
                                             new Class<?>[]{ serviceClass },
                                             new ServiceWrapper( endpointUrl, service ) );
    }

    private static final Map<String, ExecutorService> ENDPOINT_EXECUTORS = new HashMap<>();

    private static class ServiceWrapper implements InvocationHandler {

        private final String host;
        private final Object service;

        public ServiceWrapper( String url, Object service ) {
            this.host = getHost( url );
            this.service = service;
        }

        private String getHost( String url ) {
            try {
                URI uri = new URI( url );
                HttpHost urlHost = URIUtils.extractHost( uri );
                return urlHost.toString();
            } catch ( URISyntaxException ex ) {
                return url;
            }
        }

        @Override
        public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {
            try {
                return ENDPOINT_EXECUTORS.computeIfAbsent( host, k -> Executors.newSingleThreadExecutor() )
                               .submit( ( ) -> method.invoke( service, args ) ).get();
            } catch ( InterruptedException ex ) {
                log.error( "Endpoint call interrupted.", ex );
            } catch ( ExecutionException ex ) {
                log.error( "Error calling endpoint.", ex );
            }
            return null;
        }
    }


}

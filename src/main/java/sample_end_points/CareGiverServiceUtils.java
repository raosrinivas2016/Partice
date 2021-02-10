package sample_end_points;

import ca.uhn.fhir.rest.api.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import reading_endpoint.SecretsServiceUtil;

import javax.ws.rs.core.Response;

public class CareGiverServiceUtils {

    private static final String ENDPOINT_URL = "https://api.mocki.io";
    private static final Log log = LogFactory.getLog( CareGiverServiceUtils.class );

    public void retrievingDataFromEndPoint() {
        Response response = creatingService().getUsers();
        switch ( response.getStatus() ) {
            case ( Constants.STATUS_HTTP_200_OK ):
                CareGiverJsonResponse[] careGiverJsonResponse = response.readEntity( CareGiverJsonResponse[].class );
                writeResponseToConsole( careGiverJsonResponse );
                break;
            default:
                log.error( "unable to read response , error occurred" + response.getStatus() );
        }
    }

    private CaregiverService creatingService() {
        try {
            CaregiverService service = SecretsServiceUtil.createService( generateEndPointURL(), CaregiverService.class );
            return service;
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeResponseToConsole( CareGiverJsonResponse[] careGiverJsonResponse ) {
        for ( CareGiverJsonResponse e : careGiverJsonResponse ) {
            System.out.println( e.toString() );
        }
    }

    private String generateEndPointURL() {
        return ENDPOINT_URL;
    }
}

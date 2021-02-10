package reading_endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Produces( MediaType.APPLICATION_JSON )
@Path( "bae6c3dde2d1d6fd6a4ddb851ea24fb9/raw/" )
//@Path( "/test" )

public interface SecretsAPIService {

    @GET
    @Path( "/b54f005a3eeedeaa30bf301b24aaa4a60a2325ae" )
        //    @Path( "/tempGetLatestSecrets" )
    Response getLatestSecrets();

    //            @HeaderParam( HttpHeaders.AUTHORIZATION ) String auth );
    //        @PathParam( "programId" )
    //            @QueryParam( "databaseUuid" ) UUID databaseId,
    //            @QueryParam( "page" ) Integer pageIndex,
    //            @QueryParam( "length" ) Integer length );


}

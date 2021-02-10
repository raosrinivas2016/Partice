package sample_end_points;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces( MediaType.APPLICATION_JSON )
@Path( "/v1" )
public interface CaregiverService {

    @GET
    @Path( "/b043df5a" )
    Response getUsers();
}

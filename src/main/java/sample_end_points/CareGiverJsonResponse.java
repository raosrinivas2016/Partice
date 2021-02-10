package sample_end_points;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties( ignoreUnknown = true )
public class CareGiverJsonResponse implements Serializable {

    @JsonProperty( "name" )
    private final String name;
    @JsonProperty( "city" )
    private final String city;

    @JsonCreator
    public CareGiverJsonResponse( @JsonProperty( "name" ) String name, @JsonProperty( "city" ) String city ) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "CareGiverJsonResponse{" +
               "name='" + name + '\'' +
               ", city='" + city + '\'' +
               '}';
    }

    @JsonProperty( "city" )
    public String getCity() {
        return city;
    }

    @JsonProperty( "name" )
    public String getName() {
        return name;
    }
}

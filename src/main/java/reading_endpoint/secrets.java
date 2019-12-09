package reading_endpoint;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;

@JsonIgnoreProperties( ignoreUnknown = true )
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
        "key",
        "value"
} )
public class secrets implements Serializable {

    @JsonProperty( "key" )
    private String key;
    @JsonProperty( "value" )
    private String value;

    @JsonProperty( "key" )
    public String getKey( ) {
        return key;
    }

    @JsonProperty( "value" )
    public String getValue( ) {
        return value;
    }

}

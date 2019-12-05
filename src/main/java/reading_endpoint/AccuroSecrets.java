package reading_endpoint;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Date;


@JsonIgnoreProperties( ignoreUnknown = true )
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( {
        "version",
        "publishDateTime",
        "secrets"
} )
public class AccuroSecrets implements Serializable {

    @JsonProperty( "version" )
    private Integer version;
    @JsonProperty( "publishDateTime" )
    private Date publishDateTime;
    @JsonProperty( "secrets" )
    @JsonIdentityInfo( scope = secrets.class, property = "key", generator = ObjectIdGenerators.PropertyGenerator.class )
    private secrets[] secrets;

    @JsonProperty( "version" )
    public Integer getVersion( ) {
        return version;
    }


    @JsonProperty( "publishDateTime" )
    public Date getPublishDateTime( ) {
        return publishDateTime;
    }


    @JsonProperty( "secrets" )
    public secrets[] getSecrets( ) {
        return secrets;
    }


}
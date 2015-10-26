package java.com.somallg.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by somallg on 3/12/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Enclosure {

    @JsonProperty(value = "_url")
    private String url;

    @JsonProperty(value = "_length")
    private String length;

    @JsonProperty(value = "_type")
    private String type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package java.com.somallg.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by somallg on 3/13/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Source {

    @JsonProperty(value = "_url")
    private String url;

    @JsonProperty(value = "__text")
    private String text;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

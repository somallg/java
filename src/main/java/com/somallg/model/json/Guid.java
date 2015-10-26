package java.com.somallg.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by somallg on 3/12/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Guid {

    @JsonProperty(value = "_isPermaLink")
    private boolean isPermaLink;

    @JsonProperty(value = "__text")
    private String text;

    public boolean isPermaLink() {
        return isPermaLink;
    }

    public void setPermaLink(boolean isPermaLink) {
        this.isPermaLink = isPermaLink;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

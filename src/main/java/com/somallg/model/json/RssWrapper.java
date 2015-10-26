package java.com.somallg.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by somallg on 3/13/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RssWrapper {

    @JsonProperty(value = "rss")
    private Rss rss;

    public Rss getRss() {
        return rss;
    }

    public void setRss(Rss rss) {
        this.rss = rss;
    }
}

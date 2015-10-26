package java.com.somallg.model.xml;

import javax.xml.bind.annotation.*;

/**
 * Created by somallg on 3/12/15.
 */
@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rss {

    @XmlAttribute(name = "version")
    private String version;

    @XmlElement(name = "channel")
    private Channel channel;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}

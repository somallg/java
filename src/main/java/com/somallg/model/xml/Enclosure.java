package java.com.somallg.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by somallg on 3/12/15.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Enclosure {

    @XmlAttribute(name = "url")
    private String url;

    @XmlAttribute(name = "length")
    private String length;

    @XmlAttribute(name = "type")
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

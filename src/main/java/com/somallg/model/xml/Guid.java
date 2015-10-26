package java.com.somallg.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by somallg on 3/12/15.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Guid {

    @XmlAttribute(name = "isPermaLink")
    private boolean isPermaLink;

    @XmlValue
    private String link;

    public boolean isPermaLink() {
        return isPermaLink;
    }

    public void setPermaLink(boolean isPermaLink) {
        this.isPermaLink = isPermaLink;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

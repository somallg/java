package java.com.somallg.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by somallg on 3/12/15.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Atom {

    @XmlAttribute(name = "rel")
    private String rel;

    @XmlAttribute(name = "href")
    private String href;

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}

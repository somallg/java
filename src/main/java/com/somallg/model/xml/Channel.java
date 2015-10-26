package java.com.somallg.model.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by somallg on 3/12/15.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Channel {

    @XmlElement(name = "title")
    private String title;

    @XmlElement(name = "description")
    private String description;

    @XmlElement(name = "link")
    private String link;

    @XmlElement(name = "link", namespace = "atom")
    private Atom atomLink;

    @XmlElement(name = "language")
    private String language;

    @XmlElement(name = "managingEditor")
    private String managingEditor;

    @XmlElement(name = "webMaster")
    private String webMaster;

    @XmlElement(name = "docs")
    private String docs;

    @XmlElement(name = "item")
    private List<Item> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Atom getAtomLink() {
        return atomLink;
    }

    public void setAtomLink(Atom atomLink) {
        this.atomLink = atomLink;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getManagingEditor() {
        return managingEditor;
    }

    public void setManagingEditor(String managingEditor) {
        this.managingEditor = managingEditor;
    }

    public String getWebMaster() {
        return webMaster;
    }

    public void setWebMaster(String webMaster) {
        this.webMaster = webMaster;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

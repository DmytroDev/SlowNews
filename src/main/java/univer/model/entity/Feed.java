package univer.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

// Represents one RSS news
@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Feed {

    private String title;
    private String description;
    private Enclosure enclosure;

    public Feed() {
    }

    public Feed(String title, String description, Enclosure enclosure) {
        this.title = title;
        this.description = description;
        this.enclosure = enclosure;
    }

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

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", enclosure=" + enclosure.getUrl() +
                '}';
    }
}

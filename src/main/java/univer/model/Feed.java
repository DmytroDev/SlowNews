package univer.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

// Represents one RSS news
@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Feed {

    private String title;
    private String description;

    public Feed() {
    }

    public Feed(String title, String description) {
        this.title = title;
        this.description = description;
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

    @Override
    public String toString() {
        return "FeedNews{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

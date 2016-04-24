package univer.model.entity;

import javax.xml.bind.annotation.XmlAttribute;

public class Enclosure {
    private String url;

    @XmlAttribute(name = "url")
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
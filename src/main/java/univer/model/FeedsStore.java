package univer.model;

// Stores an RSS feed

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "rss")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(factoryClass=FeedsStore.class, factoryMethod="getInstance")
public class FeedsStore {

    private static FeedsStore instance;

    public FeedsStore() {
        newsList = new ArrayList<>();
    }

    @XmlElementWrapper(name="channel")
    @XmlElement(name = "item")
    private List<Feed> newsList;

    public static FeedsStore getInstance() {
        if(instance == null) {
            synchronized (FeedsStore.class){
                if (instance == null) {
                    instance = new FeedsStore();
                }
            }
        }
        return instance;
    }

    public void addNews(String title, String body) {
        newsList.add(new Feed(title, body));
    }

    public List<Feed> getNewsList() {
        return newsList;
    }

}

package univer.service;

import univer.model.Feed;
import univer.model.FeedsStore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class NewsGeneratorRSS {

    public List<Feed> createNewsList() {
        FeedsStore feedsStore = FeedsStore.getInstance();
        try {
            feedsStore = (FeedsStore) JAXBContext.newInstance(FeedsStore.class)
                    .createUnmarshaller().unmarshal(
                            new URL("http://static.feed.rbc.ru/rbc/internal/rss.rbc.ru/rbcdaily.ru/last.rss"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return feedsStore.getNewsList();
    }

}
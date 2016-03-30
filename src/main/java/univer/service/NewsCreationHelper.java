package univer.service;

import univer.model.News;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsCreationHelper {

    private String data1 = "300 is a 2007 American epic fantasy war film based on the 1998 comic series of the same name by Frank Miller and Lynn Varley.\n" +
            "Both are fictionalized retellings of the Battle of Thermopylae within the Persian Wars.\n" +
            "The film was directed by Zack Snyder, while Miller served as executive producer and consultant.\n" +
            "It was filmed mostly with a super-imposition chroma key technique, to help replicate the imagery of the original comic book.";
    private String data2 = "La Belle Verte (The Green Beautiful) is a French film written, directed by and starring Coline Serreau.\n" +
            "In the years following its release, it was mysteriously banned throughout much of Europe and Russia.\n" +
            "It is a VERY difficult movie to get a hold of, particularly with the poor English translations.\n" +
            "This said, it is one of the most amazing and truly beautiful and heart-warming films I have ever seen.\n" +
            "It is a story about self-realization and harmony, a message of peace and makes you rethink the way you live your life.";
    private String data3 = "The Ugly Truth is a 2009 American romantic comedy film starring Katherine Heigl and Gerard Butler.\n" +
            "The film was released in North America on July 24, 2009 by Columbia Pictures.";

    // simply stub
    public List<News> createNewsList() throws IOException {
        List<News> newsList = new ArrayList<News>();
        newsList.add(new News("300 Spartans", "resources/images/300.jpg", data1));
        newsList.add(new News("The Green Beautiful", "resources/images/green.jpg", data2));
        newsList.add(new News("The Ugly Truth", "resources/images/truth.jpg", data3));

        return newsList;
    }

}

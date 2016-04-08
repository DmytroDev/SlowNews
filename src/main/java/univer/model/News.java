package univer.model;

import java.io.IOException;

public class News {
    private String title;
    private String description; // Content with news
    private String imagePath;

    public News() {
    }

    public News(String title, String description, String imagePath) throws IOException {
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package univer.service;

import univer.model.News;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsGenerator {
    private Random random;
    private final static String PATH_TO_LIBRARY = "/words/library.txt";

    public NewsGenerator() {
        this.random = new Random();
    }

    // method generate 10 pseudo random news
    public List<News> createNewsList() {

        List<News> newsList = new ArrayList<News>();
        try {
            for (int i = 0; i < 10; i++) {
                newsList.add(new News(generateTitle(),  generateDescription(), generateImagePath()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    private String generateTitle() throws IOException {
        List<String> words = getAllWords(PATH_TO_LIBRARY);
        String title = words.get(this.random.nextInt(100)).toUpperCase();

        return title;
    }

    private String generateImagePath() {
        return "resources/images/" + this.random.nextInt(16) + ".jpg";
    }

    // each description have a length 100 words
    private String generateDescription() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> words = getAllWords(PATH_TO_LIBRARY);
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(words.get(this.random.nextInt(100)) + " ");
        }
        stringBuilder.append(".");
        return stringBuilder.toString();
    }

    private List<String> getAllWords(String path) throws IOException {
        List<String> words = new ArrayList<>();

        try (InputStream inputStream = this.getClass().getResourceAsStream(path);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                words.add(s);
            }
        }
        return words;
    }

}

package univer.service;

import univer.model.News;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArchiveContainer {

    private static ArchiveContainer instance;
    private HashMap <String, List<News>> usersArchiveMap;
    private List<News> archiveList;

    public ArchiveContainer() {
        this.usersArchiveMap = new HashMap<String, List<News>>();
    }

    public static ArchiveContainer createArchiveContainer(){
        if (instance == null) {
            synchronized (ArchiveContainer.class){
                if (instance == null){
                    instance = new ArchiveContainer();
                }
            }
        }
        return instance;
    }

    public void addToArchive(String userName, News news){
        if (usersArchiveMap.containsKey(userName) ){
            usersArchiveMap.get(userName).add(news);
        } else {
            archiveList = new ArrayList<>();
            archiveList.add(news);
            usersArchiveMap.put(userName, archiveList);
        }
    }

    public List<News> getUsersArchiveList(String userName){
        return this.usersArchiveMap.get(userName);
    }

}

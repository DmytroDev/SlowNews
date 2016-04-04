package univer.service;

import univer.model.News;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArchiveContainer {

    private static ArchiveContainer instance;
    private HashMap <String, List<News>> usersArchiveMap;
    private List<News> archiveList;
    private String userName;

    private ArchiveContainer(String userName) {
        this.usersArchiveMap = new HashMap<String, List<News>>();
        this.userName = userName;
        this.archiveList = new ArrayList<News>();
    }

    public static ArchiveContainer createArchiveContainer(String userName){
        if (instance == null) {
            synchronized (ArchiveContainer.class){
                if (instance == null){
                    instance = new ArchiveContainer(userName);
                }
            }
        }
        return instance;
    }

    public void addToArchive(News news){
        this.archiveList.add(news);
        usersArchiveMap.put(this.userName, archiveList);
    }

    public HashMap <String, List<News>> getUsersArchive(){
        return this.usersArchiveMap;
    }

}

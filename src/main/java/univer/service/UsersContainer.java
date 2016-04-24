package univer.service;

import org.apache.commons.codec.digest.DigestUtils;
import univer.model.entity.User;
import java.util.ArrayList;
import java.util.List;

public class UsersContainer {
    private static volatile UsersContainer instance;
    private List<User> userList;

    private UsersContainer(){
        this.userList = createUserList();
    }

    private List<User> createUserList(){
        List<User> userList = new ArrayList<User>();
        userList.add(new User("admin", "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918")); //DigestUtils.sha256Hex("admin")
        userList.add(new User("user1", DigestUtils.sha256Hex("user1")));
        userList.add(new User("incognito", DigestUtils.sha256Hex("1")));
        userList.add(new User("1", DigestUtils.sha256Hex("1")));

        return userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    // realized singletone for multitreading
    public static UsersContainer getUsersContainer(){
        if (instance == null){
            synchronized (UsersContainer.class){
                if (instance == null){
                    instance = new UsersContainer();
                }
            }
        }
        return instance;
    }

    public boolean contains(String userName){
        boolean result = false;
        for (User user : userList) {
            if (userName.equalsIgnoreCase(user.getPassword())){
                result = true;
                break;
            }
        }
        return result;
    }

}

package univer.service;

import org.apache.commons.codec.digest.DigestUtils;
import univer.model.User;
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
/*        userList.add(new User("admin", "admin"));
        userList.add(new User("user1", "user1"));
        userList.add(new User("incognito", "1"));
        userList.add(new User("1", "1"));*/
        userList.add(new User("admin", DigestUtils.sha256Hex("admin")));
        userList.add(new User("user1", DigestUtils.sha256Hex("user1")));
        userList.add(new User("incognito", DigestUtils.sha256Hex("1")));
        userList.add(new User("1", "1"));

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
            if (userName.equalsIgnoreCase(user.getLogin())){
                result = true;
                break;
            }
        }
        return result;
    }

}

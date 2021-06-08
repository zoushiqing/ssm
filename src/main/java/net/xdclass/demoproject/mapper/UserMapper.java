package net.xdclass.demoproject.mapper;

import net.xdclass.demoproject.domain.User;
import net.xdclass.demoproject.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {

    private static Map<String, User> userMap = new HashMap<>();

    static {
        userMap.put("jack", new User(1, "jack", "jack1234"));
        userMap.put("tom", new User(2, "tom", "tom1234"));
        userMap.put("bom", new User(3, "bom", "bom1234"));
        userMap.put("shy", new User(4, "shy", "shy1234"));
    }

    public User login(String userName, String pwd) {
        User user = userMap.get(userName);
        if (user == null) return null;
        if (user.getPwd().equals(pwd)) return user;
        return null;
    }
    public List<User> userList(){
        List<User> userList=new ArrayList<>();
        userList.addAll(userMap.values());
        return userList;
    }
}

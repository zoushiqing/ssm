package net.xdclass.demoproject.mapper;

import net.xdclass.demoproject.domain.User;
import net.xdclass.demoproject.domain.Video;

import java.util.HashMap;
import java.util.Map;

public class UserMapper {

    private static Map<Integer, User> userMap = new HashMap<>();

    static {
        userMap.put(1, new User(1, "jack", "jack1234"));
        userMap.put(2, new User(2, "tom", "tom1234"));
        userMap.put(3, new User(3, "bom", "bom1234"));
        userMap.put(4, new User(4, "shy", "shy1234"));
    }
}

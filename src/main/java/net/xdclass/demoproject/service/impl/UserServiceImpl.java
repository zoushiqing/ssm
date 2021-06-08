package net.xdclass.demoproject.service.impl;

import net.xdclass.demoproject.domain.User;
import net.xdclass.demoproject.mapper.UserMapper;
import net.xdclass.demoproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private static Map<String, User> tokenMap = new HashMap<>();
    @Autowired
    UserMapper userMapper;

    @Override
    public String login(String userName, String pwd) {
        User user = userMapper.login(userName, pwd);
        if (user == null) return null;
        else {
            String token = UUID.randomUUID().toString();
            tokenMap.put(token, user);
            return token;
        }
    }
}

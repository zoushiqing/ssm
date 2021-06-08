package net.xdclass.demoproject.service;

import net.xdclass.demoproject.domain.User;

import java.util.List;

public interface UserService {
    String login(String userName,String pwd);
    List<User> userList();
}

package net.xdclass.demoproject.controller;

import net.xdclass.demoproject.domain.User;
import net.xdclass.demoproject.service.UserService;
import net.xdclass.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pub/user")
public class UserController {
    //    @PostMapping("login")
//    public JsonData login(String userName, String pwd) {
//
//        return JsonData.buildSuccess("");
//    }
    @Autowired
    UserService userService;

    @PostMapping("login")
    public JsonData login(@RequestBody User user) {
        String token = userService.login(user.getUserName(), user.getPwd());
        return token != null ? JsonData.buildSuccess(token) : JsonData.buildError("账号密码错误");
    }
}

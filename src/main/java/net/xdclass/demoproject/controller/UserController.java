package net.xdclass.demoproject.controller;

import net.xdclass.demoproject.domain.User;
import net.xdclass.demoproject.utils.JsonData;
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
    @PostMapping("login")
    public JsonData login(@RequestBody User user) {
        System.out.println(user.toString());
        return JsonData.buildSuccess(user.toString());
    }
}

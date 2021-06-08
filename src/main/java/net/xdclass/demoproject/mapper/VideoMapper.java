package net.xdclass.demoproject.mapper;

import net.xdclass.demoproject.domain.User;
import net.xdclass.demoproject.domain.Video;

import java.util.HashMap;
import java.util.Map;

public class VideoMapper {
    private static Map<Integer, Video> videoMap = new HashMap<>();

    private static Map<Integer, User> userMap = new HashMap<>();

    static {
        videoMap.put(1, new Video(1, "java基础课程"));
        videoMap.put(2, new Video(2, "html是个课程"));
        videoMap.put(3, new Video(3, "微信支付课程"));
        videoMap.put(4, new Video(4, "ps学习好东西"));
        videoMap.put(5, new Video(5, "面试专题第一集"));
        videoMap.put(6, new Video(6, "php不是拍黄片"));
        videoMap.put(7, new Video(7, "mysql入门到精通"));

        userMap.put(1,new User(1,"jack","jack1234"));
        userMap.put(1,new User(1,"jack","jack1234"));
        userMap.put(1,new User(1,"jack","jack1234"));
        userMap.put(1,new User(1,"jack","jack1234"));
    }
}

package net.xdclass.demoproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.xdclass.demoproject.config.WXConfig;
import net.xdclass.demoproject.domain.Video;
import net.xdclass.demoproject.service.VideoService;
import net.xdclass.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/test")
@PropertySource({"classpath:pay.properties"})
public class TestController {

    @Value("${wx.appid}")
    private String payAppId;
    @Value("${wx.secret}")
    private String paySecrete;

    @Autowired
    WXConfig wxConfig;

    @GetMapping("get_config")
    public JsonData getConfig(){
        Map<String,String> map= new HashMap<>();
//        map.put("app_id",payAppId);
//        map.put("sercret",paySecrete);

        map.put("app_id",wxConfig.getPayAppId());
        map.put("secret",wxConfig.getPaySecrete());
        map.put("mech_id",wxConfig.getPayMechId());
        return JsonData.buildSuccess(map);
    }

    @GetMapping("list")
    public JsonData list()  {
        int i=1/0;

        return JsonData.buildSuccess("videoList");
    }

}

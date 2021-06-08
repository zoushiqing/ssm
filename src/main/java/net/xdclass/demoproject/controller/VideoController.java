package net.xdclass.demoproject.controller;

import net.xdclass.demoproject.service.VideoService;
import net.xdclass.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    //    @RequestMapping(value = "list",method = RequestMethod.GET)
    @GetMapping(value = "list")
    public Object list() {

        return JsonData.buildSuccess(videoService.videoList());
    }
}

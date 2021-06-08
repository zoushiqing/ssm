package net.xdclass.demoproject.controller;

import net.xdclass.demoproject.domain.Video;
import net.xdclass.demoproject.service.VideoService;
import net.xdclass.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    //    @RequestMapping(value = "list",method = RequestMethod.GET)
    @GetMapping(value = "list")
    public JsonData list() {

        return JsonData.buildSuccess(videoService.videoList());
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideChapter(@RequestBody Video video) {
        System.out.println(video.toString());
        return JsonData.buildSuccess("");
    }

}

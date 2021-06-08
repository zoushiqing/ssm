package net.xdclass.demoproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.xdclass.demoproject.domain.Video;
import net.xdclass.demoproject.service.VideoService;
import net.xdclass.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    //    @RequestMapping(value = "list",method = RequestMethod.GET)
    @GetMapping(value = "list")
    public JsonData list() throws JsonProcessingException {
        List<Video> videoList = videoService.videoList();
        ObjectMapper objectMapper=new ObjectMapper();
        String s = objectMapper.writeValueAsString(videoList);
        System.out.println(s);
        return JsonData.buildSuccess(videoList);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideChapter(@RequestBody Video video) {
        System.out.println(video.toString());
        return JsonData.buildSuccess(video);
    }

}

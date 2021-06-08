package net.xdclass.demoproject;

import junit.framework.TestCase;
import net.xdclass.demoproject.domain.Video;
import net.xdclass.demoproject.service.VideoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.http.Cookie;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class) //底层⽤junit SpringJUnit4ClassRunner
@SpringBootTest(classes = {DemoProjectApplication.class})//启动整个springboot⼯程
@AutoConfigureMockMvc
public class VideoTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testVideoListApi() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
        String contentAsString = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(contentAsString);

        Collection<String> headerNames = mvcResult.getResponse().getHeaderNames();
        for (String headerName : headerNames) {
            System.out.println(headerName);
        }

        Cookie[] cookies = mvcResult.getResponse().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie);
        }
    }


//    @Autowired
//    VideoService videoService;
//
//    @Test
//    public void testVideoList(){
//        List<Video> videoList = videoService.videoList();
//        TestCase.assertTrue(videoList.size()>0);
//    }


//    @Before
//    public void testOne(){
//        System.out.println("testBefore");
//    }
//    @Test
//    public void testTwo(){
//        System.out.println("testTest");
//    }
//    @Test
//    public void testTwo2(){
//        System.out.println("testTest2");
//        TestCase.assertEquals(1,3);
//    }
//    @After
//    public void testThree(){
//        System.out.println("testAfter");
//    }
}

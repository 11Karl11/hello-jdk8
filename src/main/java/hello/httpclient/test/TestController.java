package hello.httpclient.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.httpclient.core.DefaultBodyEncoder;
import hello.httpclient.core.DefaultHttpClient;
import hello.httpclient.model.HttpResult;
import hello.jdk8.Person;

import okhttp3.OkHttpClient;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author karl xie
 * Created on 2020-04-17 14:04
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("getTest")
    public StationTreeVo getTest() {
        return StationTreeVo.builder().id(1).selected(false).name("get").build();
    }

    @PostMapping("postTest")
    public StationTreeVo getTest(@RequestBody String str) throws JsonProcessingException {
        System.out.println(str);
        ObjectMapper mapper = new ObjectMapper();
        StationTreeVo stationTreeVo = mapper.readValue(str, StationTreeVo.class);
        System.out.println(stationTreeVo);
        return stationTreeVo;
    }

    @GetMapping("get")
    public Object get() throws IOException {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new OkHttpClient(), new DefaultBodyEncoder());
        HttpResult httpResult = defaultHttpClient.httpGet("http://192.168.101.20:8080/test/getTest");
        System.out.println(httpResult);
        return httpResult.getContent();
    }

    @PostMapping("post")
    public Object post() throws IOException {
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new OkHttpClient(), new DefaultBodyEncoder());
        ObjectMapper mapper = new ObjectMapper();
        StationTreeVo stationTreeVo = StationTreeVo.builder().id(111).name("post").selected(false).build();
        HttpResult httpResult = defaultHttpClient.httpPost("http://192.168.101.20:8080/test/postTest", null, stationTreeVo);
        System.out.println(httpResult);
        return httpResult.getContent();
    }

}
package com.ka2x.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ka2x.demo.inca.HelloDTO;
import com.ka2x.demo.inca.HelloResp;
import com.ka2x.demo.inca.HelloService;
import com.ka2x.swagger.inca.ClientRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.CallNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;
import java.util.Enumeration;

@Api("jira")
@Slf4j
@RestController
@RequestMapping("/jira")
public class JiraShellController {

    @Resource
    private RestTemplate restTemplate;

    @ApiOperation("like")
    @GetMapping("/like")
    public ResponseEntity<JSONObject> like(
            HttpServletRequest request,
            @RequestParam(value = "commandId",
                    required = false,
                    defaultValue = "14249402") Long commentId
//            , @RequestParam(value = "sessionId",
//            required = false,
//            defaultValue = "") String sessionId
    ) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log.info("cookie = ({}:{})", cookie.getName(), cookie.getValue());
            }
        }
        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = request.getHeader(name);
            log.info("header = ({}:{})", name, value);
        }
        log.info("host: {}", request.getRemoteHost());
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json, text/javascript, */*; q=0.01");
        headers.set("X-Requested-With", "XMLHttpRequest");
        // 豆哥 yyds
        headers.set("Content-Type", "application/json");
        headers.set("referer", "https://wiki.dslbuy.com");
        headers.set("origin", "https://wiki.dslbuy.com");
//        headers.set("cookie", "JSESSIONID=" + sessionId);

        String likeUrl = "https://wiki.dslbuy.com/rest/likes/1.0/content/" + commentId + "/likes";
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                likeUrl,
                HttpMethod.POST,
                entity,
                JSONObject.class);
    }
}

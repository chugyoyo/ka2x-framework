package com.ka2x.demo.controller;

import com.ka2x.common.util.RegExpUtil;
import com.ka2x.demo.inca.HelloDTO;
import com.ka2x.demo.inca.HelloResp;
import com.ka2x.demo.inca.HelloService;
import com.ka2x.swagger.annotation.EnableKa2xApi;
import com.ka2x.swagger.inca.ClientRequest;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "hello api",tags = "api 测试")
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @ApiOperation("hello")
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestHeader(required = false) ClientRequest request) {
        ResponseEntity<HelloResp> responseEntity;
        if (request == null || request.getCommands().isEmpty()) {
            responseEntity = helloService.hello(null, request);
        }else {
            responseEntity = helloService.hello((HelloDTO) request.getCommands().get(1), request);
        }
        log.info("hello");
        log.info("responseEntity -> {}", responseEntity);
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/reg_exp")
    public ResponseEntity<String> regExp() {
        log.info(RegExpUtil.IN_DQ);
        return ResponseEntity.ok(RegExpUtil.IN_DQ);
    }


}

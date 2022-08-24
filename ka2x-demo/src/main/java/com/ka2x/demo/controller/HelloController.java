package com.ka2x.demo.controller;

import com.ka2x.common.util.RegExpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        log.info("hello");
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/reg_exp")
    public ResponseEntity<String> regExp(){
        log.info(RegExpUtil.IN_DQ);
        return ResponseEntity.ok(RegExpUtil.IN_DQ);
    }


}

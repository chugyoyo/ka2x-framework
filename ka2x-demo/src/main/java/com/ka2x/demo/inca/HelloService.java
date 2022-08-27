package com.ka2x.demo.inca;

import com.ka2x.swagger.annotation.Ka2xApi;
import com.ka2x.swagger.inca.ClientRequest;
import com.ka2x.swagger.inca.Command;
import com.ka2x.swagger.inca.Param;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Ka2xApi(desc = "interface about hello")
@Component
public class HelloService {

    @Ka2xApi(desc = "hello main method")
    @Command(value = "cmd.hello")
    public ResponseEntity<HelloResp> hello(@Param(index = 1) HelloDTO helloDTO, ClientRequest request) {
        if (helloDTO == null) {
            return ResponseEntity.badRequest().body(null);
        }
        log.info("helloDTO -> {}", helloDTO);
        HelloResp helloResp = new HelloResp();
        helloResp.setCode(helloDTO.getCode() + 1);
        helloResp.setMessage(helloDTO.getMessage() + "-> hello!!!");
        log.info("helloResp -> {}", helloResp);
        return ResponseEntity.ok(helloResp);
    }
}

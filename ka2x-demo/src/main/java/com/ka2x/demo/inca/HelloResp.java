package com.ka2x.demo.inca;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class HelloResp {
    private String message;

    private int code;

}

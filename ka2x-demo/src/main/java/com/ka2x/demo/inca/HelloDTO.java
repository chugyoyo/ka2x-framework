package com.ka2x.demo.inca;

import com.ka2x.swagger.inca.ParamCommand;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class HelloDTO extends ParamCommand {

    private String message;

    private int code;
}

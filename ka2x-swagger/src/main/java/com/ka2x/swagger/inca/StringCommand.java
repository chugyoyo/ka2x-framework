package com.ka2x.swagger.inca;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StringCommand extends BaseCommand{

    private String command;
}

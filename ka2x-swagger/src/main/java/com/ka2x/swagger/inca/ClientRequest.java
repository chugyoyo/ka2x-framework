package com.ka2x.swagger.inca;

import lombok.Data;

import java.util.Arrays;
import java.util.Vector;

@Data
public class ClientRequest {

    // 可优化的部分：vector阻塞，重复创建request(用ioc存ClientRequest)
    private final Vector<BaseCommand> commands;

    public ClientRequest() {
        commands = new Vector<>();
        commands.add(new StringCommand("cmd.demo"));
        ParamCommand paramCommand = new ParamCommand();
        commands.add(paramCommand);
        commands.add(new StringCommand("array demo"));
    }

    public BaseCommand commandAt(int index) {
        return commands.get(index);
    }
//
//    public boolean addCommand(BaseCommand command) {
//        return commands.add(command);
//    }
//
//    // 填充
//    public void fill(BaseCommand... baseCommands) {
//        commands.addAll(Arrays.asList(baseCommands));
//    }
}

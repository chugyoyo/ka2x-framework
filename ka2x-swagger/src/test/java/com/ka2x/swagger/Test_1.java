package com.ka2x.swagger;

import lombok.Data;
import org.junit.Test;

@Data
public class Test_1 {

    private String s = "12";

    @Test
    public void test_1(){
        System.out.println(1);
        System.out.println(new Test_1().getS());
    }

    public static void main(String[] args) {
    }
}

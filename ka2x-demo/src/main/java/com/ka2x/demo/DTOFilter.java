package com.ka2x.demo;

import com.ka2x.demo.inca.HelloDTO;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
public class DTOFilter {
    final static String bodyText = "orderId\tnumber\t\n" +
            "非必须\n" +
            "订单id\t\n" +
            "patient\tstring\t\n" +
            "必须\n" +
            "患者姓名\t\n" +
            "idcard\tstring\t\n" +
            "必须\n" +
            "身份证\t\n" +
            "phone\tstring\t\n" +
            "必须\n" +
            "患者电话\t\n" +
            "sex\tinteger\t\n" +
            "必须\n" +
            "性别\t\n" +
            "age\tinteger\t\n" +
            "必须\n" +
            "年龄\t\n" +
            "prescribingTime\tstring\t\n" +
            "必须\n" +
            "开方时间\t\n" +
            "prescriptionNo\tstring\t\n" +
            "必须\n" +
            "处方笺号\t\n" +
            "medicalInstitution\tstring\t\n" +
            "必须\n" +
            "医疗机构\t\n" +
            "doctor\tstring\t\n" +
            "必须\n" +
            "医生\t\n" +
            "department\tstring\t\n" +
            "必须\n" +
            "科室\t\n" +
            "diagnosisResult\tstring\t\n" +
            "必须\n" +
            "诊断内容";

    public static void main(String[] args) {
        Field[] fields = HelloDTO.class.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            if (!bodyText.contains(fieldName)) {
                System.out.println(fieldName);
            }
        }
    }
}

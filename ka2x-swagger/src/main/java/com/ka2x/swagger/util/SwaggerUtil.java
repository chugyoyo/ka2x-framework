package com.ka2x.swagger.util;


import com.ka2x.common.util.StringUtil;
import springfox.documentation.spring.web.json.JacksonModuleRegistrar;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.spring.web.json.JsonSerializer;
import springfox.documentation.swagger2.configuration.Swagger2JacksonModule;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * swagger工具类
 * </p>
 *
 * @author ka2x
 * @since 2022/8/28 21:46
 */
public class SwaggerUtil {


    private static final JsonSerializer jsonSerializer;

    static {
        List<JacksonModuleRegistrar> modules = new ArrayList<>();
        modules.add(new Swagger2JacksonModule());
//        modules.add(new Swagger2JacksonModule());
        jsonSerializer = new JsonSerializer(modules);

    }

    public static Json toJson(Object toSerialize) {
        return jsonSerializer.toJson(toSerialize);
    }

    public static String toJsonString(Object toSerialize) {
        return StringUtil.jsonStringFormat(toJson(toSerialize).value());
    }

}

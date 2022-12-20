package com.ka2x.swagger;

import com.ka2x.swagger.util.SwaggerUtil;
import io.swagger.models.*;
import io.swagger.models.properties.*;
import lombok.Data;
import org.junit.Test;

import java.util.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class SwaggerCoreTest {


    @Test
    public void t_1() {
        Swagger swagger = new Swagger();
        List<Tag> tags = new ArrayList<>();
        Tag tag = new Tag();
        tag.setName("basic-error-controller");
        tag.setDescription("Basic Error Controller");
        tags.add(tag);
        swagger.tags(tags);

        System.out.println(SwaggerUtil.toJsonString(swagger));
    }

    @Test
    public void t_2() {
        Swagger swagger = new Swagger();

        HashMap<String, Model> modelMap = new HashMap<>(16);
        HashMap<String, Property> propertyMap1 = new HashMap<>(16);
        ModelImpl model1 = new ModelImpl();
        RefProperty refProperty = new RefProperty("User");
        propertyMap1.put("user", refProperty);
        propertyMap1.put("id", new StringProperty());
        model1.setProperties(propertyMap1);
        modelMap.put("General", model1);

        ModelImpl model2 = new ModelImpl();
        HashMap<String, Property> propertyMap2 = new HashMap<>(16);
        propertyMap2.put("name", new StringProperty());
        model2.setProperties(propertyMap2);
        modelMap.put("User", model2);

        swagger.setDefinitions(modelMap);

        System.out.println(SwaggerUtil.toJsonString(swagger));
    }

    @Test
    public void t_3() {
        Map<String, Path> paths = new HashMap<>(16);
        Path path = new Path();
        paths.put("/abc", path);
        Operation operation = new Operation();
        Response response = new Response();
        RefModel model = new RefModel("User");

        RefProperty refProperty = new RefProperty("User");
        response.setSchema(refProperty);
        operation.addResponse("200", response);
        path.set("post", operation);
        Swagger swagger = new Swagger();
        swagger.paths(paths);

        System.out.println(SwaggerUtil.toJsonString(swagger));

    }

    @Test
    public void t_4() {
        Map<String, Path> paths = new HashMap<>(16);
        Path path = new Path();
        paths.put("/abc", path);
        Operation operation = new Operation();
        Response response = new Response();
        RefModel model = new RefModel("User");

        RefProperty refProperty = new RefProperty("User");
        response.setSchema(refProperty);
        operation.addResponse("200", response);
        path.set("post", operation);
        Swagger swagger = new Swagger();
        swagger.paths(paths);

        System.out.println(SwaggerUtil.toJsonString(swagger));
    }

    @Test
    public void t_5() {
        ArrayList<Long> objects = new ArrayList<>();
        Long a = 1L;
        Long c = a;
        objects.add(a);
        objects.add(c);
        a = 2L;
        System.out.println(Arrays.toString(objects.toArray()));
    }
}

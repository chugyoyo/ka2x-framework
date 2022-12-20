package com.ka2x.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.HashMap;

/**
 * <p>
 * detail: 路径工具
 * 文件夹：如 dir/dir/dir/
 * 文件： 如 file.java
 * </p>
 *
 * @author 吴泽欣
 * @since 2022/8/22 21:43
 **/
@Slf4j
public class PathUtil {

    public static final String PATH_SPLIT = File.separator;

    public static final String PROJECT_DIR = getDirPath(System.getProperty("user.dir"));

    public static final String JAVA_DIR = PROJECT_DIR + getDirPath("src", "main", "java");

    public static final String APP_DIR = JAVA_DIR + getDirPath("com", "dsl", "retail");

    public static final String CODE_GEN_DIR = APP_DIR + getDirPath("util", "generator", "target");

    public static final String RESOURCE_DIR = PROJECT_DIR + getDirPath("src", "main", "resources");

    /**
     * <p>
     * detail: 生成文件夹路径 以分隔符结尾
     * </p>
     *
     * @author 吴泽欣
     * @since 2022/8/22 22:05
     **/
    public static String getDirPath(String... packs) {
        StringBuilder builder = new StringBuilder();
        for (String pack : packs) {
            builder.append(pack).append(PATH_SPLIT);
        }
        return builder.toString();
    }
}

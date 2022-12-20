package com.ka2x.common.util;
import com.ka2x.common.exception.Ka2xException;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * detail: 文件操作工具
 * </p>
 *
 * @author 吴泽欣
 * @since 2022/8/20 23:45
 **/
@Slf4j
public class FileUtil {

    /**
     * <p>
     * detail: 新建文件
     * </p>
     *
     * @param basePath 不包含分隔符的文件夹全路径
     * @param fileName 包含后缀名的文件名
     * @author 吴泽欣
     * @since 2022/8/22 21:36
     **/
    public static String createFile(String basePath, String fileName) throws IOException {
        // 保证文件夹存在
        if (!basePath.endsWith(PathUtil.PATH_SPLIT)) {
            throw new Ka2xException("文件夹路径错误");
        }
        File base = new File(basePath);
        if (!base.exists()) {
            base.mkdirs();
        }
        // 创建文件
        String fileFullPath = basePath + fileName;
        Path file = Paths.get(fileFullPath);
        if (!Files.exists(file)) {
            Files.createFile(Paths.get(fileFullPath));
        }
        return fileFullPath;
    }

    /**
     * <p>
     * detail: 向文件写入字符
     * </p>
     *
     * @param basePath 不包含分隔符的文件夹全路径
     * @param fileName 包含后缀名的文件名
     * @author 吴泽欣
     * @since 2022/8/22 21:21
     **/
    public static void writeStr(String str, String basePath, String fileName) throws IOException {
        String fileFullPath = createFile(basePath, fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileFullPath));
        writer.write(str);
        writer.flush();
        writer.close();
    }

    /**
     * <p>
     * detail: 获取文件夹路径（全路径）下的所有文件路径（全路径）
     * </p>
     *
     * @author 吴泽欣
     * @since 2022/8/20 23:46
     **/
    public static List<String> getAllFilePath(String folderPath) {
        if (folderPath == null) {
            throw new Ka2xException("文件夹");
        }
        File folder = new File(folderPath);
        List<String> filePathList = new ArrayList<>();
        String rootPath;
        if (folder.exists()) {
            String[] fileNameList = folder.list();
            if (null != fileNameList && fileNameList.length > 0) {
                if (folder.getPath().endsWith(File.separator)) {
                    rootPath = folder.getPath();
                } else {
                    rootPath = folder.getPath() + File.separator;
                }
                for (String fileName : fileNameList) {
                    filePathList.add(rootPath + fileName);
                }
            }
        }
        return filePathList;
    }

    /**
     * <p>
     * detail: 读取文本文件内容
     * </p>
     *
     * @author 吴泽欣
     * @since 2022/9/2 14:43
     **/
    public static String readTextFile(String file) {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String contentLine = null;
            do {
                contentLine = reader.readLine();
                builder.append(contentLine);
                builder.append("\n");
            } while (contentLine != null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }

    /**
     * <p>
     * detail: 读取JSON文件内容
     * </p>
     *
     * @author 吴泽欣
     * @since 2022/9/2 14:44
     **/
    public static String readJSONString(String file) {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String contentLine;
            do {
                contentLine = reader.readLine();
                if (contentLine == null) {
                    break;
                }
                for (int i = 0; i < contentLine.length(); i++) {
                    char c = contentLine.charAt(i);
                    if (c == ' ' || c == '\t' || c == '\n') {
                        continue;
                    }
                    if (c == '\"') {
                        builder.append("\\");
                    }
                    builder.append(contentLine.charAt(i));
                }
            } while (contentLine.length() != 0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return builder.toString();
    }


    /**
     * <p>
     * detail: 获取资源路径
     * </p>
     *
     * @author 吴泽欣
     * @since 2022/9/2 15:49
     **/
    public static String getResourcePath(String fileName) {
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        log.info("classLoader -> {}", classLoader);
        URL resource = classLoader.getResource(fileName);
        log.info("resource -> {}", resource);
        return resource != null ? resource.getPath() : null;
    }

}

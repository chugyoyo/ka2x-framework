package com.ka2x.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 重复代码 生成
 *
 * @author Zexin Wu
 * @since 2022/12/20 10:03
 **/
@Slf4j
public class RepeatGenerator {

    /**
     * 项目目录
     */
    private final static String PROJECT_DIR = "C:\\git\\pos-retail\\pos-retail-provider\\src\\main\\java\\com\\dsl\\pos\\retail\\core\\config\\service";

    /**
     * 源表（以实现）
     */
    private final static String FROM_TABLE = "order_prescription";

    public static void main(String[] args) {

        Set<String> fileContains = new HashSet<>();
        fileContains.add(".java");
        String sql = "order_pay_config\n" +
                "order_pay_notify_log\n" +
                "order_pay_result\n" +
                "order_pay_result_amount\n" +
                "order_pay_result_detail\n" +
                "order_pending\n" +
                "order_pending_detail\n" +
                "order_refund\n" +
                "order_refund_detail\n" +
                "order_refund_notify_log\n" +
                "order_refund_result\n" +
                "order_refund_result_amount\n" +
                "order_refund_result_detail";
        String[] split = sql.split("\n");
        Set<String> toSet = new HashSet<>();
        for (String table : split) {
            String trim = table.trim();
            toSet.add(trim);
        }
        log.info("toSet {}", toSet);
        trace(new File(PROJECT_DIR),
                fileContains,
                toSet);
    }

    /**
     * 遍历文件
     *
     * @param fileContains 文件名的匹配（包含关系，例如.java就是匹配java文件）
     * @param toSet        下划线命名的数据库
     * @param src          源目录
     * @author Zexin Wu
     * @since 2022/12/20 10:37
     **/
    public static void trace(File src,
                             Set<String> fileContains,
                             Set<String> toSet) {
        File[] fileArray = src.listFiles();
        if (fileArray != null) {//提高程序的健壮性
            for (File file : fileArray) {
                if (file.isDirectory()) {
                    trace(file, fileContains, toSet);
                    continue;
                }
                for (String contain : fileContains) {
                    if (file.getName().contains(contain)
                            && file.getName().contains(hump(FROM_TABLE, true))
                            && !file.getName().equals(hump(FROM_TABLE, true) + ".java")
                            && file.canRead()
                            && file.canWrite()) {
                        log.info("exec file : {} ", file.getName());
                        exec(file, toSet);
                    }
                }
            }
        }
    }

    private static boolean isTo(String name, Set<String> toSet) {
        for (String to : toSet) {
            if (name.contains(hump(to, true))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 生成
     *
     * @param file  单个可读文件
     * @param toSet 转换关系表 （下划线）
     * @author Zexin Wu
     * @since 2022/12/20 10:38
     **/
    private static void exec(File file, Set<String> toSet) {

        BufferedWriter writer = null;
        BufferedReader reader = null;

        for (String to : toSet) {
            try {
                String classFromName = hump(FROM_TABLE, true);
                String classToName = hump(to, true);
                String fromFiled = hump(FROM_TABLE, false);
                String toField = hump(to, false);
                String absolutePath = file.getAbsolutePath();
                String path = absolutePath.replaceAll(classFromName, classToName);
                // 输出
                writer = new BufferedWriter(new FileWriter(path));
                // 输入
                reader = new BufferedReader(new FileReader(absolutePath));
                String line = reader.readLine();
                while (line != null) {
                    line = line.replaceAll(classFromName, classToName).replaceAll(fromFiled, toField);
                    writer.write(line + "\r\n");
                    line = reader.readLine();
                }
                log.info("SUCCESS TO WRITE {}", path);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 数据库名 转 驼峰
     * <p>
     * "NATION -> nation
     * "HISTORY_OVERDUE -> historyOverdue
     * "ID_CARD_INFO_TITLE -> idCardInfoTitle
     * "ID_1_INFO_TITLE -> id1InfoTitle
     * "A_123_INFO_TITLE -> a123InfoTitle
     * "A_1_INFO_D_TITLE_B -> a1InfoDTitleB
     * "A_1_INFO_TITLE_B_C -> a1InfoTitleBC
     *
     * @param firstUpper 首字母是否大写
     * @author Zexin Wu
     * @since 2022/12/20 11:33
     **/
    public static String hump(String str, boolean firstUpper) {

        // 全部大写
        String[] array = str.toUpperCase().split("_");
        StringBuilder result = new StringBuilder(array[0].toLowerCase());
        if (array.length <= 1) {
            return result.toString();
        }
        for (int i = 1; i < array.length; i++) {
            result.append(array[i], 0, 1);
            if (array[i].length() <= 1) {
                continue;
            }
            result.append(array[i].substring(1).toLowerCase());
        }
        if (firstUpper) {
            result.setCharAt(0, (char) (result.charAt(0) - 32));
        }
        return result.toString();
    }
}

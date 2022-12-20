package com.ka2x.data.util;

import com.ka2x.common.util.FileUtil;

import java.io.IOException;
import java.util.Date;

/**
 * <p>
 * detail: 数据库转换类
 * Oracle To MySQL
 * </p>
 *
 * @author 吴泽欣
 * @since 2022/9/8 16:24
 **/
public class O2MUtil {

    /**
     * <p>
     * detail: 将oracle的建表语句转为mysql的建表语句
     * </p>
     *
     * @author 吴泽欣
     * @since 2022/9/8 16:26
     **/
    public String createTableO2M(String mysqlTableSql) {
        return null;
    }

    public static void main(String[] args) throws IOException {
        String resourcePath = "C:\\Users\\dsl\\IdeaProjects\\ka2x\\ka2x-data\\src\\main\\resources\\";
        String path = resourcePath + "oracle_table.sql";
        String sql = FileUtil.readTextFile(path);
        String result = sql.replaceAll("decimal\\([1-2]\\)", "tinyint")
                .replaceAll("decimal\\([3-4]\\)", "smallint")
                .replaceAll("decimal\\(([5-9]|1[0-8])\\)", "bigint");
        FileUtil.writeStr(result, resourcePath, "mysql_table_" + System.currentTimeMillis() +".sql");
    }
}

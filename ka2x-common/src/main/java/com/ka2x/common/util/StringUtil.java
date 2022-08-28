package com.ka2x.common.util;

public class StringUtil {

    /**
     * <p>
     *    将JSON字符串格式化为可读性更高的JSON字符串
     * </p>
     * @author ka2x
     * @since 2022/8/28 23:36
     */
    public static String jsonStringFormat(String jsonString){

        StringBuilder jsonForMatStr = new StringBuilder();
        int level = 0;
        for(int index=0;index < jsonString.length();index++)//将字符串中的字符逐个按行输出
        {
            //获取s中的每个字符
            char c = jsonString.charAt(index);

            //level大于0并且jsonForMatStr中的最后一个字符为\n,jsonForMatStr加入\t
            if (level > 0  && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
            jsonForMatStr.append(getLevelStr(level));
        }
            //遇到"{"和"["要增加空格和换行，遇到"}"和"]"要减少空格，以对应，遇到","要换行
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c).append("\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c).append("\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }
        return jsonForMatStr.toString();
    }

    //########################## 私有 ##########################

    private static String getLevelStr(int level) {
        StringBuilder levelStr = new StringBuilder();
        for (int levelI = 0; levelI < level; levelI++) {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }
}

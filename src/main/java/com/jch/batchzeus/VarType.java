package com.jch.batchzeus;

import java.util.HashMap;

/**
 * @Author: jiangchenghua
 * @Date: 2021/8/27 3:08 下午
 */
public class VarType {
    static HashMap<String, Integer> map = new HashMap();

    static {
        map.put("布尔型", 0);
        map.put("整型", 1);
        map.put("长整型", 2);
        map.put("浮点型", 3);
        map.put("双精度型", 4);
        map.put("字符串型", 5);
        map.put("高精度型", 6);
    }

    String key;
    String value;

    public static int getType(String key) {
        return map.get(key);
    }
}

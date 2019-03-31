package com.springboot.mybatis.util;

import java.util.Random;

/**
 * 随机数工具类
 */
public class RandomUtil {
    public static String getRandomCode() {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            //生成[0,bound)的随机整数
            int num = random.nextInt(10);
            //将随机数加入可变长字符串
            stringBuffer.append(num);
        }
        return stringBuffer.toString();
    }
}

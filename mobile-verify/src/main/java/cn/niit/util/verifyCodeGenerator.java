package cn.niit.util;

import java.util.Random;

/**
 * Created by 潘炳稳 on 2019/4/14.
 */
public class verifyCodeGenerator {
//    生成验证码
public static String getVerifyCode()
{
    Random random=new Random();
StringBuffer stringBuffer=new StringBuffer();
for (int i=0;i<6;i++)
{
    stringBuffer.append(String.valueOf(random.nextInt(10)));
}
    System.out.println(stringBuffer.toString());
    return  stringBuffer.toString();
}
}

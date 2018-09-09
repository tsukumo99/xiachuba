package org.lanqiao.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @作者：dhc
 * @创建时间：16:30 2018/9/2
 * @描述：获得当前日期的字符串，格式为“yyyy-MM-dd HH:mm:ss”
 */
public class GetDateString {
    public static String getCurrDateString(){
        String model="yyyy-MM-dd HH:mm:ss";  //指定格式化的模板
        Date now  = new Date();
        SimpleDateFormat dateFormat2=new SimpleDateFormat(model);
        return dateFormat2.format(now);
    }
}

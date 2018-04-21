package com.cs.SchoolSystem.controller.converter;

/**
 * Created by asus on 2018/4/13.
 */

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentMap;

/**
 * 参数绑定 字符串日期转换器
 */
public class CustomDateConverter implements Converter<String,Date>{
    @Override
    public Date convert(String s) {
        //实现将日期串转换成日期类型（格式是：yyyy-MM-dd)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //如果参数绑定失败返回null
        return null;
    }
}

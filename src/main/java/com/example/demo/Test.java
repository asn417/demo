package com.example.demo;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args)  throws ParseException {
        int len = 9;
        int[] arr = new int[len + 1];
        for (int i=0;i<10;i++){
            arr[len--] = i;
        }
        for (int i:arr
             ) {
            System.out.println(i);
        }
    }

    /**
     * 根据date1和date2算出相差几个月
     * @param date1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static int getMonthCount(String date1,String date2)  throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));
        int year =c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR);
        //开始日期若小月结束日期
        if(year<0){
            return 0;
        }
        return year*12+c2.get(Calendar.MONTH)-c1.get(Calendar.MONTH);
    }

    /**
     * java8(经测试别的版本获取2月有bug) 获取某月第一天的00:00:00
     * @return
     */
    public static String getFirstDayOfMonth(String datestr){
        if (StringUtils.isBlank(datestr)) return  null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(datestr, pos);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());;
        LocalDateTime endOfDay = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        Date dates = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
        return sdf.format(dates);
    }
    /**
     * java8(别的版本获取2月有bug) 获取某月最后一天的23:59:59
     * @return
     */
    public static String getLastDayOfMonth(String datestr){
        if (StringUtils.isBlank(datestr)) return  null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(datestr, pos);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());;
        LocalDateTime endOfDay = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        Date dates = Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
        return sdf.format(dates);
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM( 2017-02)
     * @param strDate
     * @return
     */
    public static Date strToDateNotDD(String strDate) {
        if (StringUtils.isBlank(strDate)) return null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

}

package com.dc.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateUtils {

    /**
     * mongo 日期查询isodate
     * <p>
     * <p>
     * 如果相差8小时，加上这句代码
     * format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
     *
     * @param dateStr
     * @return
     */
    public Date dateToISODate(String dateStr) {

        Date parse = null;

        try {
            dateStr = dateStr +" 08:00:00";
            // 解析字符串时间
            Date date = new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(dateStr);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//            format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
            parse = format.parse(format.format(date));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return parse;
    }

    public String dateToStr(Date date){
        String dateStr = "";
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//            format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
            dateStr = format.format(date);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

}

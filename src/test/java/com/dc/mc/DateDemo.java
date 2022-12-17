package com.dc.mc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String begintTime = "20190326";
        String endTime =  "20191204";
        for(String days: findDaysStr(begintTime,endTime)){
            System.out.println(days);
        }
    }

    public static List<String> findDaysStr(String begintTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date dBegin = null;
        Date dEnd = null;
        try {
            dBegin = sdf.parse(begintTime);
            dEnd = sdf.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<String> daysStrList = new ArrayList<String>();
        daysStrList.add(sdf.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (dEnd.after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            String dayStr = sdf.format(calBegin.getTime());
            daysStrList.add(dayStr);
        }
        return daysStrList;
    }

}

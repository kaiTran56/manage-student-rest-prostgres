package com.tranquyet.util.excel.table;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AutoNameGeneration {

    public static String getName(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("excel_").append(dateFormat.format(date)+"_statistic").append(".xlsx");
        return stringBuilder.toString();
    }

}

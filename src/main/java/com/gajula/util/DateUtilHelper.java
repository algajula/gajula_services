package com.gajula.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

public class DateUtilHelper {

    private final static Logger admin = LogManager.getLogger(DateUtilHelper.class);

    public final static DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
    public final static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    public static Date convertStringtoDate(String reqdate){
        //input 2025-01-20 18:30:00
        Date date;
        try{
            admin.info("Req Date==============="+reqdate);
            date = format.parse(reqdate);
            System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
        }catch (Exception e){
            admin.error("ReqDate Error=="+e.getMessage());
            return new Date();
        }
        return date;
    }

    public static boolean isTodaysDate(String reqdate) {
        try {
            LocalDate input = LocalDate.parse(reqdate, dateFormat);
            LocalDate todayDate = LocalDate.now();
            //todayDate.format(dateFormat);
            admin.info(input+" ==== "+todayDate);
            if( input.isBefore(todayDate) || input.isAfter(todayDate)){
                return false;
            }
        }catch(DateTimeParseException ex) {
            ex.printStackTrace();
            return true;
        }
        return true;
    }
}

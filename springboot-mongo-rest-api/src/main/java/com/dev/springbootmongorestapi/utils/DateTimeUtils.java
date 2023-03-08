package com.dev.springbootmongorestapi.utils;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class DateTimeUtils {

    private static final int ORG_YEAR = 1945;
    private static final int UPDATE_YEAR = 2016;
    private final String DATE_TIME_FORMAT = "YYYY-MM-dd HH:mm";
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    public LocalDateTime asLocalDateTime(String str){
        return LocalDateTime.parse(str, dateTimeFormatter);
    }
    public String asString(LocalDateTime datetime){
        return datetime.format(dateTimeFormatter);
    }

    public static Date getStartDay(Date date){
        Calendar calendar = Calendar.getInstance();
        if(null != date){
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY,0);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.MILLISECOND,0);
            calendar.set(Calendar.SECOND,0);
            return calendar.getTime();
        }
        return null;
    }

    public static Date getEndDay(Date date){
        Calendar calendar = Calendar.getInstance();
        if(null!=date){
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY,23);
            calendar.set(Calendar.MINUTE,59);
            calendar.set(Calendar.SECOND,59);
            return calendar.getTime();
        }
        return null;
    }

    public static Date convertFromStringToDate(String dateString){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date;
        try {
            date = dateFormat.parse(dateString);
            return date;
        }catch (ParseException pex){
            pex.printStackTrace();
        }
        return null;
    }

    public static String convertFromDateToString(Date date){
         date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public static String convertFromDateToString2(String date){
        LocalDate givenDate = LocalDate.parse(date);
        String dateToString = givenDate.toString();
        return dateToString;
    }

    public static int randBetween(int start, int end){
        return start + (int) (Math.round(Math.random() * (end - start)));
    }

    public static String birthdayRandom(){
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(ORG_YEAR,UPDATE_YEAR);
        gc.set(gc.YEAR,year);
        int dayOfYear = randBetween(1,gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR,dayOfYear);
        return gc.toZonedDateTime().toLocalDateTime().toString();
    }


}

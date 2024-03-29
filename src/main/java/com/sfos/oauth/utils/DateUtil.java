package com.sfos.oauth.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static boolean beforeToday(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date yesterday = calendar.getTime();
        return date.before(yesterday);
    }

    public static boolean beforeToday(LocalDateTime date) {
        LocalDate localDate = date.toLocalDate();
        LocalDate nowDate = LocalDate.now();
        return localDate.isBefore(nowDate);
    }
}

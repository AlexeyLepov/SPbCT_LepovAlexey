package com.company;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat forMonth = new SimpleDateFormat("MMMM");
        SimpleDateFormat forWeek = new SimpleDateFormat("EEEE");

        String[] ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
        if (ids.length == 0)
            System.exit(0);
        SimpleTimeZone pdt = new SimpleTimeZone(-8 * 60 * 60 * 1000, ids[0]);
        pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
        pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);

        Calendar calendar = new GregorianCalendar(pdt);
        Date trialTime = new Date();
        calendar.setTime(trialTime);

        System.out.println("Месяц: " + forMonth.format(calendar.getTime()));
        System.out.println("День недели: " + forWeek.format(calendar.getTime()));
        System.out.println("Имя: " + System.getProperty("user.name"));
    }
}

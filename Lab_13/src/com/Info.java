package com;

import app.LocaleExplorer;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Currency;

public class Info {
    public static void info ()
    {
        System.out.println(LocaleExplorer.message("country", LocaleExplorer.locale.
                getDisplayCountry(LocaleExplorer.locale)));
        System.out.println(LocaleExplorer.message("language", LocaleExplorer.locale.
                getDisplayLanguage(LocaleExplorer.locale)));
        System.out.println(LocaleExplorer.message("currency", Currency.
                getInstance(LocaleExplorer.locale).getDisplayName()));

        DateFormatSymbols symbols = DateFormatSymbols.getInstance(LocaleExplorer.locale);
        System.out.print(LocaleExplorer.message("weekDays"));
        for (String item : symbols.getWeekdays())
        {
            System.out.print(item + " " );
        }
        System.out.println(" ");
        System.out.print(LocaleExplorer.message("months"));
        for (String item : symbols.getMonths())
        {
            System.out.print(item+ " ");
        }
        System.out.println(" ");
        System.out.println(LocaleExplorer.message("today", Calendar.getInstance().
                getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, LocaleExplorer.locale)));
    }
}

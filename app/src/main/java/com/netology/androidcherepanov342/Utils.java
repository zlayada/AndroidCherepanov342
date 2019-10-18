package com.netology.androidcherepanov342;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;

import java.util.Locale;

public class Utils {
    final static int THEME_SMALL = 0;
    final static int THEME_AVERAGE = 1;
    final static int THEME_BIG= 2;

    final static String LOCAL_EN = "en";
    final static String LOCAL_RU = "ru";


    private static int sTheme = THEME_SMALL;
    private static String sLocale = LOCAL_RU;

    static void changeSettings(Activity activity, int theme, String locale) {
        sTheme = theme;
        sLocale = locale;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    static void onActivityCreateApplySettings(Activity activity) {
        Locale locale = new Locale(sLocale);
        Configuration config = new Configuration();

        config.setLocale(locale);
        activity.getResources().updateConfiguration(config,activity.getBaseContext().getResources()
                .getDisplayMetrics());

        switch (sTheme) {

            case THEME_SMALL:
                activity.setTheme(R.style.ThemeSmall);
                break;
            case THEME_AVERAGE:
                activity.setTheme(R.style.ThemeAverage);
                break;
            case THEME_BIG:
                activity.setTheme(R.style.ThemeBig);
                break;

            default:
                break;
        }
    }
}

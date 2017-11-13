package com.example.kuba.timer;

import android.os.SystemClock;

/**
 * Created by Kuba on 30/05/2017.
 */

public class Time {
    public static long time(long time1){
        long time2 = SystemClock.uptimeMillis();
        return time2-time1;
    }
}

package com.practice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IdleUserChecker {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void startIdleUserCheck() {
        scheduler.scheduleAtFixedRate(
            () -> UserActivitySessionListener.checkIdleUsers(),
            0, 1, TimeUnit.MINUTES);
    }

    public static void stopIdleUserCheck() {
        scheduler.shutdown();
    }
}


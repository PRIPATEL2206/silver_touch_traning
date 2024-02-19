package com.practice;

public class IdleUserCheckerThread extends Thread {

    private static final long INTERVAL = 1; //60 * 1000; // 1 minute

    public void run() {
        while (true) {
            try {
                Thread.sleep(INTERVAL);
                UserActivitySessionListener.checkIdleUsers();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

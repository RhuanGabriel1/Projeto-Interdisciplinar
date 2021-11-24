package com.example.imed.Helper;

public class TimeOut {

    public void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

    public void timeWait(int time){
        long start = System.currentTimeMillis();
        long end = start + time;
        while (System.currentTimeMillis() < end) {
            // Some expensive operation on the item.
        }

    }

}

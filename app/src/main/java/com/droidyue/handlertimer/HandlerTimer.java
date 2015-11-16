package com.droidyue.handlertimer;

import android.os.Handler;
import android.os.Message;

/**
 * Created by androidyue on 11/16/15.
 */
public class HandlerTimer {
    private static class DelayTask {
        Runnable task;
        long interval;
    }

    private static final int MESSAGE_REPEAT = 0;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == MESSAGE_REPEAT) {
                DelayTask task = (DelayTask)msg.obj;
                task.task.run();
                repeatRunnable(task.task, task.interval);
            }
        }
    };
    private static HandlerTimer sInstance = new HandlerTimer();

    public void repeatRunnable(Runnable task, long interval) {
        Message msg = Message.obtain();
        msg.what = MESSAGE_REPEAT;
        DelayTask delayTask = new DelayTask();
        delayTask.interval = interval;
        delayTask.task = task;
        msg.obj = delayTask;
        mHandler.sendMessageDelayed(msg, interval);
    }

    public static HandlerTimer getInstance() {
        return sInstance;
    }
}

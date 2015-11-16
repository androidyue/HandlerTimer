package com.droidyue.handlertimer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String LOGTAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandlerTimer timer = HandlerTimer.getInstance();
        timer.repeatRunnable(new Runnable() {
            @Override
            public void run() {
                Log.i(LOGTAG, "CurrentTime=" + System.currentTimeMillis());
            }
        }, 6000);
    }


}

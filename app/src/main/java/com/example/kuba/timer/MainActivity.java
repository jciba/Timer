package com.example.kuba.timer;

import android.content.pm.ActivityInfo;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    TextView text2;
    Button bt1;
    Button bt2;
    static long start_time;
    static String str;
    static String st = "";
    Thread t= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        text2 = (TextView) findViewById(R.id.text2);
        text2.setMovementMethod(new ScrollingMovementMethod());
        start_time=0;
    }

    public void star(View view){
        start_time= SystemClock.uptimeMillis();
        text2.setText("");
        st="";
            t = new Thread(){
            @Override
            public void run() {
                try{
                    while (!isInterrupted()){
                     Thread.sleep(1);
                     runOnUiThread(new Runnable() {
                         @Override
                         public void run() {
                             text1= (TextView) findViewById(R.id.text1);
                             long time = SystemClock.uptimeMillis()-start_time;
                             int ms = (int) (time%1000);
                             int sec = (int) ((time/1000));
                             int sec1 = sec%60;
                             int min = sec/60;
                             int min1 = min%60;
                             int h = min/60;
                             str = h+":"+min1+":"+sec1+":"+ms;
                             text1.setText(str);
                         }
                     });
                    }
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }

            }
        };
        t.start();



    }
    public void stop(View view){
        if(t!=null){
            t.interrupt();
        }


    }
    public void log(View view){
        st = str + "\n"+ st;
        text2.setText(st);


    }
}

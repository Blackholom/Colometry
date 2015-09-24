package com.color.geometry.rubikon.colometry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Kevin on 24/09/2015.
 */
public class CountActivity extends Activity {

    public TextView counter, ready;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count);
        counter = (TextView)findViewById(R.id.counterView);
        ready = (TextView)findViewById(R.id.ready_txt);
        countInit();
    }

    public void countInit(){
        new CountDownTimer(4000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                counter.setText(""+(millisUntilFinished/1000));
                counter.setTextSize(90);
            }

            @Override
            public void onFinish() {
                ready.setVisibility(View.VISIBLE);
                Intent newActivity = new Intent(CountActivity.this, QuestionActivity.class);
                startActivity(newActivity);
                finish();
            }
        }.start();
    }
}

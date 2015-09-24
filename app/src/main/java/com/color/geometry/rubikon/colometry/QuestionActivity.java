package com.color.geometry.rubikon.colometry;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * Created by Kevin on 24/09/2015.
 */
public class QuestionActivity extends Activity {

    public ImageButton optA, optB, optC, optD;
    public TextView instruc, txtcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        optA = (ImageButton)findViewById(R.id.optionA);
        optB = (ImageButton)findViewById(R.id.optionB);
        optC = (ImageButton)findViewById(R.id.optionC);
        optD = (ImageButton)findViewById(R.id.optionD);

        instruc = (TextView)findViewById(R.id.instruction);
        txtcount = (TextView)findViewById(R.id.txtcountd);

        countInit();
    }

    public void countInit(){
        new CountDownTimer(11000, 1){

            @Override
            public void onTick(long millisUntilFinished) {

                Double mili = new Long(millisUntilFinished).doubleValue();

                txtcount.setText(""+(mili/1000));
            }

            @Override
            public void onFinish() {
                Intent newActivity = new Intent(QuestionActivity.this, MenuActivity.class);
                startActivity(newActivity);
                finish();
            }
        }.start();
    }
}

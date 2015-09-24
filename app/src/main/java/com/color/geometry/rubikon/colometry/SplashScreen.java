package com.color.geometry.rubikon.colometry;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends Activity {

    public static final int seconds=3;
    public static final int miliseconds=seconds*1000;
    //private ProgressBar pbprogreso;
    public static final int delay=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //pbprogreso=(ProgressBar)findViewById(R.id.pbprogreso);
        //pbprogreso.setMax(max_progress());



        empezaranimacion();
    }

    public void empezaranimacion(){
        new CountDownTimer(miliseconds, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                //pbprogreso.setProgress(establecer_progreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent newfront = new Intent(SplashScreen.this, MenuActivity.class);
                startActivity(newfront);
                finish();
            }
        }.start();
    }

    /*public  int  establecer_progreso(long milisecond){
        return (int) ((miliseconds-milisecond)/1000);
    }**/

    /*public int max_progress(){
        return seconds-delay;
    }**/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

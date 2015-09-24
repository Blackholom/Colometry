package com.color.geometry.rubikon.colometry;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

public class Result2PActivity extends ActionBarActivity {

    private int rightP1, wrongP1, rightP2, wrongP2;
    private double avgTimeP1, avgTimeP2;
    private static double time = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2_p);

        /*CAMBIAR SI SE USA BD*/
        Intent intent = getIntent();
        rightP1 = intent.getIntExtra("", 0);
        wrongP1 = intent.getIntExtra("", 0);
        rightP2 = intent.getIntExtra("", 0);
        wrongP2 = intent.getIntExtra("", 0);

        avgTimeP1 = (rightP1 + wrongP1)/time;
        avgTimeP2 = (rightP2 + wrongP2)/time;

        TextView textCorrectP1 =(TextView)findViewById(R.id.textViewCorrectP1);
        textCorrectP1.setText(rightP1 +"");

        TextView textWrongP1 =(TextView)findViewById(R.id.textViewWrongP1);
        textWrongP1.setText(wrongP1+"");

        TextView textTimeP1 =(TextView)findViewById(R.id.textViewTimeP1);
        textTimeP1.setText(avgTimeP1+"");

        TextView textCorrectP2 =(TextView)findViewById(R.id.textViewCorrectP2);
        textCorrectP2.setText(rightP2 +"");

        TextView textWrongP2 =(TextView)findViewById(R.id.textViewWrongP2);
        textWrongP2.setText(wrongP2+"");

        TextView textTimeP2 =(TextView)findViewById(R.id.textViewTimeP2);
        textTimeP2.setText(avgTimeP2+"");

        /*TOTAL PLAYER 1 ANSWERS' CIRCLE DRAWING*/
        Bitmap bitmapP1 = Bitmap.createBitmap((int) getWindowManager().getDefaultDisplay().getWidth(), (int) getWindowManager().getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvasP1 = new Canvas(bitmapP1);

        ImageView totalP1 = (ImageView)findViewById(R.id.imgTotalP1);
        totalP1.setImageBitmap(bitmapP1);

        /*TOTAL PLAYER 2 ANSWERS' CIRCLE DRAWING*/
        Bitmap bitmapP2 = Bitmap.createBitmap((int) getWindowManager().getDefaultDisplay().getWidth(), (int) getWindowManager().getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvasP2 = new Canvas(bitmapP1);

        ImageView totalP2 = (ImageView)findViewById(R.id.imgTotalP2);
        totalP2.setImageBitmap(bitmapP2);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        if (rightP1 > rightP2) {
            paint.setColor(Color.GREEN);
            canvasP1.drawCircle(250, 300, 250, paint);
            paint.setColor(Color.RED);
            canvasP2.drawCircle(800, 300, 250, paint);
        }
        else if (rightP1 < rightP2) {
            paint.setColor(Color.RED);
            canvasP1.drawCircle(250, 300, 250, paint);
            paint.setColor(Color.GREEN);
            canvasP2.drawCircle(800, 300, 250, paint);
        }
        else {
            paint.setColor(Color.GRAY);
            canvasP1.drawCircle(250, 300, 250, paint);
            canvasP2.drawCircle(800, 300, 250, paint);
        }

        paint.setColor(Color.WHITE);
        paint.setTextSize(300);
        paint.setTextAlign(Paint.Align.CENTER);

        canvasP1.drawText((rightP1 + wrongP1) + "", 250, 400, paint);
        canvasP2.drawText((rightP2 + wrongP2) + "", 800, 400, paint);
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

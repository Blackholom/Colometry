package com.color.geometry.rubikon.colometry;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Result1PActivity extends ActionBarActivity {

    private int right, wrong;
    private double  avgTime;
    private static double time = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1_p);

        /*TOTAL ANSWERS' CIRCLE DRAWING*/
        Bitmap bitmap = Bitmap.createBitmap((int) getWindowManager().getDefaultDisplay().getWidth(), (int) getWindowManager().getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);

        ImageView total = (ImageView)findViewById(R.id.imgTotal);
        total.setImageBitmap(bitmap);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(300, 300, 250, paint);

        paint.setColor(Color.WHITE);
        paint.setTextSize(300);
        paint.setTextAlign(Paint.Align.CENTER);

        canvas.drawText((right + wrong) + "", 300, 370, paint);

        /*CAMBIAR SI SE USA LA BD Y NO INTENTS*/
        Intent intent = getIntent();
        right = intent.getIntExtra("", 0);
        wrong = intent.getIntExtra("", 0);

        avgTime = (right + wrong)/time;

        TextView textCorrect =(TextView)findViewById(R.id.textViewCorrect1P);
        textCorrect.setText(right+"");

        TextView textWrong =(TextView)findViewById(R.id.textViewWrong1P);
        textWrong.setText(wrong+"");

        TextView textTime =(TextView)findViewById(R.id.textViewTime1P);
        textTime.setText(avgTime+"");
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
package com.color.geometry.rubikon.colometry;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class MenuActivity extends ActionBarActivity {

    private ImageButton ayuda;
    private ImageButton onePlayer;
    private ImageButton twoPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ayuda=(ImageButton) findViewById(R.id.ayuda);
        onePlayer=(ImageButton) findViewById(R.id.onePlayer);
        twoPlayer=(ImageButton) findViewById(R.id.twoPlayers);
        events();
    }

    public void help(View view){
        Intent i = new Intent(this, PopUpWindowHelp.class);
        startActivity(i);
    }

    public void onePlayer(View view){
        //Intent i = new Intent(this, GameVsPerson.class);
        //startActivity(i);
    }

    public void twoPlayers(View view){
        //Intent i = new Intent(this, GameVsMachine.class);
        //startActivity(i);
    }

    public void events(){
        onePlayer.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_int = new Intent(MenuActivity.this, CountActivity.class);
                startActivity(new_int);
                finish();
            }
        });

        twoPlayer.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_int = new Intent(MenuActivity.this, CountActivity.class);
                startActivity(new_int);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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

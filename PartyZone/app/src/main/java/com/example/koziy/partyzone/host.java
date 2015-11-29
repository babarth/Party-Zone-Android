package com.example.koziy.partyzone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class host extends Activity {


    private Button enter;
    private EditText address;
    private  String partyAddress;
    private ImageButton home;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.activity_host);

        enter = (Button) findViewById(R.id.enter);
        address = (EditText) findViewById(R.id.address);
        home = (ImageButton) findViewById(R.id.home);
        cancel = (Button) findViewById(R.id.cancel);


        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                partyAddress = address.getText().toString();
                Intent myIntent = new Intent(host.this, showAddressList.class);
                host.this.startActivity(myIntent);
                showAddressList.ADDRESS = partyAddress;
                Log.d("addr", partyAddress);
                Log.d("addr", showAddressList.ADDRESS);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(host.this, hostOrFind.class);
                host.this.startActivity(myIntent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(host.this, HomeActivity.class);
                host.this.startActivity(myIntent);
            }
        });
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN)
            if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
                address.setText("");
                return true;
            }
        return false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        boolean done = false;
        if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == KeyEvent.ACTION_DOWN){
            address.setText("");
        }
        else if(event.getAction() == MotionEvent.ACTION_UP){
            done = true;
        }

        return done;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_host, menu);
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

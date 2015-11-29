package com.example.koziy.partyzone;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import com.example.koziy.partyzone.host;

/**
 * Created by koziy on 11/16/2015.
 */
public class showAddressList extends ListActivity{

    public ArrayList<String> addressList = new ArrayList<String>();
    private Button map;
    private String address;
    public static String ADDRESS;
    private ImageButton home;
    private ImageButton settings;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.activity_list_parties);

        home = (ImageButton) findViewById(R.id.home);
        settings = (ImageButton) findViewById(R.id.settings);
        map = (Button) findViewById(R.id.Map);

        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(showAddressList.this, showAddress.class);
                showAddressList.this.startActivity(myIntent);
            }
        });

        int cnt = 0;
        addressList.add("Party " + Integer.toString(cnt) + ADDRESS);
        // Adding song_list_items to ListView
        ListAdapter adapter = new addressListAdapter(this, R.layout.address_list_item, this.addressList);


        setListAdapter(adapter);

        ListView lv = getListView();


        // listening to single song_list_item click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // getting song_list_item index
                int songIndex = position;

                // Starting new intent
                Intent intent = new Intent(getApplicationContext(),showAddress.class);

                // Sending songIndex to PlayerActivity
                intent.putExtra("songIndex", songIndex);
                setResult(RESULT_OK, intent);

                // Closing SongListView
                finish();
            }
        });


        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(showAddressList.this, login.class);
                showAddressList.this.startActivity(myIntent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(showAddressList.this, HomeActivity.class);
                showAddressList.this.startActivity(myIntent);
            }
        });


    }

}

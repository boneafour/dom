package com.example.user.dom.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.user.dom.R;

public class MainActivity extends Activity {

    private TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.app_name));

        GridView gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                if(position==0){
                    startActivity(new Intent(MainActivity.this, Cook.class));
                }
                else if (position==1){
                    startActivity(new Intent(MainActivity.this, Clean.class));
                }
                else if(position==2){
                    startActivity(new Intent(MainActivity.this, Wash.class));
                }
                else if(position==3){
                    startActivity(new Intent(MainActivity.this, Contact.class));
                }
                else if(position==4){
                    startActivity(new Intent(MainActivity.this, Table.class));
                }
            }
        });
    }
}


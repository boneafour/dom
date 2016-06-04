package com.example.user.dom.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.dom.R;

import java.util.ArrayList;
import java.util.List;


public class ContactList extends Activity implements View.OnClickListener{

    ListView lview;
    ContactListAdapter lviewAdapter;
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<String> fullnameA, roleA, phoneA, emailA, commentA;
    private TextView txtTitle;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);

        List<ContactData> contacts = db.getAllContacts();
        fullnameA = new ArrayList<String>();
        roleA = new ArrayList<String>();
        phoneA = new ArrayList<String>();
        emailA = new ArrayList<String>();
        commentA = new ArrayList<String>();
        for(ContactData cn : contacts){
            String a = cn.getName();
            fullnameA.add(a);
            String b = cn.getRole();
            roleA.add(b);
            String c = cn.getPhone();
            phoneA.add(c);
            String d = cn.getComment();
            commentA.add(d);
        }
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.listcon));

           lview = (ListView) findViewById(R.id.listView2);
           lviewAdapter = new ContactListAdapter(this, fullnameA, roleA, phoneA,  commentA);
           lview.setAdapter(lviewAdapter);


        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                NavUtils.navigateUpFromSameTask(this);
                break;
        }
    }
}



package com.example.user.dom.main;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.dom.R;

import java.util.ArrayList;
import java.util.List;


public class Table extends Activity implements View.OnClickListener {

	ListView lview;
	TableListAdapter lviewAdapter;
	DatabaseHandler db = new DatabaseHandler(this);
	ArrayList<String> name, list1, date, time, cook, role, list2, comment;
	private TextView txtTitle;
	private ImageButton btnBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_table);

		name = new ArrayList<String>();
		list1 = new ArrayList<String>();
		date = new ArrayList<String>();
		time = new ArrayList<String>();
		cook = new ArrayList<String>();
		role = new ArrayList<String>();
		list2 = new ArrayList<String>();
		comment = new ArrayList<String>();

		List<CookData> cooks = db.getAllCook();
		for (CookData cn : cooks) {
			String a = "Готовка";
			name.add(a);
			String b = cn.getCookList();
			list1.add(b);
			String c = cn.getCookDate();
			date.add(c);
			String d = cn.getCookTime();
			time.add(d);
			String e = cn.getCookBreakfast();
			cook.add(e);
			String f = cn.getCookRole();
			role.add(f);
			String g = cn.getCookVega();
			list2.add(g);
			String h = cn.getCookComment();
			comment.add(h);
		}
		List<CleanData> cleans = db.getAllCleans();
		for (CleanData cn : cleans) {
			String a = "Уборка";
			name.add(a);
			String b = cn.getCleanList();
			list1.add(b);
			String c = cn.getCleanData();
			date.add(c);
			String d = cn.getCleanTime();
			time.add(d);
			String e = "";
			cook.add(e);
			String f = cn.getCleanRole();
			role.add(f);
			String g = cn.getCleanWork();
			list2.add(g);
			String h = cn.getCleanComment();
			comment.add(h);
		}
		List<WashData> washs = db.getAllWash();
		for (WashData cn : washs) {
			String a = "Стирка";
			name.add(a);
			String b = cn.getWashList();
			list1.add(b);
			String c = cn.getWashDate();
			date.add(c);
			String d = cn.getWashTime();
			time.add(d);
			String e = "";
			cook.add(e);
			String f = cn.getWashRole();
			role.add(f);
			String g = cn.getWashColor();
			list2.add(g);
			String h = cn.getWashComment();
			comment.add(h);
		}

		txtTitle = (TextView) findViewById(R.id.txtTitle);
		txtTitle.setText(getString(R.string.listplan));
		lview = (ListView) findViewById(R.id.listView2);
		lviewAdapter = new TableListAdapter(this, name, list1, date, time, cook, role, list2, comment);
		lview.setAdapter(lviewAdapter);


		btnBack = (ImageButton) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		PopupMenu popup = new PopupMenu(Table.this, lview);
		popup.getMenuInflater().inflate(R.menu.menu, popup.getMenu());

		//registering popup with OnMenuItemClickListener
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(Table.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
				return true;
			}
		});

		popup.show();//showing popup menu


		switch (v.getId()) {
			case R.id.btnBack:
				NavUtils.navigateUpFromSameTask(this);
				break;
		}
	}


}





	/*@Override
	public boolean onPrepareOptionsMenu(Menu menu) {

		// Get current time in nano seconds.
		long pressTime = System.currentTimeMillis();


		// If double click...
		if (pressTime - lastPressTime <= DOUBLE_PRESS_INTERVAL) {
			Toast.makeText(getApplicationContext(), "Double Click Event", Toast.LENGTH_SHORT).show();
			mHasDoubleClicked = true;
		}
		else {     // If not double click....
			mHasDoubleClicked = false;
			Handler myHandler = new Handler() {
				public void handleMessage(Message m) {
					if (!mHasDoubleClicked) {
						Toast.makeText(getApplicationContext(), "Single Click Event", Toast.LENGTH_SHORT).show();
					}
				}
			};
			Message m = new Message();
			myHandler.sendMessageDelayed(m,DOUBLE_PRESS_INTERVAL);
		}
		// record the last time the menu button was pressed.
		lastPressTime = pressTime;
		return true;
	}*/


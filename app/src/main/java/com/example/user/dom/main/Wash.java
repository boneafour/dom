package com.example.user.dom.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.dom.R;
import com.guna.libmultispinner.MultiSelectionSpinner;

import java.util.ArrayList;
import java.util.List;


public class Wash extends Activity implements View.OnClickListener, MultiSelectionSpinner.OnMultipleItemsSelectedListener  {

	private TextView txtTitle;
	private ImageButton btnBack;
	Spinner timeSpinner, list, res;
	EditText Data, comment;
	String ListS, DataS, TimeS, ResS, TypeS,  CommentS;
	DatabaseHandler db = new DatabaseHandler(this);
	MultiSelectionSpinner works;
	String[] array = {"Лук", "Марковка", "Картошка", "Капуста", "Помидор", "Огурцы"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dish);

		db = new DatabaseHandler(this);
		List<ContactData> contacts = db.getAllContacts();
		ArrayList<String> roleList = new ArrayList<String>();
		for(ContactData cn : contacts){
			String s = cn.getRole();
			roleList.add(s);
		}

		txtTitle = (TextView) findViewById(R.id.txtTitle);
		txtTitle.setText(getString(R.string.washSt));
		list = (Spinner) findViewById(R.id.list_item);
		timeSpinner = (Spinner) findViewById(R.id.time);
		res = (Spinner) findViewById(R.id.responsility);
		ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, roleList);
		res.setAdapter(adapter);
		works = (MultiSelectionSpinner) findViewById(R.id.mySpinner);
		works.setItems(array);
		works.setListener(this);
		Data = (EditText) findViewById(R.id.date);
		comment = (EditText) findViewById(R.id.comment);

		Button send = (Button) findViewById(R.id.send);
		send.setOnClickListener(this);
		btnBack = (ImageButton) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(this);


	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btnBack:
				NavUtils.navigateUpFromSameTask(this);
				break;
			case R.id.send:
				ListS = ""+list.getSelectedItem().toString();
				DataS = ""+Data.getText();
				Data.setText("");
				TimeS = ""+timeSpinner.getSelectedItem().toString();
				ResS = res.getSelectedItem().toString();
				TypeS = works.getSelectedItem().toString();
				CommentS = ""+comment.getText();
				comment.setText("");

				db.addWash(new WashData(ListS, DataS, TimeS, ResS, TypeS, CommentS));
				List<WashData> washs = db.getAllWash();
				for (WashData cn : washs) {
					String log = "Id: "+cn.getWashID() +" ,List: " + cn.getWashList() + " ,Date: " + cn.getWashDate() +" ,Time: " + cn.getWashTime() +" ,Role: " + cn.getWashRole() +" ,Color: " + cn.getWashColor() +" ,Comment: " + cn.getWashComment();
					Log.d("Name: ", log);
				}
				Toast.makeText(Wash.this, "Сохранено", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void selectedIndices(List<Integer> indices) {

	}

	@Override
	public void selectedStrings(List<String> strings) {

	}
}

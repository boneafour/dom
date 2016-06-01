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


public class Cook extends Activity implements View.OnClickListener,MultiSelectionSpinner.OnMultipleItemsSelectedListener {

	private TextView txtTitle;
	private ImageButton btnBack;
	String dishName, date, commentSt, vegetablesSt, timeSt, foodSt, resSt;
	EditText  Data, comment;
	Spinner food, timeSpinner, res, dish;
	MultiSelectionSpinner vegetables;
	DatabaseHandler db = new DatabaseHandler(this);
	String[] array = {"Лук", "Марковка", "Картошка", "Капуста", "Помидор", "Огурцы"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cook);



		List<ContactData> contacts = db.getAllContacts();
		ArrayList<String> list = new ArrayList<String>();
			for(ContactData cn : contacts){
			String s = cn.getRole();
			list.add(s);
			}



		vegetables = (MultiSelectionSpinner) findViewById(R.id.mySpinner);
		vegetables.setItems(array);
		vegetables.setListener(this);
		Data = (EditText) findViewById(R.id.date);
		comment = (EditText) findViewById(R.id.comment);
		food = (Spinner) findViewById(R.id.breakfast);
		dish = (Spinner) findViewById(R.id.dish);
		timeSpinner = (Spinner) findViewById(R.id.time);
		res = (Spinner) findViewById(R.id.responsility);
		ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
		res.setAdapter(adapter);
		Button send = (Button) findViewById(R.id.send);
		send.setOnClickListener(this);
		txtTitle = (TextView) findViewById(R.id.txtTitle);
		txtTitle.setText(getString(R.string.cookingSt));
		btnBack = (ImageButton) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(this);


	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.btnBack:
				NavUtils.navigateUpFromSameTask(this);
				break;
			case R.id.send:
				dishName = ""+dish.getSelectedItem().toString();
				date = ""+Data.getText();
				Data.setText("");
				timeSt = ""+timeSpinner.getSelectedItem().toString();
				foodSt = food.getSelectedItem().toString();
				resSt = res.getSelectedItem().toString();
				vegetablesSt = vegetables.getSelectedItem().toString();
				commentSt = ""+comment.getText();
				comment.setText("");

				db.addCookL(new CookData(dishName, date, timeSt, foodSt, resSt, vegetablesSt, commentSt));
				List<CookData> cookBaseList = db.getAllCook();
				for (CookData cn : cookBaseList) {
					String log = "Id: "+cn.getCookID()+" ,ListCook: " + cn.getCookList() + " ,CookDate: " + cn.getCookDate()+" ,CookTime: " + cn.getCookTime()+" ,Breakfast: " + cn.getCookBreakfast()+" ,Role: " + cn.getCookRole()+" ,Vega: " + cn.getCookVega()+" ,Comment: " + cn.getCookComment();
					Log.d("Name: ", log);
				}
				Toast.makeText(Cook.this, "Сохранено", Toast.LENGTH_SHORT).show();

				break;
		}

	}

	@Override
	public void selectedIndices(List<Integer> indices) {

	}

	@Override
	public void selectedStrings(List<String> strings) {

	}
}

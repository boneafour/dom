package com.example.user.dom.main;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
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


public class Clean extends Activity implements View.OnClickListener,MultiSelectionSpinner.OnMultipleItemsSelectedListener{

	private TextView txtTitle;
	Spinner timeSpinner, list, res;
	DatabaseHandler db = new DatabaseHandler(this);
	EditText Data, comment;
	String ListS, DataS, TimeS, ResS, CommentS, WorkSS, EMAIL;
	MultiSelectionSpinner works;
	String[] array = {"Протереть пыль", "Вымыть плинтуса", "Протереть холодильник", "Освежать унитаз и раковину", "Пропылесосить полы", "Протереть зеркала и окна"};
	private ImageButton btnBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clean);
		// get role in base
		db = new DatabaseHandler(this);
		List<ContactData> contacts = db.getAllContacts();
		ArrayList<String> roleList = new ArrayList<String>();
		for(ContactData cn : contacts){
			String s = cn.getRole();
			roleList.add(s);
		}


		txtTitle = (TextView) findViewById(R.id.txtTitle);
		txtTitle.setText(getString(R.string.cleaningSt));
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
		Button save = (Button) findViewById(R.id.save);
		save.setOnClickListener(this);
		btnBack = (ImageButton) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btnBack:
				NavUtils.navigateUpFromSameTask(this);
				break;
			case R.id.save:

				ListS = "" + list.getSelectedItem().toString();;
				DataS = "" + Data.getText();
				TimeS = "" + timeSpinner.getSelectedItem().toString();
				ResS = res.getSelectedItem().toString();
				WorkSS = works.getSelectedItem().toString();
				CommentS = "" + comment.getText().toString();
				EMAIL = (ListS+" Дата: "+DataS+" Время: "+TimeS+" Ответственный: "+ResS+" Нужно: "+WorkSS+" Комментарий: "+CommentS+" ");
				db.addClean(new CleanData(ListS, DataS, TimeS, ResS, WorkSS, CommentS));
				List<CleanData> cleans = db.getAllCleans();
				for (CleanData cn : cleans) {
					String log = "Id: "+cn.getCleanID()+" ,List: " + cn.getCleanList() + " ,Data: " + cn.getCleanData()+" ,Time: " + cn.getCleanTime()+" ,Role: " + cn.getCleanRole()+" ,Work: " + cn.getCleanWork()+" ,Comment: " + cn.getCleanComment();
					Log.d("Name: ", log);
				}
				Toast.makeText(Clean.this, "Сохранено", Toast.LENGTH_SHORT).show();
					break;
			case R.id.send:
				ListS = "" + list.getSelectedItem().toString();;
				DataS = "" + Data.getText();
				TimeS = "" + timeSpinner.getSelectedItem().toString();
				ResS = res.getSelectedItem().toString();
				WorkSS = works.getSelectedItem().toString();
				CommentS = "" + comment.getText().toString();
				EMAIL = (ListS+" Дата: "+DataS+" Время: "+TimeS+" Ответственный: "+ResS+" Нужно: "+WorkSS+" Комментарий: "+CommentS+" ");

				sendEmail();
				break;
				}
		}

	protected void sendEmail() {
		Log.i("Send email", "");
		String[] TO = {""};
		String[] CC = {""};
		Intent emailIntent = new Intent(Intent.ACTION_SEND);

		emailIntent.setData(Uri.parse("mailto:"));
		emailIntent.setType("text/plain");
		emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
		emailIntent.putExtra(Intent.EXTRA_CC, CC);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Напоминание");
		emailIntent.putExtra(Intent.EXTRA_TEXT, EMAIL);

		try {
			startActivity(Intent.createChooser(emailIntent, "Отправить на почту..."));
			finish();
		}
		catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(Clean.this, "Отправлено", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void selectedIndices(List<Integer> indices) {

	}

	@Override
	public void selectedStrings(List<String> strings) {

	}
}


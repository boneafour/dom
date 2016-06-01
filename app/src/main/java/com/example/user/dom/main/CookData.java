package com.example.user.dom.main;

public class CookData {

	int _id;
	String _list;
	String _date;
	String _time;
	String _breakfast;
	String _role;
	String _vegetable;
	String _comment;

	public CookData(){
	}

	public CookData(String _list, String _date, String _time, String _breakfast, String _role, String _vegetable, String _comment){
		this._list = _list;
		this._date = _date;
		this._time = _time;
		this._breakfast = _breakfast;
		this._role = _role;
		this._vegetable = _vegetable;
		this._comment = _comment;
	}

	public int getCookID(){return this._id;}
	public void setCookID(int id){this._id = id;}

	public String getCookList(){return this._list;}
	public void setCookList(String name){this._list = name;}

	public String getCookDate(){return this._date;}
	public void setCookDate(String _date){this._date = _date;}

	public String getCookTime(){return this._time;}
	public void setCookTime(String _time){
		this._time = _time;
	}

	public String getCookBreakfast(){
		return this._breakfast;
	}
	public void setCookBreakfast(String _breakfast){this._breakfast = _breakfast;}

	public String getCookRole(){
		return this._date;
	}
	public void setCookRole(String _date){this._date = _date;}

	public String getCookVega(){
		return this._vegetable;
	}
	public void setCookVega(String _vegetable){
		this._vegetable = _vegetable;
	}

	public String getCookComment(){
		return this._comment;
	}
	public void setCookComment(String _comment){
		this._comment = _comment;
	}
}

package com.example.user.dom.main;

public class WashData {

	int _id;
	String _list;
	String _date;
	String _time;
	String _role;
	String _color;
	String _comment;

	public WashData(){
	}

	public WashData(String _list, String _date, String _time, String _role, String _color, String _comment){
		this._list = _list;
		this._date = _date;
		this._time = _time;
		this._role = _role;
		this._color = _color;
		this._comment = _comment;
	}

	public int getWashID(){return this._id;}
	public void setWashID(int id){this._id = id;}

	public String getWashList(){return this._list;}
	public void setWashList(String name){this._list = name;}

	public String getWashDate(){return this._date;}
	public void setWashDate(String _date){this._date = _date;}

	public String getWashTime(){return this._time;}
	public void setWashTime(String _time){
		this._time = _time;
	}

	public String getWashRole(){
		return this._date;
	}
	public void setWashRole(String _date){this._date = _date;}

	public String getWashColor(){
		return this._color;
	}
	public void setWashColor(String _color){
		this._color = _color;
	}

	public String getWashComment(){
		return this._comment;
	}
	public void setWashComment(String _comment){
		this._comment = _comment;
	}
}

package com.example.user.dom.main;

public class CleanData {

	int _id;
	String _list;
	String _data;
	String _time;
	String _role;
	String _work;
	String _comment;

	public CleanData(){
	}

	public CleanData(String _list, String _data, String _time, String _role, String _work,  String _comment ){
		this._list = _list;
		this._data = _data;
		this._time = _time;
		this._role = _role;
		this._work = _work;
		this._comment = _comment;
	}

	public int getCleanID(){
		return this._id;
	}
	public void setCleanID(int id){
		this._id = id;
	}

	public String getCleanList(){
		return this._list;
	}
	public void setCleanList(String _list){
		this._list = _list;
	}

	public String getCleanData(){
		return this._data;
	}
	public void setCleanData(String _data){
		this._data = _data;
	}

	public String getCleanTime()
	{
		return this._time;
	}
	public void setCleanTime(String _time){
		this._time = _time;
	}

	public String getCleanRole(){
		return this._role;
	}
	public void setCleanRole(String _role){
		this._role = _role;
	}

	public String getCleanWork(){return this._work;	}
	public void setCleanWork(String _work){this._work = _work;	}

	public String getCleanComment(){
		return this._comment;	}
	public void setCleanComment(String _comment){
		this._comment = _comment;
	}
}

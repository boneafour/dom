package com.example.user.dom.main;

public class ContactData {
	
	//private variables
	int _id;
	String _name;
	String _role;
	String _phone;
	String _comment;

	// Empty constructor
	public ContactData(){
		
	}

	
	// constructor
	public ContactData(String name, String _role, String _phone, String _comment){
		this._name = name;
		this._role = _role;
		this._phone = _phone;
		this._comment = _comment;
	}

	public int getID(){
		return this._id;
	}
	public void setID(int id){
		this._id = id;
	}

	public String getName(){
		return this._name;
	}
	public void setName(String name){
		this._name = name;
	}

	public String getRole(){
		return this._role;
	}
	public void setRole(String _role){
		this._role = _role;
	}

	public String getPhone(){
		return this._phone;
	}
	public void setPhone(String _phone){
		this._phone = _phone;
	}


	public String getComment(){
		return this._comment;
	}
	public void setComment(String _comment){
		this._comment = _comment;
	}


}

//java package(rani088)
package com.maren.raniproject.model;
//class profile(rani088)
    
public class Profile
 {
	//private access specifier so that it can be only accessed inside the same class(rani088)
	private String userid;

	private String name;

	private String email;

	private long mobile;
      	
	
	//deafault contsructor(rani088)
public Profile() {

	}
//copy constructor(rani088)
	public Profile(String userid, String name, String email, long mobile) {
//super keyword is the reference variable that is used to refer parent class objects(rani088)
		super();
//this keyword works as a refernce for the current object(rani088)
	this.userid = userid;

	this.name = name;
	
	this.email = email;

		this.mobile = mobile;
	
}
	//returns the value of variable userid(rani088)
	public String getUserid()
 {
		return userid;

	}
	//sets the value of userid(rani088)
	public void setUserid(String userid) {

		this.userid = userid;
	
	}
	//returns the value of variable name(rani088)
	public String getName() {
	
	return name;
	
	}
   //sets the value of name(rani088)
	public void setName(String name) {

		this.name = name;
	
}
    //returns the value of variable email(rani088)
	public String getEmail() {

	return email;

	}
    //sets the value of email(rani088)
	public void setEmail(String email) {

		this.email = email;
	}
	//return the value of variable mobile(rani088)
	public long getMobile() {
		return mobile;
	}
	//sets the value of variable mobile(rani088)
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	
}


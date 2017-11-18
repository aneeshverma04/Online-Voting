package com.voting.online;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.Statement;
/*
 * Making of bean class for sign up
 * */
public class SignUp implements Serializable{
private String fname , lname;
private String year,month,date;
private String email , username , password , gender , contact;
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}


public void insert() {
	String sql = "insert into UserCredentials values('"+fname+"' , '"+lname+"' , '"+year+"' , '"+month+"' , '"+date+"' , '"+email+"' , '"+username+"' , '"+password+"' , '"+gender+"' , '"+contact+"')"; // sql query
	java.sql.Connection  con = null; // java.sql.Connection because className is also Connection
									// if any other class name then 
								    // Connection  con = null;
	
	try{
		Class.forName("com.mysql.jdbc.Driver");		// mysql server
		con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineVoting","root","toor");
		Statement stmt = con.createStatement();
		int res = stmt.executeUpdate(sql);
		if(res == 1){
            System.out.println("inserted successfully : "+sql);
		}
		else{
            System.out.println("insertion failed");
            con.close();
		}
	}
	catch(Exception E){
        System.err.println(E);
	}
		
}

}

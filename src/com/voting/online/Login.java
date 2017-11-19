package com.voting.online;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

public class Login implements Serializable{
private String email,psw;
public static String Fname , Lname ;
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPsw() {
	return psw;
}

public void setPsw(String psw) {
	this.psw = psw;
}
public boolean verify() {
	ResultSet resultset = null;
	String temp = null;
	String sql = "select Email from UserCredentials where Email='"+email+"'"; 
	String pass	= "select * from UserCredentials where Email='"+email+"'"; 	
	java.sql.Connection  con = null; // java.sql.Connection because className is also Connection
									// if any other class name then 
								    // Connection  con = null;
	
	try{
		Class.forName("com.mysql.jdbc.Driver");		// mysql server
		con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineVoting","root","toor");
		Statement stmt = con.createStatement();
		boolean res = stmt.execute(sql);
		if(res){
			resultset = (ResultSet) stmt.executeQuery(pass);
			while(resultset.next()) {
				temp = resultset.getString("Password");
				Fname = resultset.getString("FirstName");
				Lname = resultset.getString("LastName");
				}
			if(temp.equals(psw))
				return true;
		}
		else{
            System.out.println("insertion failed");
            con.close();
            return false;
		}
	}
	catch(Exception E){
        System.err.println(E);
	}
	return false;
		
}

}

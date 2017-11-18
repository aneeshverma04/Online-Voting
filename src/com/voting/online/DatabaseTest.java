package com.voting.online;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DatabaseTest")
public class DatabaseTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public static void connect(int h , int w , int a) {
		String sql = "insert into test values('"+h+"' , '"+w+"' , '"+a+"')"; // sql query
		java.sql.Connection  con = null; // java.sql.Connection because className is also Connection
										// if any other class name then 
									    // Connection  con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");		// mysql server
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/new_test","root","toor");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int height = Integer.parseInt(request.getParameter("height"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		int age = Integer.parseInt(request.getParameter("age"));
		
		//out.print(height + " " + weight + " " + age);
		
		connect(height,weight,age);
	}

}

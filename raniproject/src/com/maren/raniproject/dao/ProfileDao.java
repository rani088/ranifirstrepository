//java package(rani088)
package com.maren.raniproject.dao;
//importing all the classes from the packages(rani088)
import java.sql.Connection;
import java.lang.ClassNotFoundException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.maren.raniproject.model.Profile;
//class profiledao (rani088)
public class ProfileDao {

	public static Connection getConnection()throws ClassNotFoundException,SQLException {
		//database mysql connection(rani088)
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3360/test", "root", "root");
	}
	//save is the method for class profile(rani088)
	public int save(Profile profile) {
		//connection and statement has been kept null(rani088)
		Connection con088 = null;
		Statement st088 = null;
		int res088 = 0;
		//exception handling(rani088)
		try {
			//getting connection with datadabse(rani088)
			con088 = getConnection();
			//creating statements(rani088)
			st088 = con088.createStatement();
			//executing queries(rani088)
			res088 = st088.executeUpdate("INSERT INTO test.student (userid, name, email, mobile) VALUES ('"+profile.getUserid()+"', '"+profile.getName()+"', '"+profile.getEmail()+"', "+profile.getMobile()+")"); 
		}catch (ClassNotFoundException | SQLException e) {
			//this method prints a stack trace for this throwable object on the standard error output stream(rani)
			e.printStackTrace();
		}finally {
			try {
				st088.close();
				con088.close();
			} catch (SQLException e) {
	//this method prints a stack trace for this throwable object on the standard error output stream(rani)
				e.printStackTrace();
			}
		}
		//terminates the execution of a function and return control to the calling function
		return res088;
	}
	//fetches all remaining row in the result set(rani088)
	public List<Profile> fetchAll() {
		//connection and statement has been kept null(rani088)
		List<Profile> list088=null;
		Connection con088 = null;
		Statement st088 = null;
		//exception handling(rani088)
		try {
			//getting connection with datadabse(rani088)
			con088 = getConnection();
			//creating statements(rani088)
			st088 = con088.createStatement();
			//executing queries(rani088)
			ResultSet rs088 = st088.executeQuery("SELECT * FROM test.profile");
			if(rs088 != null)
				//creating an array for the storage
				list088 = new ArrayList<>();
			while(rs088.next()) {
				////creating a new object profile166 of the class(Sonali054)
				Profile pr = new Profile();
				// the set method would set the value and get method will return the variable value(rani088)
				pr.setUserid(rs088.getString("userid"));
				pr.setName(rs088.getString("name"));
				pr.setEmail(rs088.getString("email"));
				pr.setMobile(rs088.getLong("mobile"));
				list088.add(pr);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st088.close();
				con088.close();
			} catch (SQLException e) {
//this method prints a stack trace for this throwable object on the standard error output stream(rani088)
				e.printStackTrace();
			}
			
		}
//terminates the execution of a function and return control to the calling function
		return list088;
	}
	//main function(rani088)
	public static void main(String[] args) {
		Connection con088 = null;
		Statement st088 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con088 = DriverManager.getConnection("jdbc:mysql://localhost:3360/test", "root", "root");
			st088 = con088.createStatement();
			ResultSet rs088 = st088.executeQuery("SELECT * FROM test.student");
			while(rs088.next()) {
				String id = rs088.getString("userid");
				String name = rs088.getString("name");
				String email = rs088.getString("email");
				long mobile = rs088.getLong("mobile");
				System.out.println("Id : " +id + "\tName : "+ name+ "\tEmail : " +email + "\tMobile : " +mobile );
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st088.close();
				con088.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		

	}

}

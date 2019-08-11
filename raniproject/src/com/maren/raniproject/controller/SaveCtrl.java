package com.maren.raniproject.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class SaveCtrl 
{
	public static Connection getConnection()throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3360/test", "root", "root");
}
 
    private static String INSERT1 = "INSERT INTO test.student (userid, name, email, mobile) VALUES (?, ?, ?, ?)";

    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn088 = null;
        PreparedStatement pstmt088 = null;
        PreparedStatement pstmt2088 = null;
        try {
            conn088 = getConnection();
        } catch (SQLException e) {
        	e.printStackTrace();
            System.err.println("There was an error getting the connection");
        }
        try {
            conn088.setSavepoint("Savepoint");
            System.err.println("The Savepoint was disabled!");
        } catch (SQLException e) {
            System.err.println("There was an error disabling Savepoint");
        }
        // Starts JDBC Transaction
        try {
            pstmt088 = conn088.prepareStatement(INSERT1);
            pstmt2088 = conn088.prepareStatement(INSERT1);
             
            pstmt088.setInt(1,012);
            pstmt088.setString(2, "puja");
            pstmt088.setString(3, "puja@gmail.com");
            pstmt088.setInt(4,981060);
            
            pstmt088.addBatch();
            int[] count1=pstmt088.executeBatch();
             
            pstmt2088.setInt(1,1398);
            pstmt2088.setString(2, "Abhay");
            pstmt2088.setString(3, "abhay@gmail.com");
            pstmt2088.setInt(4,936572);
           
            pstmt2088.addBatch();
            
            int[] count=pstmt2088.executeBatch();             
            conn088.commit();
            System.err.println("The transaction was successfully executed");
        } catch (SQLException e) {
            try {
                //We rollback the transaction, atomicity!
                conn088.rollback();
                System.err.println(e.getMessage());
                System.err.println("The transaction was rollback");
            } catch (SQLException e1) {
                System.err.println("There was an error making a rollback");
            }
        }
    }

	private static String INSERT  = "INSERT INTO test.student (userid, name, email, mobile) VALUES (?, ?, ?, ?)";
}
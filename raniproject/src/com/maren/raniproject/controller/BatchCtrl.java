package com.maren.raniproject.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class BatchCtrl 
{
	public static Connection getConnection()throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3360/test", "root", "root");
}
 
    private static String INSERT = "INSERT INTO test.student (userid, name, email, mobile) VALUES (?, ?, ?, ?)";

    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        try {
            conn = getConnection();
        } catch (SQLException e) {
        	e.printStackTrace();
            System.err.println("There was an error getting the connection");
        }
        try {
            conn.setAutoCommit(false);
            System.err.println("The autocommit was disabled!");
        } catch (SQLException e) {
            System.err.println("There was an error disabling autocommit");
        }
        // Starts JDBC Transaction
        try {
            pstmt = conn.prepareStatement(INSERT);
            pstmt2 = conn.prepareStatement(INSERT);
             
            pstmt.setInt(1,166);
            pstmt.setString(2, "nidhi");
            pstmt.setString(3, "nidhi@gmail.com");
            pstmt.setInt(4,981060);
            
            pstmt.addBatch();
            int[] count1=pstmt.executeBatch();
             
            pstmt2.setInt(1,138);
            pstmt2.setString(2, "Amit");
            pstmt2.setString(3, "amit@gmail.com");
            pstmt2.setInt(4,936572);
           
            pstmt2.addBatch();
            
            int[] count=pstmt2.executeBatch();             
            conn.commit();
            System.err.println("The transaction was successfully executed");
        } catch (SQLException e) {
            try {
                //We rollback the transaction, atomicity!
                conn.rollback();
                System.err.println(e.getMessage());
                System.err.println("The transaction was rollback");
            } catch (SQLException e1) {
                System.err.println("There was an error making a rollback");
            }
        }
    }
}
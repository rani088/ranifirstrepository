//java package(rani)
package com.maren.raniproject.controller;
//importing all the classes from the packages(rani)
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.raniproject.model.Profile;
/**
 * Servlet implementation class ProfileViewCtrl(rani)
 */
@WebServlet("/ProfileViewCtrl")
public class ProfileViewCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)(rani)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//reuqest to get a value(rani)
		int res088 =  (int) request.getAttribute("RES");//added cast to int(rani)
		PrintWriter out = response.getWriter();// returns a printwriter object that can send character text to the client(rani)
		if (res088 == 0)//business logic
			//to output text to the console out.println prints the string and moves to next line(Lovely)
			out.println("There is some problem ;  Try again .");
		else
			out.println("Data Successfully inserted");
		out.print(" <br/> The Datas are");
		//fetches all remaining row in the result set(rani)
		List<Profile> list =  new com.maren.raniproject.dao.ProfileDao().fetchAll();
		//iterator enables the programmer to traverse a container particularly lists(rani)
		for (Iterator<Profile> iterator = list.iterator(); iterator.hasNext();) {
			Profile profile088 = (Profile) iterator.next();
			out.println("Name : "+ profile088.getName() +" Userid : "+ profile088.getUserid()+ "mobile "+ profile088.getMobile()+"email"+profile088.getEmail());
		}
		

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)(rani)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

//java package(rani)
package com.maren.raniproject.controller;
//importing all the classes from the packages(rani)
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloCtrl(rani)
 */
@WebServlet("/HelloCtrl")
public class HelloCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)(rani)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// returns a printwriter object that can send character text to the client here it is hello servlet(rani)
		response.getWriter().append("Hello Servlet ");
		
	}

}

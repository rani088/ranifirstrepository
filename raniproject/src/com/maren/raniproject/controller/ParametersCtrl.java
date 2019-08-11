//java package(rani)
package com.maren.raniproject.controller;
//importing all the classes from the packages(rani)
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ParametersCtrl(rani)
 */
@WebServlet("/ParametersCtrl")
public class ParametersCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)(rani)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrieve request parameter (rani)
		String name088=request.getParameter("txtName");
		String pass088=request.getParameter("pass");
		// returns a printwriter object that can send character text to the client(rani)
		PrintWriter out=response.getWriter();
		//name and password would simply print(rani)
		out.print("<b> Name <b>:"+name088);
		out.print("<b> Password <b>:"+pass088);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)(rani)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

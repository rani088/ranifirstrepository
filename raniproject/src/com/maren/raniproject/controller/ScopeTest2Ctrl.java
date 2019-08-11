//java package(rani088)
package com.maren.raniproject.controller;
//importing all the classes from the packages(Sonali054)
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScopeTest2(Sonali054)
 */
@WebServlet("/ScopeTest2Ctrl")
public class ScopeTest2Ctrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)(rani088)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sharing out data among resources(Sonali054)
		String req088=(String) request.getAttribute("REQUEST");//will process current request(rani088)
		String ses088=(String) request.getSession().getAttribute("SESSION");//will return current session(rani088)
		//http session contains a reference to servletcontext that this seesion belong to(rani088)
		String app088=(String) request.getServletContext().getAttribute("APP");
		// returns a printwriter object that can send character text to the client(rani088)
		PrintWriter out=response.getWriter();
		out.println("Req:"+req088);
		out.println("Session:"+ses088);
		out.println("Application:"+app088);
		
	}

}


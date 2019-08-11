//java package(rani088)
package com.maren.raniproject.controller;
//importing all the classes from the packages(rani088)
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maren.raniproject.dao.ProfileDao;
import com.maren.raniproject.model.Profile;


@WebServlet("/ProfileSaveCtrl")     
public class ProfileSaveCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)(Sonali054)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creating a new object profile054 of the class(rani088)
		Profile profile088 = new Profile();
		// the set method would set the value and get method will return the variable value(rani088)
		profile088.setUserid(request.getParameter("userid"));
		profile088.setName(request.getParameter("name"));
		profile088.setEmail(request.getParameter("email"));
		//here long class is use parse the charsequence argument as a signed long with specified radix(rani088)
		profile088.setMobile(Long.parseLong(request.getParameter("mobile")));
		// save in database
		int res = new ProfileDao().save(profile088);
		//to set the attribute
		request.setAttribute("RES", res);
		//getrequestdispatecher provides the facility of dispatching the request to another resource i.e. servlet,jsp or html(Sonali054)
		request.getRequestDispatcher("/ProfileViewCtrl").forward(request, response);
	}

}

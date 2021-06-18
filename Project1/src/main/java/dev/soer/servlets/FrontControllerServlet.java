package dev.soer.servlets;

import java.io.IOException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.soer.beans.Employee;
import dev.soer.services.EmployeeServices;


public class FrontControllerServlet extends HttpServlet{
	class info {
		String username;
		String password;
	}
	private EmployeeServices es = new EmployeeServices();
	private Gson gson = new Gson();
	static HttpSession session; 
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		response.setHeader("Access-Control-Allow-Origin","*");		// Needed to avoid CORS violations
		response.setHeader("Content-Type", "application/json");	
		session = request.getSession();
		uri = uri.substring("/Project1/controller/".length());
		switch(uri) {
			case "login": {
				System.out.println("Recieving login info");
				info login = this.gson.fromJson(request.getReader(), info.class);
				System.out.println(login.username);
				System.out.println(login.password);
				Employee em = es.get(login.username, login.password);
				if(em != null) {
					System.out.println("Employee: " + em.getFirstName() + " " + em.getLastName() + " logged in.");
					//set session to user
					session.setAttribute("logged_in", em);
					
					response.getWriter().append("/Project1/homepage.html");
				}
				else {
					System.out.println("Error employee is null");
				}
				break;
			}
			case "homepage": {
				
				break;
			}
			default: {
				System.out.println("Reached default case");
				response.sendError(418, "Making Tea");
			}
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}
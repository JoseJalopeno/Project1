package dev.soer.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.soer.beans.Form;
import dev.soer.services.FormServices;

public class FrontControllerServlet extends HttpServlet{
	private static FormServices fs = new FormServices();
	private Gson gson = new Gson();
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		
		switch(uri) {
			case "/Project1/forms": {
				System.out.println("Getting all forms...");
				response.getWriter().append("Hello\n");
				List<Form> forms = fs.getAll();
				System.out.println(forms);
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().append(gson.toJson(forms));
			}
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}

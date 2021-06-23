package dev.soer.servlets;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import dev.soer.beans.Employee;
import dev.soer.beans.Form;
import dev.soer.beans.GradeFormats;
import dev.soer.beans.Justifications;
import dev.soer.beans.Reimbursements;
import dev.soer.data.JustificationsHibernate;
import dev.soer.services.EmployeeServices;
import dev.soer.services.FormServices;
import dev.soer.services.GradeFormatsServices;
import dev.soer.services.JustificationsServices;
import dev.soer.services.ReimbursementsServices;


public class FrontControllerServlet extends HttpServlet{
	
	class info {
		String username;
		String password;
	}
	
	private EmployeeServices es = new EmployeeServices();
	private FormServices fs = new FormServices();
	private JustificationsServices js = new JustificationsServices();
	private GradeFormatsServices gfs = new GradeFormatsServices();
	private ReimbursementsServices rs = new ReimbursementsServices();

	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm").create();
	static HttpSession session; 
	static Employee em;
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
//				System.out.println(login.username);
//				System.out.println(login.password);
				em = es.get(login.username, login.password);
				if(em != null) {
					System.out.println("Employee: " + em.getFirstName() + " " + em.getLastName() + " logged in.");
					//set session to user
					session.setAttribute("logged_in", em);
					//checks on the employees type and then redirects to appropiate page
					if(em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Associate")) {
						response.getWriter().append("/Project1/homepage.html");
					} 
					else if(em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Supervisor")) {
						response.getWriter().append("/Project1/supervisor.html");
					}
					else if(em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Department Head")) {
						response.getWriter().append("/Project1/depthead.html");
					}
					else if(em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Benefits Coordinator")) {
						response.getWriter().append("/Project1/benefitscoord.html");
					}
					
				}
				else {
					System.out.println("Error employee is null");
				}
				break;
			}
			case "homepage": {
				//this sends the user to the homepage to get data for it
				List<Justifications> j = js.getAll();
				List<GradeFormats> gf = gfs.getAll();
				List<Reimbursements> r = rs.getAll();
				String[] jsons = {this.gson.toJson(j), this.gson.toJson(gf), this.gson.toJson(r), this.gson.toJson(session.getAttribute("logged_in"))};
				String json = gson.toJson(jsons);
				response.getWriter().append(json);
				break;
			}
			case "addForm": {
				Form newForm = this.gson.fromJson(request.getReader(), Form.class);
				fs.add(newForm);
				em.getForms().add(newForm);
				//em.setBalance(em.getBalance() - (newForm.getEventCost() * newForm.getReimbursement()));
				es.update(em);
				System.out.println(newForm);
				response.getWriter().append("/Project1/homepage.html");
				break;
			}
			case "grabData": {
				List<Justifications> j = js.getAll();
				List<GradeFormats> gf = gfs.getAll();
				List<Reimbursements> r = rs.getAll();
				String[] jsons = {this.gson.toJson(j), this.gson.toJson(gf), this.gson.toJson(r), this.gson.toJson(session.getAttribute("logged_in"))};
				String json = gson.toJson(jsons);
				response.getWriter().append(json);
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
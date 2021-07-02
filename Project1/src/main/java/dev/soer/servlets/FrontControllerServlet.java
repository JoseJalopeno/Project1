package dev.soer.servlets;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
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

public class FrontControllerServlet extends HttpServlet {

	class info {
		String username;
		String password;
	}

	class formUpdate {
		String action;
		int formid;
		String reason;
	}

	class editForm {
		int formid;
	}

	class updateForm {
		int formid;
		Date eventDate;
		String location;
		String description;
		Double eventCost;
		int gradeformat;
		String eventtype;
		int justification;
		int reimbursement;
		String grade;
	}

	class bcUpdateForm {
		int formid;
		Double eventCost;
		String reason;
	}

	private EmployeeServices es = new EmployeeServices();
	private FormServices fs = new FormServices();
	private JustificationsServices js = new JustificationsServices();
	private GradeFormatsServices gfs = new GradeFormatsServices();
	private ReimbursementsServices rs = new ReimbursementsServices();

	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm").create();
	static HttpSession session;
	static Employee em;
	static int formid;
	static int bcEditID;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		response.setHeader("Access-Control-Allow-Origin", "*"); // Needed to avoid CORS violations
		response.setHeader("Content-Type", "application/json");
		session = request.getSession();
		uri = uri.substring("/Project1/controller/".length());
		switch (uri) {
		case "login": {
			System.out.println("Recieving login info");
			info login = this.gson.fromJson(request.getReader(), info.class);
//				System.out.println(login.username);
//				System.out.println(login.password);
			em = es.get(login.username, login.password);
			if (em != null) {
				System.out.println("Employee: " + em.getFirstName() + " " + em.getLastName() + " logged in.");
				// set session to user
				session.setAttribute("logged_in", em);
				// checks on the employees type and then redirects to appropiate page
				if (em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Associate")) {
					response.getWriter().append("/Project1/homepage.html");
				} else if (em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Supervisor")) {
					response.getWriter().append("/Project1/supervisor.html");
				} else if (em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Department Head")) {
					response.getWriter().append("/Project1/depthead.html");
				} else if (em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Benefits Coordinator")) {
					response.getWriter().append("/Project1/benefitscoord.html");
				}

			} else {
				System.out.println("Error employee is null");
			}
			break;
		}
		case "homepage": {
			// this sends the user to the homepage to get data for it
			List<Justifications> j = js.getAll();
			List<GradeFormats> gf = gfs.getAll();
			List<Reimbursements> r = rs.getAll();
			String[] jsons = { this.gson.toJson(j), this.gson.toJson(gf), this.gson.toJson(r),
					this.gson.toJson(session.getAttribute("logged_in")) };
			String json = gson.toJson(jsons);
			response.getWriter().append(json);
			break;
		} // adds new form to database and user (need to get the balance updated correctly
		case "addForm": {
			Form newForm = this.gson.fromJson(request.getReader(), Form.class);
			double x = 0;
			List<Reimbursements> r = rs.getAll();
			for (Reimbursements rs : r) {
				if (rs.getId() == newForm.getReimbursement()) {
					x = rs.getPercent();
				}
			}
			newForm.setEventCost(newForm.getEventCost() * x);
			// if new form is greater than balance remaining set cost to remaining balance
			// else cost will be zero
			if (em.getBalance() - newForm.getEventCost() < 0) {
				newForm.setEventCost(em.getBalance());
				if(em.getBalance() == 0) {
					newForm.setStatus("Holding. No Balance");
				}
			}
			fs.add(newForm);
			em.getForms().add(newForm);
			
			es.update(em);
			// System.out.println(newForm);
			if (em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Associate")) {
				response.getWriter().append("/Project1/homepage.html");
			} else if (em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Supervisor")) {
				response.getWriter().append("/Project1/supervisor.html");
			} else if (em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Department Head")) {
				response.getWriter().append("/Project1/depthead.html");
			} else if (em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Benefits Coordinator")) {
				response.getWriter().append("/Project1/benefitscoord.html");
			}
			break;
		} // populates data in dropdowns
		case "grabData": {
			List<Justifications> j = js.getAll();
			List<GradeFormats> gf = gfs.getAll();
			List<Reimbursements> r = rs.getAll();
			String[] jsons = { this.gson.toJson(j), this.gson.toJson(gf), this.gson.toJson(r),
					this.gson.toJson(session.getAttribute("logged_in")) };
			String json = gson.toJson(jsons);
			response.getWriter().append(json);
			break;
		}
		case "supervisor": {
			List<Employee> employees = es.getAll();
			List<Form> supervisorForms = fs.getSupervisorUnapproved();
			List<Justifications> j = js.getAll();
			List<GradeFormats> gf = gfs.getAll();
			List<Reimbursements> r = rs.getAll();
			String[] jsons = { this.gson.toJson(j), this.gson.toJson(gf), this.gson.toJson(r),
					this.gson.toJson(supervisorForms), this.gson.toJson(session.getAttribute("logged_in")),
					this.gson.toJson(employees) };
			String json = gson.toJson(jsons);
			response.getWriter().append(json);
			break;
		}
		case "supervisorApproval": {
			formUpdate fUpdate = this.gson.fromJson(request.getReader(), formUpdate.class);
			Form f = fs.getById(fUpdate.formid);
			Employee em = es.getById(f.getEmpID());
			f.setReason(fUpdate.reason);
			if (fUpdate.action.equalsIgnoreCase("Approve")) {
				f.setStatus("Pending");
				f.setSupervisorApproval(true);
			} else if (fUpdate.action.equalsIgnoreCase("Request")) {
				f.setStatus(fUpdate.action);
			} else if (fUpdate.action.equalsIgnoreCase("Deny")) {
				f.setStatus("Denied");
				em.setBalance(em.getBalance() + f.getEventCost());// gives the balance back to the employee if request
																	// is denied
				es.update(em);
			}
			fs.update(f);
			response.getWriter().append("/Project1/supervisor.html");
			break;
		}
		case "depthead": {
			List<Employee> employees = es.getAll();
			List<Form> deptHeadForms = fs.getDeptHeadUnapproved();
			// System.out.println(deptHeadForms);
			List<Justifications> j = js.getAll();
			List<GradeFormats> gf = gfs.getAll();
			List<Reimbursements> r = rs.getAll();
			String[] jsons = { this.gson.toJson(j), this.gson.toJson(gf), this.gson.toJson(r),
					this.gson.toJson(deptHeadForms), this.gson.toJson(session.getAttribute("logged_in")),
					this.gson.toJson(employees) };
			String json = gson.toJson(jsons);
			response.getWriter().append(json);
			break;
		}
		case "deptheadApproval": {
			formUpdate fUpdate = this.gson.fromJson(request.getReader(), formUpdate.class);
			Form f = fs.getById(fUpdate.formid);
			Employee em = es.getById(f.getEmpID());
			f.setReason(fUpdate.reason);
			if (fUpdate.action.equalsIgnoreCase("Approve")) {
				f.setDeptHeadApproval(true);
			} else if (fUpdate.action.equalsIgnoreCase("Request")) {
				f.setStatus(fUpdate.action);
			} else if (fUpdate.action.equalsIgnoreCase("Deny")) {
				f.setStatus("Denied");
				em.setBalance(em.getBalance() + f.getEventCost());// gives the balance back to the employee if request
																	// is denied
				es.update(em);
			}
			fs.update(f);
			response.getWriter().append("/Project1/depthead.html");
			break;
		}
		case "benefits": {
			List<Employee> employees = es.getAll();
			List<Form> BCForms = fs.getBCUnapproved();
			List<Justifications> j = js.getAll();
			List<GradeFormats> gf = gfs.getAll();
			List<Reimbursements> r = rs.getAll();
			String[] jsons = { this.gson.toJson(j), this.gson.toJson(gf), this.gson.toJson(r),
					this.gson.toJson(BCForms), this.gson.toJson(session.getAttribute("logged_in")),
					this.gson.toJson(employees) };
			String json = gson.toJson(jsons);
			response.getWriter().append(json);
			break;
		}
		case "bcApproval": {
			formUpdate fUpdate = this.gson.fromJson(request.getReader(), formUpdate.class);
			Form f = fs.getById(fUpdate.formid);
			Employee em = es.getById(f.getEmpID());
			f.setReason(fUpdate.reason);
			if (fUpdate.action.equalsIgnoreCase("Approve")) {
				f.setBCApproval(true);
				f.setStatus("Approved");
			} else if (fUpdate.action.equalsIgnoreCase("Request")) {
				f.setStatus(fUpdate.action);
			} else if (fUpdate.action.equalsIgnoreCase("Deny")) {
				f.setStatus("Denied");
				em.setBalance(em.getBalance() + f.getEventCost());// gives the balance back to the employee if request
																	// is denied
				es.update(em);
			}
			fs.update(f);
			
			response.getWriter().append("/Project1/benefitscoord.html");
			break;
		}
		case "editForm": {
			Form f = fs.getById(formid);
			String json = this.gson.toJson(f);
			response.getWriter().append(json);
			break;
		}
		case "sendID": {
			// this stores the id for the form to be edited in the formid static variable
			// editForm will use this to then populate the data on the editForm.html page
			editForm edit = this.gson.fromJson(request.getReader(), editForm.class);
			formid = edit.formid;
			break;
		}
		case "updateForm": {
			updateForm uForm = this.gson.fromJson(request.getReader(), updateForm.class);
			// System.out.println("Update Form id: " + uForm.formid);
			Form f = fs.getById(uForm.formid);
			f.setEventDate(uForm.eventDate);
			f.setLocation(uForm.location);
			f.setDescription(uForm.description);
			f.setEventCost(uForm.eventCost);
			f.setGradeFormat(uForm.gradeformat);
			f.setEventtype(uForm.eventtype);
			f.setJustification(uForm.justification);
			f.setReimbursementID(uForm.reimbursement);
			f.setGrade(uForm.grade);
			fs.update(f);
			if (em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Associate")) {
				response.getWriter().append("/Project1/homepage.html");
			} else if (em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Supervisor")) {
				response.getWriter().append("/Project1/supervisor.html");
			} else if (em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Department Head")) {
				response.getWriter().append("/Project1/depthead.html");
			} else if (em.getEmployeeType().getEmployeeType().equalsIgnoreCase("Benefits Coordinator")) {
				response.getWriter().append("/Project1/benefitscoord.html");
			}
			break;
		}
		case "bcEditSendID": {
			editForm bcEdit = this.gson.fromJson(request.getReader(), editForm.class);
			bcEditID = bcEdit.formid;
			break;
		}
		case "bcEditForm": {
			Form f = fs.getById(bcEditID);
			String json = this.gson.toJson(f);
			response.getWriter().append(json);
			break;
		}
		case "bcUpdateForm": {
			bcUpdateForm bcForm = this.gson.fromJson(request.getReader(), bcUpdateForm.class);
			Form f = fs.getById(bcForm.formid);
			f.setEventCost(bcForm.eventCost);
			fs.update(f);
			response.getWriter().append("/Project1/benefitscoord.html");
			break;
		}
		case "logout": {
			session.invalidate();
			response.getWriter().append("/Project1/index.html");
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
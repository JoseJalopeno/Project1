package dev.soer.driver;

import dev.soer.beans.Employee;
import dev.soer.services.EmployeeServices;

public class testdriver {

	public static void main(String[] args) {
		EmployeeServices es = new EmployeeServices();
		
		Employee em = es.get("jsoer", "password");
		System.out.println(em);
	}
}

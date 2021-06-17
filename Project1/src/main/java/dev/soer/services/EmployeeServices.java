package dev.soer.services;

import java.util.List;

import dev.soer.beans.Employee;
import dev.soer.data.EmployeeHibernate;

public class EmployeeServices implements GenericServices<Employee> {

	EmployeeHibernate eh = new EmployeeHibernate();
	@Override
	public Employee add(Employee t) {
		return eh.add(t);
	}

	@Override
	public Employee getById(Integer id) {
		return eh.getById(id);
	}

	@Override
	public Employee get(String pass, String user) {
		return eh.get(user, pass);
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> employees = eh.getAll();
		return employees;
	}

	@Override
	public Employee update(Employee t) {
		return eh.update(t);
	}

	@Override
	public boolean delete(Employee t) {
		return eh.remove(t);		
	}

}

package dev.soer.data;

import java.util.List;

import org.hibernate.Session;

import dev.soer.beans.Employee;
import dev.soer.utils.HibernateUtil;

public class EmployeeHibernate implements GenericRepo<Employee>{

	@Override
	public Employee add(Employee em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee get(Integer id) {
		Session s = HibernateUtil.getSession();
		Employee e = s.get(Employee.class, id);
		s.close();
		return e;
	}

	@Override
	public Employee get(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Employee em) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Employee em) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		EmployeeHibernate eh = new EmployeeHibernate();
		Employee em = eh.get(1);
		System.out.println(em);
	}

}

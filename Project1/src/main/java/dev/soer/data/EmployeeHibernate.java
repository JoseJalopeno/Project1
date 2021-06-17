package dev.soer.data;

import java.util.List;

import javax.persistence.criteria.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.soer.beans.Employee;
import dev.soer.utils.HibernateUtil;

public class EmployeeHibernate implements GenericRepo<Employee>{

	@Override
	public Employee add(Employee em) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			s.beginTransaction();
			s.save(em);
			s.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		} finally {
			s.close();
		}
		return em;
	}

	@Override
	public Employee getById(Integer id) {
		Session s = HibernateUtil.getSession();
		Employee e = s.get(Employee.class, id);
		s.close();
		return e;
	}

	@Override
	public Employee get(String user, String pass) {
		Session s = HibernateUtil.getSession();
		Employee em = null;
		try {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
			Root<Employee> root = cr.from(Employee.class);
			Predicate p1 = cb.equal(root.get("username"), user);
			Predicate p2 = cb.equal(root.get("password"), pass);
			cr.select(root).where(cb.and(p1, p2));
			
			em = s.createQuery(cr).getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return em;
	}

	@Override
	public List<Employee> getAll() {
		Session s = HibernateUtil.getSession();
		List<Employee> forms = null;
		try {
			forms = s.createQuery("FROM employees").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return forms;

	}

	@Override
	public Employee update(Employee em) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(em);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return em;
	}

	@Override
	public boolean remove(Employee em) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(em);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			s.close();
		}
		return true;
	}
	
	public static void main(String[] args) {
		EmployeeHibernate eh = new EmployeeHibernate();
		Employee em = eh.get("jsoer", "password");
		System.out.println(em);
	}

}

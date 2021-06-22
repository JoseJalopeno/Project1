package dev.soer.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.soer.beans.Employee;
import dev.soer.beans.Form;
import dev.soer.services.EmployeeServices;
import dev.soer.utils.HibernateUtil;
import dev.soer.utils.JDBCConnection;

public class FormHibernate implements GenericRepo<Form> {
	EmployeeServices es = new EmployeeServices();
	
	@Override
	public Form add(Form t) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			s.beginTransaction();
			s.save(t);
			s.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			s.getTransaction().rollback();
		} finally {
			s.close();
		}
		return t;
	}

	@Override
	public Form getById(Integer id) {
		Session s = HibernateUtil.getSession();
		Form f = s.get(Form.class, id);
		s.close();
		return f;
	}

	@Override // not needed for forms
	public Form get(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Form> getAll() {
		Session s = HibernateUtil.getSession();
		List<Form> forms = null;
		try {
			forms = s.createQuery("FROM forms").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return forms;
	}

	@Override
	public Form update(Form u) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(u);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
		return u;
	}

	@Override
	public boolean remove(Form t) {
		Session s = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(t);
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

}

package dev.soer.data;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dev.soer.beans.Form;
import dev.soer.utils.HibernateUtil;

public class FormHibernate implements GenericRepo<Form> {

	@Override
	public Form add(Form t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Form get(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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
	public boolean update(Form u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Form t) {
		// TODO Auto-generated method stub
		return false;
	}

}

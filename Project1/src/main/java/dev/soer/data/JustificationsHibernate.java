package dev.soer.data;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dev.soer.beans.Employee;
import dev.soer.beans.Justifications;
import dev.soer.utils.HibernateUtil;

public class JustificationsHibernate implements GenericRepo<Justifications> {

	@Override
	public Justifications add(Justifications t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Justifications getById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Justifications get(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Justifications> getAll() {
		Session s = HibernateUtil.getSession();
		List<Justifications> justs = null;
		try {
			justs = s.createQuery("FROM justifications").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return justs;
	}

	@Override
	public Justifications update(Justifications u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Justifications t) {
		// TODO Auto-generated method stub
		return false;
	}

}

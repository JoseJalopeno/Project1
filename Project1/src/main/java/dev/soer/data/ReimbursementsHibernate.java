package dev.soer.data;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dev.soer.beans.Employee;
import dev.soer.beans.Reimbursements;
import dev.soer.utils.HibernateUtil;

public class ReimbursementsHibernate implements GenericRepo<Reimbursements> {

	@Override
	public Reimbursements add(Reimbursements t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursements getById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursements get(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursements> getAll() {
		Session s = HibernateUtil.getSession();
		List<Reimbursements> r = null;
		try {
			r = s.createQuery("FROM reimbursements").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return r;
	}

	@Override
	public Reimbursements update(Reimbursements u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Reimbursements t) {
		// TODO Auto-generated method stub
		return false;
	}

}

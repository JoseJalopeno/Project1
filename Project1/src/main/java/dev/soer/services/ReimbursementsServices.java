package dev.soer.services;

import java.util.List;

import dev.soer.beans.Reimbursements;
import dev.soer.data.ReimbursementsHibernate;

public class ReimbursementsServices implements GenericServices<Reimbursements> {
	
	private ReimbursementsHibernate rh = new ReimbursementsHibernate();
	@Override
	public Reimbursements add(Reimbursements t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursements getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursements get(String pass, String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursements> getAll() {
		return rh.getAll();
	}

	@Override
	public Reimbursements update(Reimbursements t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Reimbursements t) {
		// TODO Auto-generated method stub
		return false;
	}

}

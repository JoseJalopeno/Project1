package dev.soer.services;

import java.util.List;

import dev.soer.beans.Justifications;
import dev.soer.data.JustificationsHibernate;

public class JustificationsServices implements GenericServices<Justifications> {

	static JustificationsHibernate jh = new JustificationsHibernate();
	@Override
	public Justifications add(Justifications t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Justifications getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Justifications get(String pass, String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Justifications> getAll() {
		return jh.getAll();
	}

	@Override
	public Justifications update(Justifications t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Justifications t) {
		// TODO Auto-generated method stub
		return false;
	}

}

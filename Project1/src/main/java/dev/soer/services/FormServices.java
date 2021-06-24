package dev.soer.services;

import java.util.List;


import dev.soer.beans.Form;
import dev.soer.data.FormHibernate;

public class FormServices implements GenericServices<Form> {

	private static FormHibernate fh = new FormHibernate();

	@Override
	public Form add(Form t) {
		return fh.add(t);
	}

	@Override
	public Form getById(Integer id) {
		return fh.getById(id);
	}

	@Override
	public Form get(String pass, String user) {
		return fh.get(user, pass);
	}

	@Override
	public List<Form> getAll() {
		List<Form> forms = fh.getAll();
		return forms;
	}

	@Override
	public Form update(Form t) {
		return fh.update(t);
	}

	@Override
	public boolean delete(Form t) {
		return fh.remove(t);
	}
	
	public List<Form> getSupervisorUnapproved() {
		List<Form> forms = fh.getSupervisorUnapproved();
		return forms;
	}
	
	public List<Form> getDeptHeadUnapproved() {
		List<Form> forms = fh.getDeptHeadUnapproved();
		return forms;
	}
	
	public List<Form> getBCUnapproved() {
		List<Form> forms = fh.getBCUnapproved();
		return forms;
	}

}

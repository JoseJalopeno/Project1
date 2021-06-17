package dev.soer.services;

import java.util.List;

import dev.soer.beans.Form;
import dev.soer.data.FormDAO;

public class FormServices {

	private static FormDAO fdao = new FormDAO();
	
	public List<Form> getAllForms() {
		return fdao.getAll();
	}
}

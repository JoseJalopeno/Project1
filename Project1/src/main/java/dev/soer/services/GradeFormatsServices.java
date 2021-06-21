package dev.soer.services;

import java.util.List;

import dev.soer.beans.GradeFormats;
import dev.soer.data.GradeFormatsHibernate;

public class GradeFormatsServices implements GenericServices<GradeFormats> {

	private GradeFormatsHibernate gh = new GradeFormatsHibernate();
	@Override
	public GradeFormats add(GradeFormats t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GradeFormats getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GradeFormats get(String pass, String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeFormats> getAll() {
		return gh.getAll();
	}

	@Override
	public GradeFormats update(GradeFormats t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(GradeFormats t) {
		// TODO Auto-generated method stub
		return false;
	}

}

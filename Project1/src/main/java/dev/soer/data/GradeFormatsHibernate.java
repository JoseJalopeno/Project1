package dev.soer.data;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dev.soer.beans.Employee;
import dev.soer.beans.GradeFormats;
import dev.soer.utils.HibernateUtil;

public class GradeFormatsHibernate implements GenericRepo<GradeFormats> {

	@Override
	public GradeFormats add(GradeFormats t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GradeFormats getById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GradeFormats get(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeFormats> getAll() {
		Session s = HibernateUtil.getSession();
		List<GradeFormats> gf = null;
		try {
			gf = s.createQuery("FROM gradeformats").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return gf;
	}

	@Override
	public GradeFormats update(GradeFormats u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(GradeFormats t) {
		// TODO Auto-generated method stub
		return false;
	}

}

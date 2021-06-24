package dev.soer.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.soer.beans.Form;
import dev.soer.services.EmployeeServices;
import dev.soer.utils.HibernateUtil;
import dev.soer.utils.JDBCConnection;

public class FormHibernate implements GenericRepo<Form> {
	EmployeeServices es = new EmployeeServices();
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public Form add(Form t) {
		Session s = HibernateUtil.getSession();
		// Transaction tx = null;
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
		Form f = null;
		try {
			f = s.get(Form.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
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

//	public List<Form> getSupervisorUnapproved() {
//		List<Form> forms = new ArrayList<Form>();
//		String sql = "select * from forms where supervisorapproval = false";
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				Form f = new Form();
//				f.setId(rs.getInt("id"));
//				f.setEmpID(rs.getInt("empid"));
//				f.setEventDate((Date) rs.getObject("eventdate"));
//				f.setLocation(rs.getString("location"));
//				f.setDescription(rs.getString("description"));
//				f.setGradeFormat(rs.getInt("gradeformat"));
//				f.setEventtype(rs.getString("eventtype"));
//				f.setJustification(rs.getInt("justification"));
//				f.setSubmissionDate((Date) rs.getObject("submissiondate"));
//				f.setReimbursementID(rs.getInt("reimbursement"));
//				f.setSupervisorApproval(rs.getBoolean("supervisorapproval"));
//				f.setDeptHeadApproval(rs.getBoolean("deptheadapproval"));
//				f.setBCApproval(rs.getBoolean("benefitscoordinatorapproval"));
//				f.setStatus(rs.getString("status"));
//				f.setGrade(rs.getString("grade"));
//				forms.add(f);
//			}
//			return forms;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public List<Form> getSupervisorUnapproved() {
		Session s = HibernateUtil.getSession();
		List<Form> forms = null;
		try {
			forms = s.createQuery("FROM forms where supervisorApproval = false").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return forms;
	}
	
	public List<Form> getDeptHeadUnapproved() {
		Session s = HibernateUtil.getSession();
		List<Form> forms = null;
		try {
			forms = s.createQuery("FROM forms where supervisorApproval = true and deptheadapproval = false").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return forms;
	}
	
	public List<Form> getBCUnapproved() {
		Session s = HibernateUtil.getSession();
		List<Form> forms = null;
		try {
			forms = s.createQuery("FROM forms where supervisorapproval = true and deptheadapproval = true and benefitscoordinatorapproval = false").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return forms;
	}

	
}
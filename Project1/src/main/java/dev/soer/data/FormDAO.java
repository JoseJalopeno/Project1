package dev.soer.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.soer.beans.Form;
import dev.soer.beans.GradeFormats;
import dev.soer.beans.Justifications;
import dev.soer.beans.Reimbursements;
import dev.soer.utils.JDBCConnection;

public class FormDAO implements GenericRepo<Form>{
	private Connection conn = JDBCConnection.getConnection();
	@Override
	public Form add(Form f) {
		String sql = "insert into \"project1\".form values(default, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, f.getEmpID());
			ps.setTimestamp(2, f.getEventDate());
			ps.setTimestamp(3, f.getStartTime());
			ps.setString(4, f.getLocation());
			ps.setString(5, f.getDescription());
			ps.setDouble(6, f.getEventCost());
			ps.setInt(7, f.getGradeFormatID().getId());
			ps.setString(8, f.getEventtype());
			ps.setInt(9, f.getJustification().getId());
			ps.setTimestamp(10, f.getSubmissionDate());
			ps.setInt(11, f.getReimbursementID().getId());
			ps.setBoolean(12, f.isSupervisorApproval());
			ps.setBoolean(13, f.isDeptHeadApproval());
			ps.setBoolean(14, f.isBCApproval());
			ps.setBoolean(15, f.isApproval());
			ps.setString(16, f.getGrade());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Form get(Integer id) {
		Form f = new Form();
		String sql = "select f.id, f.empid, f.eventdate, f.starttime, f.location," 
				+ "f.description, f.eventcost, f.eventype, f.submissiondate,"
				+ "f.supervisorapproval, f.deptheadapproval, f.benefitscoordinatorapproval, f.approval, f.grade"
				+ "gf.id as gf_id, gf.name as gf_name, j.id as j_id, j.name as j_name"
				+ "r.id as r_id, r.name as r_name, r.percent as r_percent from f "
				+ "join gradeformats gf on f.gradeformat = gf.id"
				+ "join justifications j on f.justification = j.id"
				+ "join reimbursements r on f.reimburesemnts = r.id"
				+ "where f.id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f.setId(rs.getInt("id"));
				f.setEmpID(rs.getInt("empid"));
				f.setEventDate(rs.getTimestamp("eventdate"));
				f.setStartTime(rs.getTimestamp("statetime"));
				f.setLocation(rs.getString("location"));
				f.setDescription(rs.getString("description"));
				f.setEventCost(rs.getDouble("eventcost"));
				GradeFormats gf = new GradeFormats();
				gf.setId(rs.getInt("gf_id"));
				gf.setName(rs.getString("gf_name"));
				f.setGradeFormatID(gf);
				f.setEventtype(rs.getString("eventtype"));
				Justifications j = new Justifications();
				j.setId(rs.getInt("j_id"));
				j.setName(rs.getString("j_name"));
				f.setJustification(j);
				f.setSubmissionDate(rs.getTimestamp("submissiondate"));
				Reimbursements r = new Reimbursements();
				r.setId(rs.getInt("r_id"));
				r.setName(rs.getString("r_name"));
				r.setPercent(rs.getDouble("r_percent"));
				f.setReimbursementID(r);
				f.setSupervisorApproval(rs.getBoolean("supervisorapproval"));
				f.setDeptHeadApproval(rs.getBoolean("deptheadapproval"));
				f.setBCApproval(rs.getBoolean("benefitscoordinatorapproval"));
				f.setApproval(rs.getBoolean("approval"));
				f.setGrade(rs.getString("grade"));
				return f;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Form get(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Form> getAll() {
		List<Form> forms = new ArrayList<Form>();
		Form f = new Form();
		String sql = "select f.id, f.empid, f.eventdate, f.starttime, f.location," 
				+ "f.description, f.eventcost, f.eventype, f.submissiondate,"
				+ "f.supervisorapproval, f.deptheadapproval, f.benefitscoordinatorapproval, f.approval, f.grade"
				+ "gf.id as gf_id, gf.name as gf_name, j.id as j_id, j.name as j_name"
				+ "r.id as r_id, r.name as r_name, r.percent as r_percent from f "
				+ "join gradeformats gf on f.gradeformat = gf.id"
				+ "join justifications j on f.justification = j.id"
				+ "join reimbursements r on f.reimburesemnts = r.id";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f.setId(rs.getInt("id"));
				f.setEmpID(rs.getInt("empid"));
				f.setEventDate(rs.getTimestamp("eventdate"));
				f.setStartTime(rs.getTimestamp("statetime"));
				f.setLocation(rs.getString("location"));
				f.setDescription(rs.getString("description"));
				f.setEventCost(rs.getDouble("eventcost"));
				GradeFormats gf = new GradeFormats();
				gf.setId(rs.getInt("gf_id"));
				gf.setName(rs.getString("gf_name"));
				f.setGradeFormatID(gf);
				f.setEventtype(rs.getString("eventtype"));
				Justifications j = new Justifications();
				j.setId(rs.getInt("j_id"));
				j.setName(rs.getString("j_name"));
				f.setJustification(j);
				f.setSubmissionDate(rs.getTimestamp("submissiondate"));
				Reimbursements r = new Reimbursements();
				r.setId(rs.getInt("r_id"));
				r.setName(rs.getString("r_name"));
				r.setPercent(rs.getDouble("r_percent"));
				f.setReimbursementID(r);
				f.setSupervisorApproval(rs.getBoolean("supervisorapproval"));
				f.setDeptHeadApproval(rs.getBoolean("deptheadapproval"));
				f.setBCApproval(rs.getBoolean("benefitscoordinatorapproval"));
				f.setApproval(rs.getBoolean("approval"));
				f.setGrade(rs.getString("grade"));
				forms.add(f);
			}
			return forms;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean update(Form f) {
		String sql = "update \"project1\".form set supervisorapproval = ?, deptheadapproval = ?,"
				   + "benefitscoordinatorapproval = ?, approval = ?, grade = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, f.isSupervisorApproval());
			ps.setBoolean(2, f.isDeptHeadApproval());
			ps.setBoolean(3, f.isBCApproval());
			ps.setBoolean(4, f.isApproval());
			ps.setString(5, f.getGrade());
			
			boolean success = ps.execute();

			if (success) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remove(Form t) {
		// TODO Auto-generated method stub
		return false;
	}

}

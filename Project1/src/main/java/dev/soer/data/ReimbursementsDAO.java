package dev.soer.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.soer.beans.Reimbursements;
import dev.soer.utils.JDBCConnection;

public class ReimbursementsDAO implements GenericRepo<Reimbursements>{
	private Connection conn = JDBCConnection.getConnection();
	@Override
	public Reimbursements add(Reimbursements t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursements get(Integer id) {
		String sql = "select * from \"project1\".reimbursements where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursements r = new Reimbursements();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
				
				return r;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursements get(String user, String pass) {
		return null;
	}

	@Override
	public List<Reimbursements> getAll() {
		List<Reimbursements> reimbursements = new ArrayList<Reimbursements>();
		String sql = "select * from \"project1\".reimbursements";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reimbursements r = new Reimbursements();
				r.setId(rs.getInt("id"));
				r.setName(rs.getString("name"));
				reimbursements.add(r);
			}
			return reimbursements;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean update(Reimbursements u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Reimbursements t) {
		// TODO Auto-generated method stub
		return false;
	}

}

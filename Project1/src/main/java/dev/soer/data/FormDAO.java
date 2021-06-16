package dev.soer.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dev.soer.beans.Form;
import dev.soer.utils.JDBCConnection;

public class FormDAO implements GenericRepo<Form>{
	private Connection conn = JDBCConnection.getConnection();
	@Override
	public Form add(Form f) {
		String sql = "insert into \"project1\".form values(default, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, f.getEmpID());
			ps.setTimestamp(2, f.getEventDate());
			ps.setTimestamp(3, f.getStartTime()));
			ps.setString(4, f.getLocation());
			ps.setString(5, f.getDescription());
			ps.setDouble(6, f.getEventCost());
			ps.setInt(7, f.getEmpID());
			ps.setInt(8, f.getEmpID());
			ps.setInt(9, f.getEmpID());
			ps.setInt(10, f.getEmpID());
			ps.setInt(11, f.getEmpID());
			ps.setInt(12, f.getEmpID());
			ps.setInt(13, f.getEmpID());
			ps.setInt(14, f.getEmpID());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Form get(Integer id) {
		
		return null;
	}

	@Override
	public Form get(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Form> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Form u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Form t) {
		// TODO Auto-generated method stub
		return false;
	}

}

package dev.soer.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.soer.beans.EmployeeType;
import dev.soer.utils.JDBCConnection;

public class EmployeeTypeDAO implements GenericRepo<EmployeeType>{
	private Connection conn = JDBCConnection.getConnection();
	@Override
	public EmployeeType add(EmployeeType et) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeType get(Integer id) {
		String sql = "select * from \"project1\".employeetype where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EmployeeType et = new EmployeeType();
				et.setId(rs.getInt("id"));
				et.setName(rs.getString("name"));
				
				return et;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EmployeeType get(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeType> getAll() {
		List<EmployeeType> types = new ArrayList<EmployeeType>();
		String sql = "select * from \"project1\".employeetype";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EmployeeType et = new EmployeeType();
				et.setId(rs.getInt("id"));
				et.setName(rs.getString("name"));
				types.add(et);
			}
			return types;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean update(EmployeeType et) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(EmployeeType et) {
		// TODO Auto-generated method stub
		return false;
	}

}

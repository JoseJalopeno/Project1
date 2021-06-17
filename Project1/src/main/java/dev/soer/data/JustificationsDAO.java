package dev.soer.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.soer.beans.Justifications;
import dev.soer.utils.JDBCConnection;

public class JustificationsDAO implements GenericRepo<Justifications>{
	private Connection conn = JDBCConnection.getConnection();
	@Override
	public Justifications add(Justifications t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Justifications get(Integer id) {
		String sql = "select * from \"project1\".justifications where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Justifications j = new Justifications();
				j.setId(rs.getInt("id"));
				j.setName(rs.getString("name"));
				
				return j;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Justifications get(String user, String pass) {
		return null;
	}

	@Override
	public List<Justifications> getAll() {
		List<Justifications> justifications = new ArrayList<Justifications>();
		String sql = "select * from \"project1\".justifications";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Justifications j = new Justifications();
				j.setId(rs.getInt("id"));
				j.setName(rs.getString("name"));
				justifications.add(j);
			}
			return justifications;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean update(Justifications u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Justifications t) {
		// TODO Auto-generated method stub
		return false;
	}

}

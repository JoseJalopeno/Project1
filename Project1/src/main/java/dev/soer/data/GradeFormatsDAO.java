package dev.soer.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.soer.beans.EmployeeType;
import dev.soer.beans.GradeFormats;
import dev.soer.utils.JDBCConnection;

public class GradeFormatsDAO implements GenericRepo<GradeFormats>{
	private Connection conn = JDBCConnection.getConnection();
	@Override
	public GradeFormats add(GradeFormats t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GradeFormats get(Integer id) {
		String sql = "select * from \"project1\".gradeformats where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				GradeFormats gf = new GradeFormats();
				gf.setId(rs.getInt("id"));
				gf.setName(rs.getString("name"));
				
				return gf;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public GradeFormats get(String user, String pass) {
		return null;
	}

	@Override
	public List<GradeFormats> getAll() {
		List<GradeFormats> formats = new ArrayList<GradeFormats>();
		String sql = "select * from \"project1\".employeetype";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				GradeFormats gf = new GradeFormats();
				gf.setId(rs.getInt("id"));
				gf.setName(rs.getString("name"));
				formats.add(gf);
			}
			return formats;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean update(GradeFormats u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(GradeFormats t) {
		// TODO Auto-generated method stub
		return false;
	}

}

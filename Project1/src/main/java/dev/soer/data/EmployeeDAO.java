package dev.soer.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dev.soer.beans.Employee;
import dev.soer.utils.JDBCConnection;

public class EmployeeDAO implements GenericRepo<Employee> {
	
	private Connection conn = JDBCConnection.getConnection();

	@Override
	public Employee add(Employee e) {
		String sql = "insert into \"project1\".employees values (default, ?, ?, ?, ?, ?, ?, ?) returning *";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getFirstName());
			ps.setString(2, e.getLastName());
			ps.setInt(3, e.getEmployeeType());
			ps.setDouble(4, e.getBalance());
			ps.setString(5, e.getEmail());
			ps.setString(6, e.getUsername());
			ps.setString(7, e.getPassword());
			
			boolean success = ps.execute();
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					e.setId(rs.getInt("id"));
					return e;
				}
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee get(Integer id) {
		Employee e = new Employee();
		String sql = "select * from employees where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				e.setId(rs.getInt("id"));
				e.setFirstName(rs.getString("firstname"));;
				e.setLastName(rs.getString("lastname"));;
				e.setEmployeeType(rs.getInt("employeetype"));
				e.setBalance(rs.getDouble("reimbursementbalance"));
				e.setEmail(rs.getString("email"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				return e;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee get(String user, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		EmployeeDAO edao = new EmployeeDAO();
		Employee e = new Employee();
		e.setId(1);
		e.setFirstName("Joseph");
		e.setLastName("Soer");
		e.setEmployeeType(1);
		e.setBalance(1000.00);
		e.setUsername("jsoer");
		e.setPassword("password");
		edao.add(e);
	}
}

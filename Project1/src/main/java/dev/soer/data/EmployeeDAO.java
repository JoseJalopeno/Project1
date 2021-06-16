package dev.soer.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.soer.beans.Employee;
import dev.soer.beans.EmployeeType;
import dev.soer.utils.JDBCConnection;

public class EmployeeDAO implements GenericRepo<Employee> {

	private Connection conn = JDBCConnection.getConnection();
	static EmployeeDAO edao = new EmployeeDAO();

	@Override
	public Employee add(Employee e) {
		String sql = "insert into \"project1\".employees values (default, ?, ?, ?, ?, ?, ?, ?) returning *";

		try {
			if (edao.get(e.getUsername()) == null) {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, e.getFirstName());
				ps.setString(2, e.getLastName());
				ps.setInt(3, e.getEmployeeType().getId());
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
			} else {
				System.out.println("Username is taken already");
				return null;
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee get(Integer id) {
		Employee em = new Employee();
		String sql = "select e.id, e.firstname, e.lastname, e.reimbursementbalance, e.email, e.username, e.password, " 
		+ "et.id as et_id, et.name as et_name from \"project1\".employees e join \"project1\".employeetype et on e.employeetypeid = et.id where e.id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				em.setId(rs.getInt("id"));
				em.setFirstName(rs.getString("firstname"));
				em.setLastName(rs.getString("lastname"));
				EmployeeType et = new EmployeeType();
				et.setId(rs.getInt("et_id"));
				et.setName(rs.getString("et_name"));
				em.setEmployeeType(et);
				em.setBalance(rs.getDouble("reimbursementbalance"));
				em.setEmail(rs.getString("email"));
				em.setUsername(rs.getString("username"));
				em.setPassword(rs.getString("password"));
				return em;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Employee get(String user, String pass) {
		Employee em = new Employee();
		String sql = "select e.id, e.firstname, e.lastname, e.reimbursementbalance, e.email, e.username, e.password, " 
				+ "et.id as et_id, et.name as et_name from \"project1\".employees e join \"project1\".employeetype et on e.employeetypeid = et.id where username = ? and password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				em.setId(rs.getInt("id"));
				em.setFirstName(rs.getString("firstname"));
				em.setLastName(rs.getString("lastname"));
				EmployeeType et = new EmployeeType();
				et.setId(rs.getInt("et_id"));
				et.setName(rs.getString("et_name"));
				em.setEmployeeType(et);
				em.setBalance(rs.getDouble("reimbursementbalance"));
				em.setEmail(rs.getString("email"));
				em.setUsername(rs.getString("username"));
				em.setPassword(rs.getString("password"));
				return em;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "select e.id, e.firstname, e.lastname, e.reimbursementbalance, e.email, e.username, e.password, " 
				+ "et.id as et_id, et.name as et_name from \"project1\".employees e join \"project1\".employeetype et on e.employeetypeid = et.id";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee em = new Employee();
				em.setId(rs.getInt("id"));
				em.setFirstName(rs.getString("firstname"));
				em.setLastName(rs.getString("lastname"));
				EmployeeType et = new EmployeeType();
				et.setId(rs.getInt("et_id"));
				et.setName(rs.getString("et_name"));
				em.setEmployeeType(et);
				em.setBalance(rs.getDouble("reimbursementbalance"));
				em.setEmail(rs.getString("email"));
				em.setUsername(rs.getString("username"));
				em.setPassword(rs.getString("password"));
				employees.add(em);
			}
			return employees;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean update(Employee em) {
		String sql = "update \"project1\".employees set firstname = ?, lastname = ?,"
				+ " employeetypeid = ?, reimbursementbalance = ?, email = ?, username = ?, password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em.getFirstName());
			ps.setString(2, em.getLastName());
			ps.setInt(3, em.getEmployeeType().getId());
			ps.setDouble(4, em.getBalance());
			ps.setString(5, em.getEmail());
			ps.setString(6, em.getUsername());
			ps.setString(7, em.getPassword());

			boolean success = ps.execute();

			if (success) {
				return true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remove(Employee em) {
		// TODO Auto-generated method stub
		return false;
	}

	public Employee get(String user) {// if this returns null then the username is available
		Employee em = new Employee();
		String sql = "select username from \"project1\".employees where username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				em.setUsername(rs.getString("username"));
				return em;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}

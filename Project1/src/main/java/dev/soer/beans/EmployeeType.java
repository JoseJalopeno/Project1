package dev.soer.beans;

import javax.persistence.*;

@Entity(name = "employeetype")
@Table(name = "\"project1\".employeetype")
public class EmployeeType {
	@Id
	@Column(name = "id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String employeetype;

	public EmployeeType() {
		super();
	}

	public EmployeeType(Integer id, String employeetype) {
		super();
		this.id = id;
		this.employeetype = employeetype;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeType() {
		return employeetype;
	}

	public void setEmployeeType(String employeetype) {
		this.employeetype = employeetype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((employeetype == null) ? 0 : employeetype.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeType other = (EmployeeType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (employeetype == null) {
			if (other.employeetype != null)
				return false;
		} else if (!employeetype.equals(other.employeetype))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeType [id=" + id + ", employeetype=" + employeetype + "]";
	}

}
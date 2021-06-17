package dev.soer.beans;

import javax.persistence.*;
@Entity
@Table(name = "\"project1\".reimbursements")
public class Reimbursements {
	@Id
	@Column(name ="id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "reimbursement")
	private String name;
	private Double percent;
	
	public Reimbursements() {
		super();
	}

	public Reimbursements(Integer id, String name, Double percent) {
		super();
		this.id = id;
		this.name = name;
		this.percent = percent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((percent == null) ? 0 : percent.hashCode());
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
		Reimbursements other = (Reimbursements) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (percent == null) {
			if (other.percent != null)
				return false;
		} else if (!percent.equals(other.percent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursements [id=" + id + ", name=" + name + ", percent=" + percent + "]";
	}
	
}

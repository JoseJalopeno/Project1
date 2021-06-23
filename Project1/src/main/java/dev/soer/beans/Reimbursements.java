package dev.soer.beans;

import javax.persistence.*;
@Entity(name = "reimbursements")
@Table(name = "\"project1\".reimbursements")
public class Reimbursements {
	@Id
	@Column(name ="id", insertable = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String reimbursement;
	private Double percent;
	
	public Reimbursements() {
		super();
	}

	public Reimbursements(Integer id, String reimbursement, Double percent) {
		super();
		this.id = id;
		this.reimbursement = reimbursement;
		this.percent = percent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(String reimbursement) {
		this.reimbursement = reimbursement;
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
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
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
		if (reimbursement == null) {
			if (other.reimbursement != null)
				return false;
		} else if (!reimbursement.equals(other.reimbursement))
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
		return "Reimbursements [id=" + id + ", reimbursement=" + reimbursement + ", percent=" + percent + "]";
	}
	
}

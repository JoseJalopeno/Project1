package dev.soer.beans;

import javax.persistence.*;

@Entity(name = "justifications")
@Table(name = "\"project1\".justifications")
public class Justifications {
	@Id
	@Column(name ="id", insertable = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String justification;
	
	public Justifications() {
		super();
	}

	public Justifications(Integer id, String justification) {
		super();
		this.id = id;
		this.justification = justification;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
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
		Justifications other = (Justifications) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Justifications [id=" + id + ", justification=" + justification + "]";
	}
}

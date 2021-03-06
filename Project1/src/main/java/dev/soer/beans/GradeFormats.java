package dev.soer.beans;

import javax.persistence.*;


@Entity(name="gradeformats")
@Table(name = "\"project1\".gradeformats")
public class GradeFormats {
	@Id
	@Column(name ="id", insertable = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String gradeformat;
	
	public GradeFormats() {
		super();
	}

	public GradeFormats(Integer id, String gradeformat) {
		super();
		this.id = id;
		this.gradeformat = gradeformat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGradeformat() {
		return gradeformat;
	}

	public void setGradeformat(String gradeformat) {
		this.gradeformat = gradeformat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((gradeformat == null) ? 0 : gradeformat.hashCode());
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
		GradeFormats other = (GradeFormats) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (gradeformat == null) {
			if (other.gradeformat != null)
				return false;
		} else if (!gradeformat.equals(other.gradeformat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GradeFormats [id=" + id + ", gradeformat=" + gradeformat + "]";
	}
}

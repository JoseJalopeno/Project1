package dev.soer.beans;

import java.sql.Timestamp;

import javax.persistence.*;
@Entity(name="forms")
@Table(name = "\"project1\".forms")
public class Form {
	@Id
	@Column(name ="id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer empID;
	private Timestamp eventDate;
	private Timestamp startTime;
	private String location;
	private String description;
	private Double eventCost;
	private String eventtype;
	private Timestamp submissionDate;
	private boolean supervisorApproval;
	private boolean deptHeadApproval;
	@Column(name = "benefitscoordinatorapproval")
	private boolean BCApproval;
	private boolean approval;
	private String grade;
	@ManyToOne
	@JoinColumn(name = "gradeformat", insertable = false, updatable = false)
	private GradeFormats gradeFormatID;
	@ManyToOne
	@JoinColumn(name = "justification", insertable = false, updatable = false)
	private Justifications justification;
	@ManyToOne
	@JoinColumn(name = "reimbursement", insertable = false, updatable = false)
	private Reimbursements reimbursement;
	public Form() {
		super();
	}

	public Form(Integer id, Integer empID, Timestamp eventDate, Timestamp startTime, String location,
			String description, Double eventCost, GradeFormats gradeFormatID, String eventtype,
			Justifications justification, Timestamp submissionDate, Reimbursements reimbursement,
			boolean supervisorApproval, boolean deptHeadApproval, boolean bCApproval, boolean approval, String grade) {
		super();
		this.id = id;
		this.empID = empID;
		this.eventDate = eventDate;
		this.startTime = startTime;
		this.location = location;
		this.description = description;
		this.eventCost = eventCost;
		this.gradeFormatID = gradeFormatID;
		this.eventtype = eventtype;
		this.justification = justification;
		this.submissionDate = submissionDate;
		this.reimbursement = reimbursement;
		this.supervisorApproval = supervisorApproval;
		this.deptHeadApproval = deptHeadApproval;
		this.BCApproval = bCApproval;
		this.approval = approval;
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmpID() {
		return empID;
	}

	public void setEmpID(Integer empID) {
		this.empID = empID;
	}

	public Timestamp getEventDate() {
		return eventDate;
	}

	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getEventCost() {
		return eventCost;
	}

	public void setEventCost(Double eventCost) {
		this.eventCost = eventCost;
	}

	public GradeFormats getGradeFormatID() {
		return gradeFormatID;
	}

	public void setGradeFormatID(GradeFormats gradeFormatID) {
		this.gradeFormatID = gradeFormatID;
	}

	public String getEventtype() {
		return eventtype;
	}

	public void setEventtype(String eventype) {
		this.eventtype = eventype;
	}

	public Justifications getJustification() {
		return justification;
	}

	public void setJustification(Justifications justification) {
		this.justification = justification;
	}

	public Timestamp getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Timestamp submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Reimbursements getReimbursement() {
		return reimbursement;
	}

	public void setReimbursementID(Reimbursements reimbursement) {
		this.reimbursement = reimbursement;
	}

	public boolean isSupervisorApproval() {
		return supervisorApproval;
	}

	public void setSupervisorApproval(boolean supervisorApproval) {
		this.supervisorApproval = supervisorApproval;
	}

	public boolean isDeptHeadApproval() {
		return deptHeadApproval;
	}

	public void setDeptHeadApproval(boolean deptHeadApproval) {
		this.deptHeadApproval = deptHeadApproval;
	}

	public boolean isBCApproval() {
		return BCApproval;
	}

	public void setBCApproval(boolean bCApproval) {
		BCApproval = bCApproval;
	}
	
	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (BCApproval ? 1231 : 1237);
		result = prime * result + (approval ? 1231 : 1237);
		result = prime * result + (deptHeadApproval ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((empID == null) ? 0 : empID.hashCode());
		result = prime * result + ((eventCost == null) ? 0 : eventCost.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventtype == null) ? 0 : eventtype.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((gradeFormatID == null) ? 0 : gradeFormatID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((submissionDate == null) ? 0 : submissionDate.hashCode());
		result = prime * result + (supervisorApproval ? 1231 : 1237);
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
		Form other = (Form) obj;
		if (BCApproval != other.BCApproval)
			return false;
		if (approval != other.approval)
			return false;
		if (deptHeadApproval != other.deptHeadApproval)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (empID == null) {
			if (other.empID != null)
				return false;
		} else if (!empID.equals(other.empID))
			return false;
		if (eventCost == null) {
			if (other.eventCost != null)
				return false;
		} else if (!eventCost.equals(other.eventCost))
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventtype == null) {
			if (other.eventtype != null)
				return false;
		} else if (!eventtype.equals(other.eventtype))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (gradeFormatID == null) {
			if (other.gradeFormatID != null)
				return false;
		} else if (!gradeFormatID.equals(other.gradeFormatID))
			return false;
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
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (reimbursement == null) {
			if (other.reimbursement != null)
				return false;
		} else if (!reimbursement.equals(other.reimbursement))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (submissionDate == null) {
			if (other.submissionDate != null)
				return false;
		} else if (!submissionDate.equals(other.submissionDate))
			return false;
		if (supervisorApproval != other.supervisorApproval)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", empID=" + empID + ", eventDate=" + eventDate + ", startTime=" + startTime
				+ ", location=" + location + ", description=" + description + ", eventCost=" + eventCost
				+ ", gradeFormatID=" + gradeFormatID + ", eventtype=" + eventtype + ", justification=" + justification
				+ ", submissionDate=" + submissionDate + ", reimbursement=" + reimbursement
				+ ", supervisorApproval=" + supervisorApproval + ", deptHeadApproval=" + deptHeadApproval
				+ ", BCApproval=" + BCApproval + ", approval=" + approval + ", grade=" + grade + "]";
	}

	
}
	
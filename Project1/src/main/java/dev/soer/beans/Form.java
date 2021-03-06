package dev.soer.beans;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;
@Entity(name="forms")
@Table(name = "\"project1\".forms")
public class Form {
	@Id
	@Column(name ="id", insertable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer empID;
	private Date eventDate;
	//private Time startTime;
	private String location;
	private String description;
	private Double eventCost;
	private String eventtype;
	private Date submissionDate;
	private boolean supervisorApproval;
	private boolean deptHeadApproval;
	@Column(name = "benefitscoordinatorapproval")
	private boolean BCApproval;
	private String status;
	private String grade;
	private String reason;
//	@ManyToOne
//	@JoinColumn(name = "gradeformat", insertable = false, updatable = false)
	private Integer gradeformat;
//	@ManyToOne
//	@JoinColumn(name = "justification", insertable = false, updatable = false)
	private Integer justification;
//	@ManyToOne
//	@JoinColumn(name = "reimbursement", insertable = false, updatable = false)
	private Integer reimbursement;
	public Form() {
		super();
	}

	public Form(Integer id, Integer empID, Date eventDate, String location,
			String description, Double eventCost, Integer gradeFormatID, String eventtype,
			Integer justification, Date submissionDate, Integer reimbursement,
			boolean supervisorApproval, boolean deptHeadApproval, boolean bCApproval, String status, String grade, String reason) {
		super();
		this.id = id;
		this.empID = empID;
		this.eventDate = eventDate;
		this.location = location;
		this.description = description;
		this.eventCost = eventCost;
		this.gradeformat = gradeFormatID;
		this.eventtype = eventtype;
		this.justification = justification;
		this.submissionDate = submissionDate;
		this.reimbursement = reimbursement;
		this.supervisorApproval = supervisorApproval;
		this.deptHeadApproval = deptHeadApproval;
		this.BCApproval = bCApproval;
		this.status = status;
		this.grade = grade;
		this.reason = reason;
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

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
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

	public Integer getGradeFormat() {
		return gradeformat;
	}

	public void setGradeFormat(Integer gradeFormatID) {
		this.gradeformat = gradeFormatID;
	}

	public String getEventtype() {
		return eventtype;
	}

	public void setEventtype(String eventype) {
		this.eventtype = eventype;
	}

	public Integer getJustification() {
		return justification;
	}

	public void setJustification(Integer justification) {
		this.justification = justification;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Integer getReimbursement() {
		return reimbursement;
	}

	public void setReimbursementID(Integer reimbursement) {
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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (BCApproval ? 1231 : 1237);
		result = prime * result + (deptHeadApproval ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((empID == null) ? 0 : empID.hashCode());
		result = prime * result + ((eventCost == null) ? 0 : eventCost.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventtype == null) ? 0 : eventtype.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((gradeformat == null) ? 0 : gradeformat.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((reimbursement == null) ? 0 : reimbursement.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (gradeformat == null) {
			if (other.gradeformat != null)
				return false;
		} else if (!gradeformat.equals(other.gradeformat))
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
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (reimbursement == null) {
			if (other.reimbursement != null)
				return false;
		} else if (!reimbursement.equals(other.reimbursement))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		return "Form [id=" + id + ", empID=" + empID + ", eventDate=" + eventDate + ", location=" + location
				+ ", description=" + description + ", eventCost=" + eventCost + ", eventtype=" + eventtype
				+ ", submissionDate=" + submissionDate + ", supervisorApproval=" + supervisorApproval
				+ ", deptHeadApproval=" + deptHeadApproval + ", BCApproval=" + BCApproval + ", status=" + status
				+ ", grade=" + grade + ", reason=" + reason + ", gradeformat=" + gradeformat + ", justification="
				+ justification + ", reimbursement=" + reimbursement + "]";
	}

	
	
}
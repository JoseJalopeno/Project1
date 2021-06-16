package dev.soer.beans;

import java.sql.Timestamp;

public class Form {

	private Integer id;
	private Integer empID;
	private Timestamp eventDate;
	private Timestamp startTime;
	private String location;
	private String description;
	private Double eventCost;
	private Integer gradeFormatID;
	private String eventype;
	private Integer justification;
	private Timestamp submissionDate;
	private Integer reimbursementID;
	private boolean supervisorApproval;
	private boolean deptHeadApproval;
	private boolean BCApproval;
	
	public Form() {
		super();
	}

	public Form(Integer id, Integer empID, Timestamp eventDate, Timestamp startTime, String location,
			String description, Double eventCost, Integer gradeFormatID, String eventype, Integer justification,
			Timestamp submissionDate, Integer reimbursementID, boolean supervisorApproval, boolean deptHeadApproval,
			boolean bCApproval) {
		super();
		this.id = id;
		this.empID = empID;
		this.eventDate = eventDate;
		this.startTime = startTime;
		this.location = location;
		this.description = description;
		this.eventCost = eventCost;
		this.gradeFormatID = gradeFormatID;
		this.eventype = eventype;
		this.justification = justification;
		this.submissionDate = submissionDate;
		this.reimbursementID = reimbursementID;
		this.supervisorApproval = supervisorApproval;
		this.deptHeadApproval = deptHeadApproval;
		this.BCApproval = bCApproval;
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

	public Integer getGradeFormatID() {
		return gradeFormatID;
	}

	public void setGradeFormatID(Integer gradeFormatID) {
		this.gradeFormatID = gradeFormatID;
	}

	public String getEventype() {
		return eventype;
	}

	public void setEventype(String eventype) {
		this.eventype = eventype;
	}

	public Integer getJustification() {
		return justification;
	}

	public void setJustification(Integer justification) {
		this.justification = justification;
	}

	public Timestamp getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Timestamp submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Integer getReimbursementID() {
		return reimbursementID;
	}

	public void setReimbursementID(Integer reimbursementID) {
		this.reimbursementID = reimbursementID;
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
		result = prime * result + ((eventype == null) ? 0 : eventype.hashCode());
		result = prime * result + ((gradeFormatID == null) ? 0 : gradeFormatID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((reimbursementID == null) ? 0 : reimbursementID.hashCode());
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
		if (eventype == null) {
			if (other.eventype != null)
				return false;
		} else if (!eventype.equals(other.eventype))
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
		if (reimbursementID == null) {
			if (other.reimbursementID != null)
				return false;
		} else if (!reimbursementID.equals(other.reimbursementID))
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
				+ ", gradeFormatID=" + gradeFormatID + ", eventype=" + eventype + ", justification=" + justification
				+ ", submissionDate=" + submissionDate + ", reimbursementID=" + reimbursementID
				+ ", supervisorApproval=" + supervisorApproval + ", deptHeadApproval=" + deptHeadApproval
				+ ", BCApproval=" + BCApproval + "]";
	}
	
	
	
	
}
	
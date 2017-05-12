package com.cmpe281.domain;

public class Tenant {

	String id;
	String firstName;
	String lastName;
	String enrollmentId;
	Integer scale;
	Integer points;
	String extraCredit;
	String comments;
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public Integer getScale() {
		return scale;
	}
	public void setScale(Integer scale) {
		this.scale = scale;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public String getExtraCredit() {
		return extraCredit;
	}
	public void setExtraCredit(String extraCredit) {
		this.extraCredit = extraCredit;
	}
	
}
package com.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "employee")
public class Product {


	
@Id
//@GeneratedValue

private int id;
private String name;
private String department;
@JsonFormat(pattern = "yyyy-mm-dd", shape = Shape.STRING)
@Column(name = "dob")
private String dob;

@Temporal(TemporalType.DATE)
@Column(name="created")
private Date created;
@PrePersist
private void onCreate() {
	created = new Date();
}

public Product() {

}

public Product(String name, String department, String dob) {
	super();
	this.name = name;
	this.department = department;
	this.dob = dob;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}

public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}

}

package com.skuera.entity;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * @author skuera
 *
 */
@Entity
@Table(name="employee")
public class Employee{
	
	
	@Id
	@GeneratedValue
	@Column(name="emp_id")
	private int eId;
	
	@Column(name="emp_name")
	private String eName;
	
	@Column(name="emp_gender")
	private int eGender;
	
	
	@ManyToOne
	@JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
	private Dept department;


	public int geteId() {
		return eId;
	}


	public void seteId(int eId) {
		this.eId = eId;
	}


	public String geteName() {
		return eName;
	}


	public void seteName(String eName) {
		this.eName = eName;
	}





	public int geteGender() {
		return eGender;
	}


	public void seteGender(int eGender) {
		this.eGender = eGender;
	}


	public Dept getDepartment() {
		return department;
	}


	public void setDepartment(Dept department) {
		this.department = department;
	}



	


	
	

	
	


}

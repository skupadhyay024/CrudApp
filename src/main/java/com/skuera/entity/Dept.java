package com.skuera.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author skuera
 *
 */
@Entity
@Table(name="dept")
public class Dept {

	@Id
	@GeneratedValue
	@Column(name="dept_id")
	private int deptId;
	
	@Column(name="dept_name")
	private String deptName;
	
	@OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL, mappedBy = "department")
	private Set<Employee> empoyees;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee> getEmpoyees() {
		return empoyees;
	}

	public void setEmpoyees(Set<Employee> empoyees) {
		this.empoyees = empoyees;
	}
	
	
}

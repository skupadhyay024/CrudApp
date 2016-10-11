package com.skuera.service;

import java.util.List;

import com.skuera.entity.Dept;
import com.skuera.entity.Employee;


public interface SerI {
	public  List<Employee> getEmployee();
	public  List<Dept> getDept();
	public Employee getEmployeeById(int eid);
	public int saveEmployee(Employee emp);
	public int deleteEmployee(int emp);
	public int updateEmployee(Employee emp);

}

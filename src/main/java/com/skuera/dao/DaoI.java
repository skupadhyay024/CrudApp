package com.skuera.dao;

import java.util.List;

import com.skuera.entity.Dept;
import com.skuera.entity.Employee;

public interface DaoI {
	public  List<Employee> getEmployee();
	public  List<Dept> getDept();
	public Employee getEmployeeById(int eid);
	public Dept getDeptById(int deptId);
	public int saveEmployee(Employee emp);
	public int deleteEmployee(Employee emp);
	public int updateEmployee(Employee emp);

}

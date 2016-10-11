package com.skuera.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skuera.dao.DaoI;
import com.skuera.entity.Dept;
import com.skuera.entity.Employee;


@Service
@Transactional
public class SerImpl implements SerI{
	
	@Autowired
	private DaoI dao;
	
	

	public void setDao(DaoI dao) {
		this.dao = dao;
	}


	@Override
	public List<Employee> getEmployee() {
		// TODO Auto-generated method stub
		return dao.getEmployee();
	}



	@Override
	public Employee getEmployeeById(int eid) {
		// TODO Auto-generated method stub
		return dao.getEmployeeById(eid);
	}



	@Override
	public int saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Dept dept=dao.getDeptById(emp.getDepartment().getDeptId());
		emp.setDepartment(dept);
		return dao.saveEmployee(emp);
	}



	@Override
	public int deleteEmployee(int emp) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(dao.getEmployeeById(emp));
	}



	@Override
	public int updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(emp);
	}
	@Override
	public List<Dept> getDept() {
		// TODO Auto-generated method stub
		return dao.getDept();
	}



	
	
		
		


	

}


package com.skuera.dao;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skuera.entity.Dept;
import com.skuera.entity.Employee;

/**
 * @author skuera
 *
 */
@Repository
@Transactional
public class DaoImpl implements DaoI {
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Employee> getEmployee() {
		 String hql="from Employee e";
		List<Employee> elist= (List<Employee>) sessionFactory.getCurrentSession().createQuery(hql).list();
		 
		return elist;
	}

	@Override
	public Employee getEmployeeById(int eid) {
		Employee employee=(Employee) sessionFactory.getCurrentSession().get(Employee.class,eid);
		 if(employee!=null){
	            Hibernate.initialize(employee.getDepartment());
	        }
		
		return employee;
	}

	@Override
	@Transactional
	public int saveEmployee(Employee emp) {
		try{
			sessionFactory.getCurrentSession().save(emp);
		return 1;
		}catch(DataAccessException e){
			
		return 0;	
		}
		
	}

	@Override
	public int deleteEmployee(Employee emp) {
		sessionFactory.getCurrentSession().delete(emp);
		return 1;
	}

	@Override
	public int updateEmployee(Employee emp) {
		sessionFactory.getCurrentSession().merge(emp);
		return 1;
	}

	@Override
	public List<Dept> getDept() {
		 String hql="from Dept d";
			List<Dept> elist= (List<Dept>) sessionFactory.getCurrentSession().createQuery(hql).list();
			 
			return elist;
	}

	@Override
	public Dept getDeptById(int deptId) {
		Dept dep=(Dept) sessionFactory.getCurrentSession().load(Dept.class,deptId);
		
		
		return dep;
	}

	
	

}

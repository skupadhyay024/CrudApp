package com.skuera.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skuera.entity.Dept;
import com.skuera.entity.Employee;
import com.skuera.service.SerI;

/**
 * @author skuera
 *
 */
@Controller
public class EmployeeController {
	
	
	@Autowired
	private SerI ser;
	
	
	
	public void setSer(SerI ser) {
		this.ser = ser;
	}


	@RequestMapping(method=RequestMethod.GET,value="/emplist.do")
	public String getEmployeeList(HttpServletRequest request,HttpServletResponse response,Model model){
	
		HttpSession sess=request.getSession();
		List<Employee> empList=new ArrayList<>();
		
		empList = ser.getEmployee();
		sess.setAttribute("emplist",empList);
		
		return "empList";
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/addemp.do")
	public String getAddEmployee(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		HttpSession sess=request.getSession();
		System.out.println("Shashi");
		Map<Integer,String> dept=new HashMap<>();
		List<Dept> deptList=ser.getDept();
	for(Dept d:deptList){
		dept.put(d.getDeptId(),d.getDeptName());	
	}
	
			Employee emp=new Employee();
			model.addAttribute("emp", emp);
			sess.setAttribute("eDept", dept);
			model.addAttribute("edit", false);
	        return "addEmp";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addemp.do")
	public ModelAndView AddEmployee(@ModelAttribute("emp") Employee emp){

				ser.saveEmployee(emp);
		
		return new ModelAndView("redirect:emplist.do");
	}
	
	   @RequestMapping(value = { "/edit-emp-{empId}" }, method = RequestMethod.GET)
	    public String editEmployee(@PathVariable Integer empId, Model model) {
	        Employee emp=new Employee();
		
				emp = ser.getEmployeeById(empId);
			
	      
	        model.addAttribute("emp", emp);
	        model.addAttribute("edit", true);
	        return "addEmp";
	    }
	   
	   @RequestMapping(value = { "/edit-emp-{empId}" }, method = RequestMethod.POST)
	    public ModelAndView updateStudent(@ModelAttribute("emp") Employee emp,Model model) {
		   System.out.println(emp.geteId()+"$$$");
		
				ser.updateEmployee(emp);
			
	      
	      
	        model.addAttribute("emp", emp);
	        return new ModelAndView("redirect:emplist.do");
	    }
	   
	   @RequestMapping(value = { "/delete-emp-{empId}" }, method = RequestMethod.GET)
	    public ModelAndView deleteEmployee(@PathVariable Integer empId, Model model) {
	      
		
				ser.deleteEmployee(empId);
			
	      
				return new ModelAndView("redirect:emplist.do");
	    }
	   

}

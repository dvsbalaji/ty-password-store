package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.Employeedto;
import com.ty.service.EmployeeService;

public class EmployeeController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name") ;
		long phone = Long.parseLong(req.getParameter("phone")) ;
		String address = req.getParameter("address") ;
		String gender = req.getParameter("gender") ;
		String role = req.getParameter("role") ;
		
		Employeedto employeedto =  new Employeedto() ;
		employeedto.setName(name);
		employeedto.setPhone(phone);
		employeedto.setAddress(address);
		employeedto.setGender(gender);
		employeedto.setRole(role);
		
		EmployeeService employeeService =  new EmployeeService() ;
		Employeedto dto = employeeService.saveEmployee(employeedto) ;
		PrintWriter printWriter = resp.getWriter() ;
		
		if(dto != null) {
			
			printWriter.write("<html><body>");
			printWriter.write("<h1>hello "+dto.getName() + "  your Employee id is : "+dto.getId()+"</h1>");
			printWriter.write("</body></html>");
			
		}else {
			printWriter.write("<html><body>");
			printWriter.write("<h1>Employee not saved</hl>");
			printWriter.write("</body></html>");
		}
		
		

	}
}

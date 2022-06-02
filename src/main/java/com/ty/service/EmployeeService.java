package com.ty.service;

import com.ty.dao.EmployeeDao;
import com.ty.dto.Employeedto;

public class EmployeeService {

	public Employeedto saveEmployee(Employeedto employeedto)  {
		EmployeeDao dao = new EmployeeDao() ;
		return dao.saveEmployee(employeedto) ;
	}
}

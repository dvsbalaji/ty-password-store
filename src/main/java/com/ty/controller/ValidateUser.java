package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.UserDto;
import com.ty.service.UserService;

public class ValidateUser extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email") ;
		String password = req.getParameter("password") ;

		
		UserService service = new UserService() ;
		UserDto dto = service.validateUser(email ,password);
		PrintWriter printWriter = resp.getWriter() ;
	
		
		if(dto != null) {
			
			printWriter.write("<html><body>");
			printWriter.write("<h1>hello "+dto.getName() + "  you have logged in successfully </h1>");
			printWriter.write("</body></html>");
			
		}else {
			printWriter.write("<html><body>");
			printWriter.write("<h1>Invalid user</hl>");
			printWriter.write("</body></html>");
		}
		
		

	}
}

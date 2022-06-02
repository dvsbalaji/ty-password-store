package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dto.UserDto;
import com.ty.service.UserService;

public class UserController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name") ;
		String email = req.getParameter("email") ;
		String password = req.getParameter("password") ;
		String gender = req.getParameter("gender") ;
		
		UserDto dto = new UserDto() ;
		
		dto.setName(name);
		dto.setEmail(email);
		dto.setPassword(password);
		dto.setGender(gender);
		
		UserService service = new UserService() ;
		UserDto saved = service.saveUser(dto) ;
		PrintWriter printWriter = resp.getWriter() ;
		
		if(saved != null) {
			
			
			
//			printWriter.write("<h1>user Id : "+saved.getId()+"</h1>");
//			printWriter.write("<h1>user name : "+saved.getName()+"</h1>");
//			printWriter.write("<h1>user email : "+saved.getEmail()+"</h1>");
//			printWriter.write("<h1>user password : "+saved.getPassword()+"</h1>");
//			printWriter.write("<h1>user gender : "+saved.getGender()+"</h1>");
			printWriter.write("<html><body>");
			printWriter.write("<h1>hello "+saved.getName() + "  your reg id is : "+saved.getId()+"</h1>");
			printWriter.write("</body></html>");
			
		}else {
			printWriter.write("<html><body>");
			printWriter.write("<h1>user not saved</hl>");
			printWriter.write("</body></html>");
		}
		
	}

	
}

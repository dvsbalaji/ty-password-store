package com.ty.service;

import com.ty.dao.UserDao;
import com.ty.dto.UserDto;

public class UserService {

	UserDao dao = new UserDao() ; 
	
	public UserDto saveUser(UserDto userDto) {
		
		return dao.saveUser(userDto) ;
	}
	
	public UserDto validateUser(String email ,String password) {
		return dao.validateUser(email, password) ;
	}
}

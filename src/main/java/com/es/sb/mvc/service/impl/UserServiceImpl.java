package com.es.sb.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.sb.mvc.dao.UserDao;
import com.es.sb.mvc.entity.UserEntity;
import com.es.sb.mvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public List<UserEntity> getUserDetails() {
		return userDao.getUserDetails();
	}

}

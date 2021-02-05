package com.springboot.web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.controller.SearchController;
import com.springboot.web.model.UserInfoEntityCrudRepo;
import com.springboot.web.model.UserInfoEntityCrudRepo;
import com.springboot.web.model.UserInfoEntity;

@Service
public class EditService {

	@Autowired
	UserInfoEntityCrudRepo userEntityCrudRepository;
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);

	public boolean updateUser(UserInfoEntityCrudRepo user) {
		logger.info("Inside updateUser fileName = EditService.java");
		userEntityCrudRepository.save(user);
		return true;
	}
}
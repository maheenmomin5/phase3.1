package com.springboot.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.web.model.UserInfoEntity;
import com.springboot.web.service.EditService;
import com.springboot.web.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	SearchService service;
	private static Logger logger = LoggerFactory.getLogger(SearchController.class);

	@RequestMapping(value = "/usersearch", method = RequestMethod.GET)
	public String showSearchUser(ModelMap model) {
		logger.info("Inside search User");
		model.addAttribute("userSearch", new UserInfoEntity());
		return "usersearch";
	}

	@RequestMapping(value = "/usersearch", method = RequestMethod.POST)
	public String processSearchUser(@ModelAttribute("userSearch") UserInfoEntity user, ModelMap model) {
		logger.info("Inside processSearchUser fileName = SearchController.java");
		if (user.getLastName() != "") {
			boolean userExist = service.searchUser(user);
			if (userExist) {
				return "redirect:useredit";
			} else {
				logger.warn("USER NOT FOUND");
				return "usernotfound";
			}
		}
		
		logger.warn("BLANK USERNAME DETECTED, USERNAME CANNOT BE BLANK");
		model.addAttribute("search", "username field cannot be blank");
		return "usersearch";
	}

}

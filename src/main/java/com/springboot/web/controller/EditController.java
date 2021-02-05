package com.springboot.web.controller;

import java.util.logging.Logger;

import org.slf4j.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.web.controller.*;
import com.springboot.web.model.*;
import com.springboot.web.service.*;
import com.springboot.web.service.EditService;

@Controller
public class EditController {
	
	@Autowired
	EditService service;
private static Logger logger = LoggerFactory.getLogger(searchController.class);
	
	@RequestMapping(value = "/useredit", method = RequestMethod.GET)
	public String showUserEdit(ModelMap model) {
		logger.info("Inside search User");
		model.addAttribute("userEdit", new UserInfoEntity());
		return "useredit";
	}
	@RequestMapping(value = "/useredit", method = RequestMethod.POST)
	public String processEdit(@ModelAttribute("userSearch")UserInfoEntity updateUser, ModelMap model) {
		logger.info("Inside processEdit fileName = EditController.java");
		if (!updateUser.equals(null) && updateUser.getFirstName() != "" && updateUser.getLastName() != "" && updateUser.getEmail() != "" && updateUser.getLocation() != "") {
			service.updateUser(updateUser);
			return "userupdated";
		}
		logger.warning("Blank TextField Detected");
		model.addAttribute("update", "Please fill the fields");
		return "useredit";
	}

}


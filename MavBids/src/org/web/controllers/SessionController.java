package org.web.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.web.beans.UserProfile;
import org.web.dao.DBMgr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class SessionController {

	final static Logger logger = Logger.getLogger(SessionController.class);

	@Autowired
	DBMgr dbMgr;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String login(String userName, String passwd){
		logger.info("Login Page");
		return "Login";
	}

	@RequestMapping(value = "/listProfiles", method = RequestMethod.GET)
	@ResponseBody
	public String listProfiles(){
		ObjectMapper mapper = new ObjectMapper();

		List<UserProfile> userProfiles = dbMgr.listUserProfiles();
		try {
			return mapper.writeValueAsString(userProfiles);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return "{}";
	}

	@RequestMapping(value = "/uploadAdvImage", method = RequestMethod.GET)
	@ResponseBody
	public String uploadAdvImage(@RequestParam("file") MultipartFile advImg){


		return "{}";
	}

}

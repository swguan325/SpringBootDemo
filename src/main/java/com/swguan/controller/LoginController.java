package com.swguan.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value = { "/", "/index" })
	public String home(Map<String, Object> model) {
		model.put("message", "Swguan !!");
		return "index";
	}

	@RequestMapping(value = "/login")
	public String login(Model model) {
		return "login";
	}

}
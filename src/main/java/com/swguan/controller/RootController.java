package com.swguan.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		model.put("message", "Swguan !!");
		return "index";
	}

}
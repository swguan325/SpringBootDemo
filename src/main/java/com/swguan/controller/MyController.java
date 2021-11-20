package com.swguan.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swguan.aop.LogAop;

@RestController
@RequestMapping("/swguan")
public class MyController {

	private Logger logger = LoggerFactory.getLogger(LogAop.class);

	@RequestMapping("test")
	public Map<String, Object> test(String userName) {
		String message = "[Controller Action]：userName=" + userName;
		logger.info(message);
		Map<String, Object> map = new HashMap<>();
		map.put("success", true);
		map.put("message", message);
		return map;
	}
}
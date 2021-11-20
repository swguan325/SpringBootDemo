package com.swguan.spring;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.swguan.filter.TimeFilter;

@Configuration
public class SpringWebFilterConfig {

	@Bean
	public FilterRegistrationBean<TimeFilter> timerFilter() {
		FilterRegistrationBean<TimeFilter> registrationBean = new FilterRegistrationBean<TimeFilter>();
		registrationBean.setFilter(new TimeFilter());
		registrationBean.setUrlPatterns(Arrays.asList("/*"));
		registrationBean.setOrder(1);
		return registrationBean;
	}

}

package com.zy.SimpleDemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy.security.core.context.SecurityContextStrategy;
import com.zy.security.core.token.Authentication;

/**
 * @author: zy;
 * @DateTime: 2020年3月3日 下午 9:02:10;
 * @Description:
 */
@Controller
public class TestController {
	public Logger logger = LoggerFactory.getLogger(getClass());

	@ResponseBody
	@RequestMapping("/post/{id}")
	public String post(@PathVariable String id) {
		Authentication authentication = SecurityContextStrategy.getContext().getAuthentication();
		System.out.println(authentication);
		logger.info("id：{}", id);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/order/{id}")
	public Object order(@PathVariable String id) {
		Authentication authentication = SecurityContextStrategy.getContext().getAuthentication();
		logger.info("id：{}", id);
		logger.info("authentication：{}", authentication);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("/hello")
	public Authentication hello(HttpServletRequest req) {
		Authentication authentication = SecurityContextStrategy.getContext().getAuthentication();
		System.out.println(req);
		logger.info("登录成功!");
		return authentication;
	}

	@RequestMapping("/send{str}")
	public String send(@PathVariable String str) {
		logger.info("申请令牌");
		return "send" + str;
	}

	@RequestMapping("/refresh")
	public String refresh() {
		logger.info("刷新令牌");
		return "refresh";
	}
}

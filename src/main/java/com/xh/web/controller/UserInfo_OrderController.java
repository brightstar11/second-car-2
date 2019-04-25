package com.xh.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("WebCar/userInfo")
public class UserInfo_OrderController {
@RequestMapping("User_order")
public String User_order(@RequestParam("username") String username) {
	//根据用户名查询用户订单
	return username;
	
}
	
	
	
	
}

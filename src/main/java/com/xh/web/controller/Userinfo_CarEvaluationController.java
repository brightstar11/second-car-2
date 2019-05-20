package com.xh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("WebCar/userInfo")
public class Userinfo_CarEvaluationController {
 @RequestMapping("CarEvaluation")
 public String CarEvaluation() {
	 
	return "elvauate";
	 
 }
 
}

package com.xh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xh.service.CarService;
import com.xh.web.model.CarModel;

@Controller
@RequestMapping("WebCar/userInfo")
public class UserInfo_CarController {
	@Autowired
	CarService car;
@RequestMapping("/buyCar")
public String buyCar() {
	return "buyCar";
	
}

// 根据车的品牌，进行模糊搜索 
@RequestMapping("/User_BuyCarSearch")
public String  BuyCarSearch( String carbrand,Model model) {
	List<CarModel> list=car.BuyCarSearch(carbrand);
	model.addAttribute("list",list);
	return "buyCar";
	
}
}

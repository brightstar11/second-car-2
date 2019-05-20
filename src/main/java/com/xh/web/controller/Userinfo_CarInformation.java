package com.xh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xh.entity.Car_Information;
import com.xh.service.Car_InformationService;


@Controller
@RequestMapping("WebCar/userInfo")
public class Userinfo_CarInformation {
@Autowired
Car_InformationService car_InformationService;
@RequestMapping("/car_Information")
public String car_Information(Model model){
	List<Car_Information> list=car_InformationService.aboutcarinformation();
	
	model.addAttribute("list",list);
	
	return "car_Information";
}
@RequestMapping("/car_InformationO")
public String car_InformationO(Model model,String title){
	System.out.println(title);
	List<Car_Information> list3=car_InformationService.aboutcarinformationO(title);
	Car_Information car_Information=list3.get(0);
	String a=car_Information.getContent();
	System.out.println(a);
List<Car_Information> list=car_InformationService.aboutcarinformation();
	
	model.addAttribute("list",list);
	model.addAttribute("list2",a);
	
	return "car_Information";
}
}

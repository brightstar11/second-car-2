package com.xh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xh.entity.CarBirth;
import com.xh.entity.CarBrands;
import com.xh.entity.Carlevel;
import com.xh.service.CarService;
import com.xh.web.model.EvaluationModel;

@Controller
@RequestMapping("WebCar/userInfo")
public class Userinfo_CarEvaluationController {
	@Autowired
	CarService car;
	//跳转，前台展示
 @RequestMapping("/CarEvaluation")
 public String CarEvaluation(Model model) {
	 
	 List<CarBrands> list2=car.CarbrandsAll();
	  List<CarBirth> list=car.Carbirth();
	  List<Carlevel> list3=car.CarLevelAll();
	 model.addAttribute("CarbrandsAll",list2);
	 model.addAttribute("CarBirthAll",list);
	 model.addAttribute("listlevel",list3);
	return "elvauate";
	 
 }
 //
 @RequestMapping("/CarEvaluationGet")
 @ResponseBody
 public Integer CarEvaluationGet(EvaluationModel evaluationModel) {
	 System.out.println("进入");
	 System.out.println(evaluationModel.toString()
		); 
	 return null;
	 
 }
 
 
}

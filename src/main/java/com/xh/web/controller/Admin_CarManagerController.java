package com.xh.web.controller;

import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xh.entity.UserInfo;
import com.xh.service.CarService;
import com.xh.service.SellCarService;
import com.xh.web.model.CarModel;
import com.xh.web.model.PageModel;



@Controller
@RequestMapping("WebCar/admin")
public class Admin_CarManagerController {
	@Autowired
	CarService car;
	@Autowired
	SellCarService sellcar;
	@RequestMapping("admin_CarManageupdateSuccess")
	public String index1(){
		return "admin_CarManageupdateSuccess";
	}
	@RequestMapping("admin_CarManageupdateError")
	public String index2(){
		return "admin_CarManageupdateError";
	}
	
	
 @RequestMapping("/Admin_CarManage")
 public String CarselectAll(Integer pageNum,Model model) {
	
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
 PageHelper.startPage(num, 5, true);
 List<CarModel> list= car.CarselectAll();
	for (int i = 0; i < list.size(); i++) {
		CarModel carModel=(CarModel)list.get(i);
		System.out.println(carModel.toString());
	}
	
		
		PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	     model.addAttribute("list",list);
	return "admin_CarManage";
 }
 
 @RequestMapping("/searchCarName")
 public String searchCarName(Integer pageNum,Model model,@RequestParam("name") String name) {
	
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
 PageHelper.startPage(num, 5, true);
 List<CarModel> list= car.searchCarName(name);
	
		
		PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	     model.addAttribute("list",list);
	return "admin_CarManage";
 }
 
 //删除操作
 @RequestMapping("/Admin_CarManageDelect")
 @ResponseBody
 public Integer Admin_CarManageDelect(Integer id) {
	 System.out.println(id);
	 int count=car.Admin_CarManageDelect(id);
	 int count2=sellcar.Admin_CarManageDelect(id);
	 
	 if(count==count2) {
		 if(count==1) {
	 return count;
	 }
		 
	 }
	 return 0;
 }
 //修改汽车状态
 @RequestMapping("/Admin_CarManageUpdate")
 @ResponseBody
 public Integer Admin_CarManageUpdate(Integer id) {
	 int carvalidateid;
	 List<CarModel> list=car.CarselectOne(id);
	 CarModel carModel=list.get(0);
	 String carvalidate=carModel.getCarvalidate();
	 if(carvalidate.equals("通过")) {
		 carvalidateid=2;
		 int count =car.Admin_CarManageUpdate(carvalidateid, id);
		 if(count==1) {
			 return 1;
		 }
	 }
	 if(carvalidate.equals("未通过")) {
		 carvalidateid=1;
		 int count =car.Admin_CarManageUpdate(carvalidateid, id);
		 if(count==1) {
			 return 1;
		 }
	 }
	 return 0;
 }
 @RequestMapping("/Admin_CarManageNo")
 public String Admin_CarManageNo(Integer pageNum,Model model) {
	
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
 PageHelper.startPage(num, 5, true);
 List<CarModel> list= car.CarselectNo();
	for (int i = 0; i < list.size(); i++) {
		CarModel carModel=(CarModel)list.get(i);
		System.out.println(carModel.toString());
	}
	
		
		PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	     model.addAttribute("list",list);
	return "admin_CarManageNo";
 }
 @RequestMapping("/Admin_CarManageYes")
 public String Admin_CarManageYes(Integer pageNum,Model model) {
	
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
 PageHelper.startPage(num, 5, true);
 List<CarModel> list= car.CarselectYes();
	for (int i = 0; i < list.size(); i++) {
		CarModel carModel=(CarModel)list.get(i);
		System.out.println(carModel.toString());
	}
	
		
		PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	     model.addAttribute("list",list);
	return "admin_CarManageYes";
 }
}

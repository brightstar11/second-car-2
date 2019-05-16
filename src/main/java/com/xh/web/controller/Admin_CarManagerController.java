package com.xh.web.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xh.common.GlobalConstant;
import com.xh.entity.Admin;
import com.xh.entity.Sellpeople_car;

import com.xh.service.AdminService;
import com.xh.service.CarService;
import com.xh.service.Car_SellpeopleService;
import com.xh.service.SellCarService;
import com.xh.service.UserInfoService;
import com.xh.web.model.CarModel;
import com.xh.web.model.PageModel;



@Controller
@RequestMapping("WebCar/admin")
public class Admin_CarManagerController {
	@Autowired
	CarService car;
	@Autowired
	SellCarService sellcar;
	@Autowired
	UserInfoService u;
	@Autowired
	AdminService a;
	@Autowired 
	Car_SellpeopleService cc;
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
 PageHelper.startPage(num, 10, true);
 List<CarModel> list= car.CarselectAll();

	
		
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
 PageHelper.startPage(num, 10, true);
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
 PageHelper.startPage(num, 10, true);
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
	     
	return "admin_CarManage";
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
 PageHelper.startPage(num, 10, true);
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
	return "admin_CarManage";
 }
 @RequestMapping("/Car_Sellpeoplecarallocation")
 public String Car_Sellpeoplecarallocation(Integer pageNum,Model model) {
	 List<Admin> list2=a.adminquery_adminpermission4();
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
 PageHelper.startPage(num, 10, true);
 List<CarModel> list= car.Car_Sellpeoplecarallocation();
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
	     model.addAttribute("list2",list2);
	return "admin_CarManage";
 }
 @RequestMapping("/car_sellpeopleAdd")
 @ResponseBody
 public Integer car_sellpeopleAdd(Sellpeople_car sellpeople_car) {
	 
	 int count=a.car_sellpeopleAdd(sellpeople_car);
	 if(count==1) {
		 int count2=car.Car_Sellpeoplecarallocation2(sellpeople_car.getCarid());
		 return count2;
	 }
	return 0;
	 
 }
 //车辆分配查看，销售人员工作
 @RequestMapping("/Car_look")
 public String Car_look(Integer pageNum,Model model,HttpSession session,HttpServletRequest request) {
	
	 
	
		
		//分页
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	 PageHelper.startPage(num, 10, true);
	 session = request.getSession(false);
	 Object vakue = session.getAttribute(GlobalConstant.LOGIN_KEY);
	 Admin admin=(Admin)vakue;
	 
	 Integer sellpeopleid=Integer.valueOf(admin.getAdminId());
	 List<Integer>list4= cc.carcarid(sellpeopleid);
	 List<CarModel> slist = new ArrayList<CarModel>();
	 for(int i=0;i<list4.size();i++) {
		 Integer carid=(Integer)list4.get(i);
		 List<CarModel> carModels=car.CarselectOne(carid);
		 CarModel carModel2=carModels.get(0);
		 if(carModel2.getCarvalidate().equals("未通过")) {
		 slist.add(carModel2);
		 }
	 }
		for (int i = 0; i < slist.size(); i++) {
			CarModel carModel=(CarModel)slist.get(i);
			System.out.println(carModel.toString());
		}
		
			
			PageInfo pageinfo = new PageInfo(slist);
			int x = pageinfo.getStartRow();
			int y = pageinfo.getEndRow();
			long z = pageinfo.getTotal();
			String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
			model.addAttribute("pageInfo",pageinfo);
			model.addAttribute("info",info);
		     model.addAttribute("list",slist);
		    return "admin_CarManage"; 
 }
 //已处理，销售人员工作
 @RequestMapping("/Car_look2")
 public String Car_look2(Integer pageNum,Model model,HttpSession session,HttpServletRequest request) {
	
	 
	
		
		//分页
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	 PageHelper.startPage(num, 10, true);
	 session = request.getSession(false);
	 Object vakue = session.getAttribute(GlobalConstant.LOGIN_KEY);
	 Admin admin=(Admin)vakue;
	 
	 Integer sellpeopleid=Integer.valueOf(admin.getAdminId());
	 List<Integer>list4= cc.carcarid(sellpeopleid);
	 List<CarModel> slist = new ArrayList<CarModel>();
	 for(int i=0;i<list4.size();i++) {
		 Integer carid=(Integer)list4.get(i);
		 List<CarModel> carModels=car.CarselectOne(carid);
		 CarModel carModel2=carModels.get(0);
		 if(carModel2.getCarvalidate().equals("通过")) {
		 slist.add(carModel2);
		 }
	 }
		for (int i = 0; i < slist.size(); i++) {
			CarModel carModel=(CarModel)slist.get(i);
			System.out.println(carModel.toString());
		}
		
			
			PageInfo pageinfo = new PageInfo(slist);
			int x = pageinfo.getStartRow();
			int y = pageinfo.getEndRow();
			long z = pageinfo.getTotal();
			String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
			model.addAttribute("pageInfo",pageinfo);
			model.addAttribute("info",info);
		     model.addAttribute("list",slist);
		    return "admin_CarManage"; 
 }
 
 
 
 
 
}

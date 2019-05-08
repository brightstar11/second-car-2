package com.xh.web.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.xh.common.MD5Util;
import com.xh.entity.UserInfo;
import com.xh.service.OrderService;
import com.xh.service.UserInfoService;
import com.xh.web.model.OrderModel;

@Controller
@RequestMapping("WebCar/userInfo")
public class UserInfo_OrderController {
	@Autowired
	UserInfoService user;
	@Autowired
	OrderService order;
	
	@RequestMapping("user_Manger")
	public String index1(String username,Model model) {
		List<UserInfo> list=user.usernameonly(username);
		UserInfo userInfo=list.get(0);
		String username1=userInfo.getUserrealname();
		System.out.println(username1);
		List<OrderModel> list2=order.user_OrderManage(username1);
		if(list2.size()==0) {
			OrderModel orderModel=new OrderModel();
			model.addAttribute("user_OrderManage",orderModel);
		}else {
			
			model.addAttribute("user_OrderManage",list2);
		}
		
		model.addAttribute("user_MangerList",userInfo);
		
		return "user_Manger";
	}

@RequestMapping("xiugaipassword")
@ResponseBody
public Integer xiugaipassword(String username,String oldpassword,String newpassword1) {
	 String userpwd=MD5Util.MD5(oldpassword);
	  Integer count=user.userinfohave(username, userpwd);
	  if(count!=1) {
		  return 0;
	  }else {
		  String newuserpwd=MD5Util.MD5(newpassword1);
		  Integer count2=user.userinfoupup1(newuserpwd, username);
		  Integer count3=user.userinfoupup1(newuserpwd, username);
		  if(count2==count3&&count2==1) {
			  return 1;
		  }else {
			return 2;
		}
	  }
	  
	
}
	//取消订单
@RequestMapping("/delectorderder")
@ResponseBody
public Integer delectorderder(OrderModel orderModel,String username) {
	List<UserInfo> list=user.selectuserinfo(username);
	if(list.size()==1) {
		UserInfo userInfo=list.get(0);
	String ordername=userInfo.getUserrealname();
	orderModel.setOrdername(ordername);
	String Ordericon=orderModel.getOrdericon();
	Ordericon=Ordericon.substring(5);
	System.out.println(Ordericon);
	orderModel.setOrdericon(Ordericon);
	int count=order.delectorderder(orderModel);
	
	if (count==1) {
		return 1;
	}else {
		return 0;
	}
	}else {
	return 0;
	}
}
@RequestMapping("/saveinformation")
@ResponseBody
public Integer saveinformation(UserInfo userInfo) {
	int count=user.userupdate(userInfo);
	if(count==1) {
		return 1;
	}
	return 0;
}
	
}

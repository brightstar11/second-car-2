package com.xh.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xh.entity.UserInfo;
import com.xh.service.CarService;
import com.xh.service.OrderService;
import com.xh.service.UserInfoService;
import com.xh.web.model.CarModel;
import com.xh.web.model.OrderModel;

@Controller
@RequestMapping("WebCar/userInfo")
public class UserInfo_BuyCarController {
	@Autowired
	CarService car;
	@Autowired
	UserInfoService UserInfoService;
	@Autowired
	OrderService OrderService;
	//进入详情页
@RequestMapping("/CarInforMation")
public String CarInforMation(Integer id,Model model) {
	List<CarModel> list=car.CarselectOne(id);
	
	
	if(list.size()==1) {
	CarModel carModel=list.get(0);
	Integer heat=carModel.getCarheat();
	if(heat==null) {
		heat=0;
	}
	heat=heat+1;
	CarModel carm=new CarModel();
	carm.setId(id);
	carm.setCarheat(heat);
	car.insertcarheat(carm);
	model.addAttribute("list",carModel);
	}else {
		CarModel carModel=new CarModel();
		model.addAttribute("list",carModel);
	}
	return "carInformation";
	
}
@RequestMapping("new_order")
@ResponseBody
public Integer new_order(OrderModel orderModel,Integer id) {
	List<CarModel> list=car.CarselectOne(id);
	if(list.size()==1) {
		CarModel carModel=list.get(0);
		String username=carModel.getCarhavename();
		List<UserInfo> list2=UserInfoService.selectuserinfo(username);
		if(list2.size()==1) {
			UserInfo userInfo=list2.get(0);
			String ordercarhavename=userInfo.getUserrealname();
			String orderhavetel=userInfo.getUserphone();
			orderModel.setOrdercarhavename(ordercarhavename);
			orderModel.setOrderhavetel(orderhavetel);
			List<UserInfo> list3=UserInfoService.selectuserinfo(orderModel.getOrdername());
			if(list3.size()==1) {
				UserInfo userInfo2=list3.get(0);
				String ordername=userInfo2.getUserrealname();
				String orderaddr=userInfo2.getUseraddress();
				String ordertel=userInfo2.getUserphone();
				orderModel.setOrdername(ordername);
				orderModel.setOrderaddr(orderaddr);
				orderModel.setOrdertel(ordertel);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String orderbegintime=df.format(new Date());
				orderModel.setOrderbegintime(orderbegintime);
				String ordericon=orderModel.getOrdericon();
				ordericon=ordericon.substring(5);
				orderModel.setOrdericon(ordericon);
				int count=OrderService.orderinsertinsert(orderModel);
				if(count==1) {
					return 1;
				}else {
					return 0;
				}
				}else {
					return 0;
				}
		}else {
			return 0;
		}
		
	}else {
		return 0;
	}

	
}
}

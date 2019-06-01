package com.xh.web.controller;



import java.util.ArrayList;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.xh.service.Car_SellpeopleService;
import com.xh.service.Order_SellpeopleService;
import com.xh.web.model.PageModel;
import com.xh.web.model.Sellpeople_Order;
import com.xh.web.model.Sellpeople_car;



@Controller
@RequestMapping("WebCar/admin")
public class AdminCar_SellpeopleController {
@Autowired
Car_SellpeopleService car;
@Autowired
Order_SellpeopleService order;

	@RequestMapping("/Sellpeople_carlook")
	public String Sellpeople_carlook(Integer pageNum,Model model) {
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	 PageHelper.startPage(num, 5, true);
	  List<Sellpeople_car> lSellpeople_cars=car.Sellpeople_carlook();
		
		    PageInfo pageinfo = new PageInfo(lSellpeople_cars);
			int x = pageinfo.getStartRow();
			int y = pageinfo.getEndRow();
			long z = pageinfo.getTotal();
			String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
			model.addAttribute("pageInfo",pageinfo);
			model.addAttribute("info",info);
		     model.addAttribute("list",lSellpeople_cars);
		 
		 
		 
		 
		return "admin_Sellpeople_Order_Car";
	}

	@RequestMapping("/Sellpeople_carlook2")
	public String Sellpeople_carlook2(Integer pageNum,Model model,@RequestParam("id") Integer id) {
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	 PageHelper.startPage(num, 5, true);
	  List<Sellpeople_car> lSellpeople_cars=car.Sellpeople_carlook();
		List<Sellpeople_car > list=new ArrayList<Sellpeople_car>();
		for(int i=0;i<lSellpeople_cars.size();i++) {
		Sellpeople_car sellpeople_car=lSellpeople_cars.get(i);
		if(sellpeople_car.getId().equals(id)) {
			list.add(sellpeople_car);
		}
		}
		    PageInfo pageinfo = new PageInfo(list);
			int x = pageinfo.getStartRow();
			int y = pageinfo.getEndRow();
			long z = pageinfo.getTotal();
			String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
			model.addAttribute("pageInfo",pageinfo);
			model.addAttribute("info",info);
		     model.addAttribute("list",list);
		 return "admin_Sellpeople_Order_Car";
	}
	@RequestMapping("/Sellpeople_orderlook")
	public String Sellpeople_orderlook(Integer pageNum,Model model) {
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	 PageHelper.startPage(num, 5, true);
	  List<Sellpeople_Order> lSellpeople_cars=order.Sellpeople_Orderlook();
		
		    PageInfo pageinfo = new PageInfo(lSellpeople_cars);
			int x = pageinfo.getStartRow();
			int y = pageinfo.getEndRow();
			long z = pageinfo.getTotal();
			String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
			model.addAttribute("pageInfo",pageinfo);
			model.addAttribute("info",info);
		     model.addAttribute("list",lSellpeople_cars);
		 
		 
		 
		 
		return "admin_Sellpeople_Order";
	}
	@RequestMapping("/Sellpeople_orderlook2")
	public String Sellpeople_orderlook2(Integer pageNum,Model model,@RequestParam("orderid") Integer orderid) {
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	 PageHelper.startPage(num, 5, true);
	  List<Sellpeople_Order> Sellpeople_Order=order.Sellpeople_Orderlook();
	  List<Sellpeople_Order > list=new ArrayList<Sellpeople_Order>();
		for(int i=0;i<Sellpeople_Order.size();i++) {
			Sellpeople_Order Sellpeople_Order2=Sellpeople_Order.get(i);
		if(Sellpeople_Order2.getOrderid().equals(orderid)) {
			list.add(Sellpeople_Order2);
		}
		}
		    PageInfo pageinfo = new PageInfo(list);
			int x = pageinfo.getStartRow();
			int y = pageinfo.getEndRow();
			long z = pageinfo.getTotal();
			String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
			model.addAttribute("pageInfo",pageinfo);
			model.addAttribute("info",info);
		     model.addAttribute("list",list);
		 
		 
		 
		 
		return "admin_Sellpeople_Order";
	}

}

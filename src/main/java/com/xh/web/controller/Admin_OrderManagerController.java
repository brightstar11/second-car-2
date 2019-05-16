package com.xh.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.xh.entity.CarOrder;
import com.xh.entity.Sellpeople_order;
import com.xh.service.AdminService;
import com.xh.service.CarService;
import com.xh.service.OrderService;
import com.xh.service.Order_SellpeopleService;
import com.xh.web.model.CarModel;
import com.xh.web.model.OrderModel;
import com.xh.web.model.PageModel;

@Controller
@RequestMapping("WebCar/admin")
public class Admin_OrderManagerController {
	@Autowired
	OrderService order;
	@Autowired 
	CarService car;
	@Autowired
	AdminService a;
	@Autowired
	Order_SellpeopleService o;
	@RequestMapping("/Admin_OrderManage")
	 public String CarselectAll(Integer pageNum,Model model) {
		
		
		//分页
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	    PageHelper.startPage(num, 5, true);
	    List<OrderModel> list= order.admin_OrderAll();
		for (int i = 0; i < list.size(); i++) {
			OrderModel orderModel=(OrderModel)list.get(i);
			System.out.println(orderModel.toString());
		}
		
			
			PageInfo pageinfo = new PageInfo(list);
			int x = pageinfo.getStartRow();
			int y = pageinfo.getEndRow();
			long z = pageinfo.getTotal();
			String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
			model.addAttribute("pageInfo",pageinfo);
			model.addAttribute("info",info);
		     model.addAttribute("list",list);
		return "admin_OrderManage";
	 }
	
	@RequestMapping("/searchOrderNo")
	 public String searchOrderNo(Integer pageNum,Model model,@RequestParam("name") Integer no) {
		
		
		
		//分页
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	    PageHelper.startPage(num, 5, true);
	    List<OrderModel> list= order.searchOrderNo(no);
		
			
			PageInfo pageinfo = new PageInfo(list);
			int x = pageinfo.getStartRow();
			int y = pageinfo.getEndRow();
			long z = pageinfo.getTotal();
			String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
			model.addAttribute("pageInfo",pageinfo);
			model.addAttribute("info",info);
		     model.addAttribute("list",list);
		return "admin_OrderManage";
	 }
	
	
	
	
	@RequestMapping("/Admin_OrderManageUpdate")
	@ResponseBody
	public Integer Admin_OrderManageUpdate(Integer orderid,String orderstatic) {
		System.out.println(orderid+" "+orderstatic);
		CarOrder carOrder=new CarOrder();
		if(orderstatic.equals("1")||orderstatic.equals("2")||orderstatic.equals("3")||orderstatic.equals("4")) {
			carOrder.setOrderid(orderid);
			carOrder.setOrderstaticid(orderstatic);
			if(orderstatic.equals("1")) {
				List<OrderModel> list=order.searchOrderNo(orderid);
				if(list.size()==1) {
					OrderModel orderModel=list.get(0);
					Integer carid=orderModel.getCarid();
					CarModel carModel=new CarModel();
					carModel.setId(carid);
					car.updatecarsell(carModel);
					
				}
			}
			if(orderstatic.equals("2")||orderstatic.equals("4")) {
			carOrder.setOrderendtime(null);
			int count=order.Admin_OrderManageUpdate(carOrder);
			
			if(count==1){
				return 1;
			}
			return 0;
		}else {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			carOrder.setOrderendtime(df.format(new Date()));// new Date()为获取当前系统时间
			int count=order.Admin_OrderManageUpdate(carOrder);
			if(count==1){
				return 1;
			}
			return 0;
		}
	}
		return 0;
	}
	
	@RequestMapping("/Admin_OrderManageNew")
	 public String Admin_OrderManageNew(Integer pageNum,Model model) {
		List<Admin> list2=a.adminquery_adminpermission4();
		
		//分页
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	    PageHelper.startPage(num, 5, true);
	    List<OrderModel> list= order.Admin_OrderManageNew();
		for (int i = 0; i < list.size(); i++) {
			OrderModel orderModel=(OrderModel)list.get(i);
			System.out.println(orderModel.toString());
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
		return "admin_OrderManage";
	 }
	
	@RequestMapping("/Admin_OrderManageFinish")
	 public String Admin_OrderManageFinish(Integer pageNum,Model model) {
		
		
		//分页
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	    PageHelper.startPage(num, 5, true);
	    List<OrderModel> list= order.Admin_OrderManageFinish();
		for (int i = 0; i < list.size(); i++) {
			OrderModel orderModel=(OrderModel)list.get(i);
			System.out.println(orderModel.toString());
		}
		
			
			PageInfo pageinfo = new PageInfo(list);
			int x = pageinfo.getStartRow();
			int y = pageinfo.getEndRow();
			long z = pageinfo.getTotal();
			String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
			model.addAttribute("pageInfo",pageinfo);
			model.addAttribute("info",info);
		     model.addAttribute("list",list);
		return "admin_OrderManage";
	 }
	
	@RequestMapping("/Admin_OrderManageFail")
	 public String Admin_OrderManageFail(Integer pageNum,Model model) {
		
		
		//分页
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	    PageHelper.startPage(num, 5, true);
	    List<OrderModel> list= order.Admin_OrderManageFail();
		for (int i = 0; i < list.size(); i++) {
			OrderModel orderModel=(OrderModel)list.get(i);
			System.out.println(orderModel.toString());
		}
		
			
			PageInfo pageinfo = new PageInfo(list);
			int x = pageinfo.getStartRow();
			int y = pageinfo.getEndRow();
			long z = pageinfo.getTotal();
			String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
			model.addAttribute("pageInfo",pageinfo);
			model.addAttribute("info",info);
		     model.addAttribute("list",list);
		return "admin_OrderManage";
	 }
	
	@RequestMapping("/Admin_OrderManageOnGoing")
	 public String Admin_OrderManageOnGoing(Integer pageNum,Model model) {
		
		
		//分页
		 PageModel pm = new PageModel();
			Integer num = 1;
			if(pageNum != null && pageNum >= 0) {
				num = pageNum;
			}
			pm.setPageNum(num);
	    PageHelper.startPage(num, 5, true);
	    List<OrderModel> list= order.Admin_OrderManageOnGoing();
		for (int i = 0; i < list.size(); i++) {
			OrderModel orderModel=(OrderModel)list.get(i);
			System.out.println(orderModel.toString());
		}
		
			
			PageInfo pageinfo = new PageInfo(list);
			int x = pageinfo.getStartRow();
			int y = pageinfo.getEndRow();
			long z = pageinfo.getTotal();
			String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
			model.addAttribute("pageInfo",pageinfo);
			model.addAttribute("info",info);
		     model.addAttribute("list",list);
		return "admin_OrderManage";
	 }
	@RequestMapping("/order_sellpeopleAdd")
	@ResponseBody
	public Integer order_sellpeopleAdd(Sellpeople_order sellpeople_order){
		System.out.println(sellpeople_order.getOrderid()+"aa"+sellpeople_order.getSellpeopleid());
		Integer orderid=sellpeople_order.getOrderid();
		
		int count=order.order_sellpeopleAdd(sellpeople_order);
		int count2=order.order_sellpeopleUpdate(orderid);
		if(count==1&&count2==1) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/Order_look")
	public String Order_look(Integer pageNum,Model model,HttpSession session,HttpServletRequest request) {
		PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
    PageHelper.startPage(num, 5, true);
    
    session = request.getSession(false);
	 Object vakue = session.getAttribute(GlobalConstant.LOGIN_KEY);
	 Admin admin=(Admin)vakue;
	 
	 Integer sellpeopleid=Integer.valueOf(admin.getAdminId());
    List<Integer> list=o.sellpeople_orderSelect(sellpeopleid);
    List<OrderModel> slist = new ArrayList<OrderModel>();
    for(int i=0;i<list.size();i++) {
    	Integer orderid=list.get(i);
    	List<OrderModel> list2=order.Sellpeople_Orderselect(orderid);
    	OrderModel orderModel=list2.get(0);
    	if(orderModel.getOrderstatic().equals("正在处理中")) {
    	slist.add(orderModel);
    	}
    }
    	PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	     model.addAttribute("list",slist);
	return "admin_OrderManage";
	}
	@RequestMapping("/Order_look2")
	public String Order_look2(Integer pageNum,Model model,HttpSession session,HttpServletRequest request) {
		PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
    PageHelper.startPage(num, 5, true);
    
    session = request.getSession(false);
	 Object vakue = session.getAttribute(GlobalConstant.LOGIN_KEY);
	 Admin admin=(Admin)vakue;
	 
	 Integer sellpeopleid=Integer.valueOf(admin.getAdminId());
    List<Integer> list=o.sellpeople_orderSelect(sellpeopleid);
    List<OrderModel> slist = new ArrayList<OrderModel>();
    for(int i=0;i<list.size();i++) {
    	Integer orderid=list.get(i);
    	List<OrderModel> list2=order.Sellpeople_Orderselect(orderid);
    	OrderModel orderModel=list2.get(0);
    	if(!orderModel.getOrderstatic().equals("正在处理中")) {
    	slist.add(orderModel);
    	}
    }
    	PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	     model.addAttribute("list",slist);
	return "admin_OrderManage";
	}
	
}

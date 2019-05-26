//package com.xh.web.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.xh.entity.Car_Information;
//import com.xh.service.Car_InformationService;
//import com.xh.web.model.CarModel;
//import com.xh.web.model.PageModel;
//
//@Controller
//@RequestMapping("WebCar/admin")
//public class Admin_CarInformationController {
//@Autowired
//Car_InformationService car_InformationService;
//
//@RequestMapping("/carInformationAdd")
//public String index() {
//	return "admin_CarInformationAdd";
//}
//@RequestMapping("/carInformationLook")
//public String carInformationLook(Model model, Integer pageNum){
//
////分页
//	 PageModel pm = new PageModel();
//		Integer num = 1;
//		if(pageNum != null && pageNum >= 0) {
//			num = pageNum;
//		}
//		pm.setPageNum(num);
//PageHelper.startPage(num, 10, true);
//List<Car_Information> list=car_InformationService.aboutcarinformation();
//	
//		
//		PageInfo pageinfo = new PageInfo(list);
//		int x = pageinfo.getStartRow();
//		int y = pageinfo.getEndRow();
//		long z = pageinfo.getTotal();
//		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
//		model.addAttribute("pageInfo",pageinfo);
//		model.addAttribute("info",info);
//	model.addAttribute("list",list);
//	return "admin_CarInformationManage";
//}
//@RequestMapping("/carinformationDelect")
//@ResponseBody
//public Integer carinformationDelect(Integer id) {
//	
//	
//	return car_InformationService.carinformationDelect(id);
//}
//@RequestMapping("admin_CarInformationLook")
//public String admin_CarInformationLook(Integer id,Model model){
//	List<Car_Information> list=car_InformationService.aboutcarinformationSee(id);
//	Car_Information car_Information=list.get(0);
//	model.addAttribute("list2",car_Information.getContent());
//	model.addAttribute("list",list);
//	
//	return "admin_CarInformationLook";
//}
//@RequestMapping("admin_CarInformationLook2")
//public String admin_CarInformationLook2(Integer id,Model model,Integer pageNum){
//	
//	 PageModel pm = new PageModel();
//		Integer num = 1;
//		if(pageNum != null && pageNum >= 0) {
//			num = pageNum;
//		}
//		pm.setPageNum(num);
//PageHelper.startPage(num, 10, true);
//List<Car_Information> list=car_InformationService.aboutcarinformationSee(id);
//	
//		
//		PageInfo pageinfo = new PageInfo(list);
//		int x = pageinfo.getStartRow();
//		int y = pageinfo.getEndRow();
//		long z = pageinfo.getTotal();
//		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
//		model.addAttribute("pageInfo",pageinfo);
//		model.addAttribute("info",info);
//	model.addAttribute("list",list);
//	return "admin_CarInformationManage";
//}
//@RequestMapping("admin_CarInformationAdd2")
//@ResponseBody
//public Integer admin_CarInformationAdd2(String content,String title) {
//	Car_Information car_Information=new Car_Information();
//	car_Information.setContent(content);
//	car_Information.setTitle(title);
//	
//	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//	String time=df.format(new Date());
//	car_Information.setTime(time);
//	
//	
//	return car_InformationService.carinformationAdd(car_Information);
//}
//}

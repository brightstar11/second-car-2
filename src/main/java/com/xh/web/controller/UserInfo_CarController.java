package com.xh.web.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xh.common.Page;
import com.xh.entity.CarBirth;
import com.xh.entity.CarBrands;
import com.xh.entity.CarColor;
import com.xh.entity.CarMileAge;
import com.xh.entity.CarPmethod;
import com.xh.entity.CarPop;
import com.xh.entity.CarPower;
import com.xh.entity.Carlevel;
import com.xh.service.CarService;
import com.xh.web.model.CarModel;

@Controller
@RequestMapping("WebCar/userInfo")
public class UserInfo_CarController {
	private static String REGEX_CHINESE = "[\u4e00-\u9fa5]";
	@Autowired
	CarService car;
@RequestMapping("/buyCar")
public String buyCar(Integer pageNum,Model model) {
	
	
	
 List<CarModel> list=car.CarselectAll();
	
	List<CarBrands> list2=car.CarbrandsAll();
	List<Carlevel> list3=car.CarLevelAll();
	List<CarMileAge> list4=car.CarmileageAll();
	List<CarBrands> list5=car.CarbrandsAll0_10();
	List<String> list6=car.CarlntimeAllYear();
	List<String> list11=car.CarlntimeAllMonth();
	List<CarColor> list7=car.CarcolorAll();
	List<CarPop> list8=car.CarpopAll();
	List<CarPower> list9=car.CarPowerAll();
	List<CarPmethod> list10=car.CarPmethodAll();
	model.addAttribute("listAll",list);
	model.addAttribute("CarbrandsAll",list2);
	model.addAttribute("listlevel",list3);
	model.addAttribute("carmileageAll",list4);
	model.addAttribute("CarbrandsAll0_10",list5);
	model.addAttribute("CarlntimeAllYear",list6);
	model.addAttribute("CarlntimeAllMonth",list11);
	model.addAttribute("CarColorAll",list7);
	model.addAttribute("CarPopAll",list8);
	model.addAttribute("CarPowerAll",list9);
	model.addAttribute("CarPmethodAll",list10);
		return "user_buyCar";
	
}
@RequestMapping("/newbuyCar")
public String newbuyCar(Model model) {
	List<CarModel> list=car.CarselectAll();
	model.addAttribute("listAll",list);
	
	return "user_newbuyCar";
	
}
//买车初始化
@RequestMapping("/buyCar1")
@ResponseBody
public List<CarModel> buyCar1() {
	 
	List<CarModel> list=car.CarselectAll();
	
	
	return list;
	
}
////搜索框搜索
//@RequestMapping("/User_BuyCarSearch124")
//@ResponseBody
//public List<CarModel> buyCarjinque(String search) {
//	 
//	
//	
//	
//	return list;
//	
//}
 //根据车的关键字段，进行模糊搜索 
@RequestMapping("/User_BuyCarSearch123")
@ResponseBody
public List<CarModel>  BuyCarSearch(Page<CarModel> page) {
	System.out.println("111");
	CarModel carModel=page.getObj();//前端传的实体
	System.out.println("222");
	Page<CarModel> result = new Page<>();
	if(carModel.getCarprice().equals("不限")) {	
	}else {
		//去除中文
		String str = carModel.getCarprice();
				 Pattern pat = Pattern.compile(REGEX_CHINESE);
			     Matcher mat = pat.matcher(str);
			     
			     String str2=mat.replaceAll("");
			     
			     if(str2.contains("-")) {
			    	 int index = str2.indexOf("-");
				     String smallNumber = str2.substring(0,index);// 截取KEY出现位置前面的字符串
				     String bigNumber = str2.substring(index+1);
				    carModel.setCarpriceleft(smallNumber);
			    	 carModel.setCarpriceright(bigNumber);
			     }else {
			    	 if(str2.equals("100")) {
			    		 carModel.setCarpriceleft("100");
				    	 carModel.setCarpriceright("1000");
			    	 }else {
			    		 carModel.setCarpriceleft("0");
				    	 carModel.setCarpriceright(str2);
					}
			    	
				}
	}
	
	List<CarModel> list=car.CarselectAlldong(carModel);
	List<CarModel> list2=new ArrayList<CarModel>();
	result.setTotal(list.size());//总数
	Integer pages=page.getPageNo();//获取当前页
	for(int i=0;i<10;i++) {
		list2.add(list.get(i+(pages-1)*10));
         
	}
	result.setDataList(list2);
	
	result.getPageNo();
	return list;
	
}
//public List<CarModel>  BuyCarSearch(CarModel carModel) {
//	if(carModel.getCarprice().equals("不限")) {	
//	}else {
//		//去除中文
//		String str = carModel.getCarprice();
//				 Pattern pat = Pattern.compile(REGEX_CHINESE);
//			     Matcher mat = pat.matcher(str);
//			     
//			     String str2=mat.replaceAll("");
//			     
//			     if(str2.contains("-")) {
//			    	 int index = str2.indexOf("-");
//				     String smallNumber = str2.substring(0,index);// 截取KEY出现位置前面的字符串
//				     String bigNumber = str2.substring(index+1);
//				    carModel.setCarpriceleft(smallNumber);
//			    	 carModel.setCarpriceright(bigNumber);
//			     }else {
//			    	 if(str2.equals("100")) {
//			    		 carModel.setCarpriceleft("100");
//				    	 carModel.setCarpriceright("1000");
//			    	 }else {
//			    		 carModel.setCarpriceleft("0");
//				    	 carModel.setCarpriceright(str2);
//					}
//			    	
//				}
//	}
//	
//	List<CarModel> list=car.CarselectAlldong(carModel);
//	
//	return list;
//	
//	
//	
//}


//卖车主页
@RequestMapping("/SaleCar")
public String salecar(Model model) {
	List<CarBrands> list2=car.CarbrandsAll();
	List<Carlevel> list3=car.CarLevelAll();
	List<CarMileAge> list4=car.CarmileageAll();
	List<CarBrands> list5=car.CarbrandsAll0_10();
	List<String> list6=car.CarlntimeAllYear();
	List<String> list11=car.CarlntimeAllMonth();
	List<CarColor> list7=car.CarcolorAll();
	List<CarPop> list8=car.CarpopAll();
	List<CarPower> list9=car.CarPowerAll();
	List<CarPmethod> list10=car.CarPmethodAll();
	List<CarBirth> list12=car.Carbirth();
	List<String> list13=car.Carnono();
	model.addAttribute("CarbrandsAll",list2);
	model.addAttribute("listlevel",list3);
	model.addAttribute("carmileageAll",list4);
	model.addAttribute("CarbrandsAll0_10",list5);
	model.addAttribute("CarlntimeAllYear",list6);
	model.addAttribute("CarlntimeAllMonth",list11);
	model.addAttribute("CarColorAll",list7);
	model.addAttribute("CarPopAll",list8);
	model.addAttribute("CarPowerAll",list9);
	model.addAttribute("CarPmethodAll",list10);
	model.addAttribute("CarBirth",list12);
	model.addAttribute("CarNono",list13);
	return"user_saleCar";
}
//存车信息
@RequestMapping("/PreserveCar")
@ResponseBody
public Integer PreserveCar(String username,CarModel carModel) {
	
	
	Integer count=car.insertCar(carModel);//存车信息
	String carno=carModel.getCarno();
	Integer count2=car.insertCar_User(carno, username);//更新汽车用户表
	if(count==1&&count==count2) {
	return 1;
	}else {
		return 0;
	}
}





}

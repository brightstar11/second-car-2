package com.xh.web.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

import com.xh.web.model.PageModel;

@Controller
@RequestMapping("WebCar/userInfo")
public class UserInfo_CarController {
	@Autowired
	CarService car;
@RequestMapping("/buyCar")
public String buyCar(Integer pageNum,Model model) {
	
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
 PageHelper.startPage(num, 10, true);
 List<CarModel> list=car.CarselectAll();
	
		
		PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	     
	
	
	
	
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

// 根据车的品牌，进行模糊搜索 
@RequestMapping("/User_BuyCarSearch")
public String  BuyCarSearch(Integer pageNum,String brandname,Model model) {
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
 PageHelper.startPage(num, 10, true);
 List<CarModel> list=car.BuyCarSearch(brandname);
	
		
		PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	    
	model.addAttribute("listAll",list);
	
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
//根据车的价格，进行模糊搜索 
@RequestMapping("/User_BuyCarSearch2")
public String  BuyCarSearch2(Integer pageNum,Integer carprice1,Integer carprice2,Model model) {
	System.out.println(carprice1+ carprice2);
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
PageHelper.startPage(num, 10, true);
List<CarModel> list=car.BuyCarSearch2(carprice1,carprice2);
	
		
		PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	    
	model.addAttribute("listAll",list);
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
//根据车的类型，进行模糊搜索
 
@RequestMapping("/User_BuyCarSearch3")
public String  BuyCarSearch3(Integer pageNum,String levelname,Model model) {
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
PageHelper.startPage(num, 10, true);
List<CarModel> list=car.BuyCarSearch3(levelname);
	PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	    
	model.addAttribute("listAll",list);
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
//根据车的里程，进行模糊搜索

@RequestMapping("/User_BuyCarSearch4")
public String  BuyCarSearch4(Integer pageNum,String carmileage,Model model) {
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
PageHelper.startPage(num, 10, true);
List<CarModel> list=car.BuyCarSearch4(carmileage);
	PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	    
	model.addAttribute("listAll",list);
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
//根据车的里程，进行模糊搜索

@RequestMapping("/User_BuyCarSearch5")
public String  BuyCarSearch5(Integer pageNum,String carcolor,Model model) {
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
PageHelper.startPage(num, 10, true);
List<CarModel> list=car.BuyCarSearch5(carcolor);
	PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	    
	model.addAttribute("listAll",list);
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

//根据车的里程，进行模糊搜索

@RequestMapping("/User_BuyCarSearch6")
public String  BuyCarSearch6(Integer pageNum,String carpop,Model model) {
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
PageHelper.startPage(num, 10, true);
List<CarModel> list=car.BuyCarSearch6(carpop);
	PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	    
	model.addAttribute("listAll",list);
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

//根据车的里程，进行模糊搜索

@RequestMapping("/User_BuyCarSearch7")
public String  BuyCarSearch7(Integer pageNum,String carpower,Model model) {
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
PageHelper.startPage(num, 10, true);
List<CarModel> list=car.BuyCarSearch7(carpower);
	PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	    
	model.addAttribute("listAll",list);
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

//根据车的里程，进行模糊搜索

@RequestMapping("/User_BuyCarSearch8")
public String  BuyCarSearch8(Integer pageNum,String carpmethod,Model model) {
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
PageHelper.startPage(num, 10, true);
List<CarModel> list=car.BuyCarSearch8(carpmethod);
	PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	    
	model.addAttribute("listAll",list);
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
	System.out.println("aa"+username+"aa");
	System.out.println(carModel.getCarno());
	Integer count=car.insertCar(carModel);//存车信息
	String carno=carModel.getCarno();
	Integer count2=car.insertCar_User(carno, username);//更新汽车用户表
	if(count==1&&count==count2) {
	return 1;
	}else {
		return 0;
	}
}


//根据车的车龄，进行模糊搜索 
@RequestMapping("/User_BuyCarSearch233")

public String BuyCarSearch233(Integer pageNum,Model model) {
	



	

	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
PageHelper.startPage(num, 10, true);
List<CarModel> list=car.BuyCarSearch23();
	
		
		PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);
	    
	model.addAttribute("listAll",list);
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


}

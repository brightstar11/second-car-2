package com.xh.web.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
	
	//排序升序 
	public static List<CarModel> sortup(List<CarModel> list,String paixubiaoshi){
		if(paixubiaoshi.equals("jgup")) {
			//排序升序
			 Collections.sort(list, new Comparator(){
					@Override
					public int compare(Object o1, Object o2) {
						CarModel stu1=(CarModel)o1;
						CarModel stu2=(CarModel)o2;
						return stu1.getCarprice().compareTo(stu2.getCarprice());
					}	    	
			    });
			
			    System.out.println("/////////////排序之后///////////////");
			    List<CarModel> list2=new ArrayList<>();
			    for(int i=0;i<list.size();i++){
			    	CarModel st=(CarModel)list.get(i);
			    	list2.add(st);
			    	
			    }
             return list2;
		}else if(paixubiaoshi.equals("jgdown")) {
			//排序降序
			 Collections.sort(list, new Comparator(){
					@Override
					public int compare(Object o1, Object o2) {
						CarModel stu1=(CarModel)o1;
						CarModel stu2=(CarModel)o2;
						return stu1.getCarprice().compareTo(stu2.getCarprice());
					}	    	
			    });
			
			    System.out.println("/////////////排序之后///////////////");
			    List<CarModel> list2=new ArrayList<>();
			    for(int i=list.size()-1;i<=0;i--){
			    	CarModel st=(CarModel)list.get(i);
			    	list2.add(st);
			    	
			    }
            return list2;
		}else if(paixubiaoshi.equals("lcup")) {
			//排序升序
			 Collections.sort(list, new Comparator(){
					@Override
					public int compare(Object o1, Object o2) {
						CarModel stu1=(CarModel)o1;
						CarModel stu2=(CarModel)o2;
						return stu1.getCarmileages().compareTo(stu2.getCarmileages());
					}	    	
			    });
			
			    System.out.println("/////////////排序之后///////////////");
			    List<CarModel> list2=new ArrayList<>();
			    for(int i=0;i<list.size();i++){
			    	CarModel st=(CarModel)list.get(i);
			    	list2.add(st);
			    	
			    }
            return list2;
		}else {
			//排序升序
			 Collections.sort(list, new Comparator(){
					@Override
					public int compare(Object o1, Object o2) {
						CarModel stu1=(CarModel)o1;
						CarModel stu2=(CarModel)o2;
						return stu1.getCarlntime().compareTo(stu2.getCarlntime());
					}	    	
			    });
			
			    System.out.println("/////////////排序之后///////////////");
			    List<CarModel> list2=new ArrayList<>();
			    for(int i=list.size()-1;i<=0;i--){
			    	CarModel st=(CarModel)list.get(i);
			    	list2.add(st);
			    	
			    }
           return list2;
		}
		
		
	}

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
public Page<CarModel>  BuyCarSearch(@RequestBody Page<CarModel> page) {
	//这里ajax pageNo 没有传过来
	
	CarModel carModel=page.getObj();//前端传的实体
	
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
	//备注  每次点击除品牌 品牌不为不限
	//carModel.setBrandname("不限");
	List<CarModel> list=car.CarselectAlldong(carModel);
	
	//对查出的数据进行排序
	String paixubiaoshi=carModel.getPaixubiaoshi();
	if(paixubiaoshi!="null"&&paixubiaoshi!="") {
	List<CarModel> list2=sortup(list, paixubiaoshi);
	System.out.println(list2.size());
	List<CarModel> list3=new ArrayList<CarModel>();
	result.setTotal(list2.size());//总数
	Integer pages=page.getPageNo();//获取当前页
	Integer pageSize=page.getPageSise();//获取每页显示数量
	int Allpage=(list2.size()/pageSize);//当前查询的总页数
	if(list2.size()%pageSize!=0) {
		Allpage=Allpage+1;
	}
	System.out.println(list2.size());
	System.out.println(Allpage);
	System.out.println(pages);
	System.out.println(pageSize);
	
	if(Allpage<pages) {
			return result;
		}else if(Allpage-1>=pages){
			for(int k=0;k<pageSize;k++) {
				list2.add(list2.get(k+(pages-1)*pageSize));
			
			}
			
			result.setDataList(list3);
			return result;
		}else if(Allpage>=pages&&pages>=(Allpage-1)){
			int num=list2.size()%pageSize;
			if(num==0) {
				for(int k=0;k<pageSize;k++) {
					list3.add(list2.get(k+(pages-1)*pageSize));
				
				
				}
				result.setDataList(list3);
				return result;
			}else {
			for(int k=0;k<num;k++) {
				list3.add(list2.get(k+(pages-1)*pageSize));
				
			}
			result.setDataList(list3);
			return result;
		}
		}
        
	
	return result;
	
	
	}
	System.out.println(list.size());
	List<CarModel> list2=new ArrayList<CarModel>();
	result.setTotal(list.size());//总数
	Integer pages=page.getPageNo();//获取当前页
	Integer pageSize=page.getPageSise();//获取每页显示数量
	int Allpage=(list.size()/pageSize);//当前查询的总页数
	if(list.size()%pageSize!=0) {
		Allpage=Allpage+1;
	}
	System.out.println(list.size());
	System.out.println(Allpage);
	System.out.println(pages);
	System.out.println(pageSize);
	
	if(Allpage<pages) {
			return result;
		}else if(Allpage-1>=pages){
			for(int k=0;k<pageSize;k++) {
				list2.add(list.get(k+(pages-1)*pageSize));
			
			}
			
			result.setDataList(list2);
			return result;
		}else if(Allpage>=pages&&pages>=(Allpage-1)){
			int num=list.size()%pageSize;
			if(num==0) {
				for(int k=0;k<pageSize;k++) {
					list2.add(list.get(k+(pages-1)*pageSize));
				
				
				}
				result.setDataList(list2);
				return result;
			}else {
			for(int k=0;k<num;k++) {
				list2.add(list.get(k+(pages-1)*pageSize));
				
			}
			result.setDataList(list2);
			return result;
		}
		}
        
	
	return result;
	
	
	
	
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
public Integer PreserveCar(@RequestParam(name="carImage",required=false)MultipartFile[] file,@RequestParam(name="username",required=false)String username,CarModel carModel) {
	
	
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

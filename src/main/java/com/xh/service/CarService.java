package com.xh.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xh.entity.CarBirth;
import com.xh.entity.CarBrands;
import com.xh.entity.CarColor;

import com.xh.entity.CarMileAge;
import com.xh.entity.CarPmethod;
import com.xh.entity.CarPop;
import com.xh.entity.CarPower;
import com.xh.entity.Carlevel;
import com.xh.web.model.CarModel;

public interface CarService {
	 public List<CarModel> CarselectAll();
	 
	 public List<CarModel> searchCarName(String brandname);
	 
	  public List<CarModel> CarselectYes();
	   public List<CarModel> CarselectNo();
	 public List<CarModel> CarselectOne(Integer id);
	 public Integer Admin_CarManageDelect(Integer id);
	 public Integer Admin_CarManageUpdate(Integer carvalidateid,Integer id);
	 
	//<!-- 根据车的品牌，进行模糊搜索 -->
	   public List<CarModel> BuyCarSearch(String  brandname);
	   //价格
	   public List<CarModel> BuyCarSearch2(Integer  carprice1,Integer  carprice2);
	   
	   
	   
	   
	   
	   
	   
	   
	   public List<CarBrands> CarbrandsAll0_10();
	   public List<CarBrands> CarbrandsAll();
	   public List<Carlevel> CarLevelAll();
	   public List<CarMileAge> CarmileageAll();
	  
	   
	   public List<CarColor> CarcolorAll();
	 //国别，只用carpop
	  
	   public List<CarPop> CarpopAll();
	   //能源，只用carpower
	  
	   public List<CarPower> CarPowerAll();
	   //类型，只用carpop
	  
	   public List<CarPmethod> CarPmethodAll();
	   
	 //查询车ling,年，只使用carlntime表
	   
	   public List<String> CarlntimeAllYear();
	   //查询车ling,年，只使用carlntime表
	  
	   public List<String> CarlntimeAllMonth();
	   
	   public List<CarBirth> Carbirth();
	   
	   public List<String> Carnono();
	   //存储车信息
	   public Integer  insertCar(CarModel carModel); 
	   public Integer insertCar_User(String carno,String username);
		
}

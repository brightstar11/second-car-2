package com.xh.service;

import java.util.List;



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
	   public List<CarModel> Car_Sellpeoplecarallocation();
	   public Integer Car_Sellpeoplecarallocation2(Integer id);
	 public List<CarModel> CarselectOne(Integer id);
	 public Integer Admin_CarManageDelect(Integer id);
	 public Integer Admin_CarManageUpdate(Integer carvalidateid,Integer id);
	 
	 
	
	 
	//<!-- 根据车的品牌，进行模糊搜索 -->
	   public List<CarModel> BuyCarSearch(String  brandname);
	   //价格
	   public List<CarModel> BuyCarSearch2(Integer  carprice1,Integer  carprice2);
	   //类型
	   public List<CarModel> BuyCarSearch3(String levelname);
	   //里程
	   public List<CarModel> BuyCarSearch4(String carmileage);
	   //颜色
	   public List<CarModel> BuyCarSearch5(String carcolor);
	   //国家
	   public List<CarModel> BuyCarSearch6(String carpop);
	   //能源
	   public List<CarModel> BuyCarSearch7(String carpower);
	   //方式
	   public List<CarModel> BuyCarSearch8(String carpmethod);
	   //价格 前4
	   public List<CarModel> BuyCarSearch21(Integer  carprice1,Integer  carprice2);
	   public List<CarModel> BuyCarSearch23();
	   public List<CarModel> BuyCarSearch24();
	   
	   
	   
	   
	   
	   
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
	   
	   public Integer  insertcarheat(CarModel carModel);
	   public Integer  updatecarsell(CarModel carModel);
	   
	   
	   public List<CarModel> CarselectAlldong(CarModel carModel);
}

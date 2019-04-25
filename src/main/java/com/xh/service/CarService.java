package com.xh.service;

import java.util.List;

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
	   public List<CarModel> BuyCarSearch(String  carbrand);
}

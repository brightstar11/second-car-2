package com.xh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xh.mapper.CarMapper;
import com.xh.service.CarService;
import com.xh.web.model.CarModel;

@Service
public class CarServiceImpl implements CarService{
@Autowired
 CarMapper CarMapper;
	@Override
	public List<CarModel> CarselectAll() {
		
		return CarMapper.CarselectAll();
	}
	@Override
	public Integer Admin_CarManageDelect(Integer id) {
		
		return CarMapper.Admin_CarManageDelect(id);
	}
	public Integer Admin_CarManageUpdate(Integer carvalidateid,Integer id ) {
		return CarMapper.Admin_CarManageUpdate(carvalidateid,id);
	}
	@Override
	public List<CarModel> CarselectOne(Integer id) {
		
		return CarMapper.CarselectOne(id);
	}
	@Override
	public List<CarModel> CarselectYes() {
		
		return CarMapper.CarselectYes();
	}
	@Override
	public List<CarModel> CarselectNo() {
		
		return CarMapper.CarselectNo();
	}
	@Override
	public List<CarModel> searchCarName(String brandname) {
		
		return CarMapper.searchCarName(brandname);
	}
	//<!-- 根据车的品牌，进行模糊搜索 -->
	 @Override
	public List<CarModel> BuyCarSearch(String carbrand) {
		
		return CarMapper.BuyCarSearch(carbrand);
	}
 
}

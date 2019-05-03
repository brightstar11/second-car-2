package com.xh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xh.entity.CarBirth;
import com.xh.entity.CarBrands;
import com.xh.entity.CarColor;

import com.xh.entity.CarMileAge;
import com.xh.entity.CarPmethod;
import com.xh.entity.CarPop;
import com.xh.entity.CarPower;
import com.xh.entity.Carlevel;
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
	public List<CarModel> BuyCarSearch(String brandname) {
		
		return CarMapper.BuyCarSearch(brandname);
	}
	@Override
	public List<CarBrands> CarbrandsAll() {
		
		return CarMapper.CarbrandsAll();
	}
	@Override
	public List<Carlevel> CarLevelAll() {
		
		return CarMapper.CarLevelAll();
	}
	@Override
	public List<CarMileAge> CarmileageAll() {
		// TODO Auto-generated method stub
		return CarMapper.CarmileageAll();
	}
	@Override
	public List<CarBrands> CarbrandsAll0_10() {
		// TODO Auto-generated method stub
		return CarMapper.CarbrandsAll0_10();
	}
	
	@Override
	public List<CarModel> BuyCarSearch2(Integer carprice1,Integer carprice2) {
		// TODO Auto-generated method stub
		return CarMapper.BuyCarSearch2(carprice1,carprice2);
	}
	@Override
	public List<CarColor> CarcolorAll() {
		// TODO Auto-generated method stub
		return CarMapper.CarcolorAll();
	}
	@Override
	public List<CarPop> CarpopAll() {
		// TODO Auto-generated method stub
		return CarMapper.CarpopAll();
	}
	@Override
	public List<CarPower> CarPowerAll() {
		// TODO Auto-generated method stub
		return CarMapper.CarPowerAll();
	}
	@Override
	public List<CarPmethod> CarPmethodAll() {
		// TODO Auto-generated method stub
		return CarMapper.CarPmethodAll();
	}
	@Override
	public List<String> CarlntimeAllYear() {
		
		// TODO Auto-generated method stub
		return CarMapper.CarlntimeAllYear();
	}
	@Override
	public List<String> CarlntimeAllMonth() {
		// TODO Auto-generated method stub
		return CarMapper.CarlntimeAllMonth();
	}
	@Override
	public List<CarBirth> Carbirth() {
		// TODO Auto-generated method stub
		return CarMapper.Carbirth();
	}
	@Override
	public List<String> Carnono() {
		// TODO Auto-generated method stub
		return CarMapper.Carnono();
	}
	@Override
	public Integer insertCar(CarModel carModel) {
		// TODO Auto-generated method stub
		return CarMapper.insertCar(carModel);
	}
	@Override
	public Integer insertCar_User(String carno, String username) {
		// TODO Auto-generated method stub
		return CarMapper.insertCar_User(carno, username);
	}
	@Override
	public List<CarModel> BuyCarSearch3(String levelname) {
		// TODO Auto-generated method stub
		return CarMapper.BuyCarSearch3(levelname);
	}
 
}

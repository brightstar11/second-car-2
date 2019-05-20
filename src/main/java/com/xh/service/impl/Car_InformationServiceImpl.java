package com.xh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xh.entity.Car_Information;
import com.xh.mapper.Car_InformationMapper;
import com.xh.service.Car_InformationService;

@Service
public class Car_InformationServiceImpl implements Car_InformationService{
@Autowired
Car_InformationMapper car;
	@Override
	public List<Car_Information> aboutcarinformation() {
		// TODO Auto-generated method stub
		return car.aboutcarinformation();
	}
	@Override
	public List<Car_Information> aboutcarinformationO(String title) {
		// TODO Auto-generated method stub
		return car.aboutcarinformationO(title);
	}
	@Override
	public Integer carinformationDelect(Integer id) {
		// TODO Auto-generated method stub
		return car.carinformationDelect(id);
	}
	@Override
	public List<Car_Information> aboutcarinformationSee(Integer id) {
		// TODO Auto-generated method stub
		return car.aboutcarinformationSee(id);
	}
	@Override
	public Integer carinformationAdd(Car_Information car_Information) {
		// TODO Auto-generated method stub
		return car.carinformationAdd(car_Information);
	}

}

package com.xh.service;

import java.util.List;

import com.xh.entity.Car_Information;

public interface Car_InformationService {
	public List<Car_Information> aboutcarinformation();
	 public List<Car_Information> aboutcarinformationO(String title);
	 public Integer carinformationDelect(Integer id);
	 public List<Car_Information> aboutcarinformationSee(Integer id);
	 public Integer carinformationAdd(Car_Information car_Information) ;
}

package com.xh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.xh.mapper.Car_SellpeopleMapper;
import com.xh.service.Car_SellpeopleService;
import com.xh.web.model.Sellpeople_car;

@Service
public class Car_SellpeopleServiceImpl implements Car_SellpeopleService{
@Autowired
 Car_SellpeopleMapper ca;
	@Override
	public List<Integer> carcarid(Integer sellpeopleid) {
		// TODO Auto-generated method stub
		return ca.carcarid(sellpeopleid);
	}
	@Override
	public Integer delectsellpeople_car(Integer sellpeopleid) {
		// TODO Auto-generated method stub
		return ca.delectsellpeople_car(sellpeopleid);
	}
	@Override
	public Integer delectsellpeople_order(Integer sellpeopleid) {
		// TODO Auto-generated method stub
		return ca.delectsellpeople_order(sellpeopleid);
	}
	@Override
	public List<Sellpeople_car> Sellpeople_carlook() {
		// TODO Auto-generated method stub
		return ca.Sellpeople_carlook();
	}

}

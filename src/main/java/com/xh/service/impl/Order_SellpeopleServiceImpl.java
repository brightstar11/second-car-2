package com.xh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xh.mapper.Order_SellpeopleMapper;
import com.xh.service.Order_SellpeopleService;
import com.xh.web.model.Sellpeople_Order;
@Service
public class Order_SellpeopleServiceImpl implements Order_SellpeopleService{
@Autowired
Order_SellpeopleMapper or;
	@Override
	public List<Integer> sellpeople_orderSelect(Integer sellpeopleid) {
		// TODO Auto-generated method stub
		return or.sellpeople_orderSelect(sellpeopleid);
	}
	@Override
	public List<Sellpeople_Order> Sellpeople_Orderlook() {
		// TODO Auto-generated method stub
		return or.Sellpeople_Orderlook();
	}

}

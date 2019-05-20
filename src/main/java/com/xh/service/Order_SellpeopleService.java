package com.xh.service;

import java.util.List;

import com.xh.web.model.Sellpeople_Order;

public interface Order_SellpeopleService {
	public List<Integer> sellpeople_orderSelect(Integer sellpeopleid);
	public List<Sellpeople_Order> Sellpeople_Orderlook();
}

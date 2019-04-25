package com.xh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xh.entity.CarOrder;
import com.xh.mapper.OrderMapper;
import com.xh.service.OrderService;
import com.xh.web.model.OrderModel;

@Service
public class OrderServiceImpl implements OrderService{
@Autowired
OrderMapper order;
	@Override
	public List<OrderModel> admin_OrderAll() {
		
		return order.admin_OrderAll();
	}
	@Override
	public Integer Admin_OrderManageUpdate(CarOrder carOrder) {
		
		return order.Admin_OrderManageUpdate(carOrder);
	}
	@Override
	public List<OrderModel> searchOrderNo(Integer orderid) {
		
		return order.searchOrderNo(orderid);
	}
	@Override
	public List<OrderModel> Admin_OrderManageOnGoing() {
		
		return order.Admin_OrderManageOnGoing();
	}
	@Override
	public List<OrderModel> Admin_OrderManageFinish() {
		
		return order.Admin_OrderManageFinish();
	}
	@Override
	public List<OrderModel> Admin_OrderManageFail() {
		
		return order.Admin_OrderManageFail();
	}

}

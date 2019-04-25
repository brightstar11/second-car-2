package com.xh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xh.entity.CarOrder;
import com.xh.web.model.OrderModel;

@Mapper
public interface OrderMapper {
	public List<OrderModel> admin_OrderAll();
	
	public List<OrderModel> searchOrderNo(Integer orderid);
	
	public List<OrderModel> Admin_OrderManageOnGoing();
	public List<OrderModel> Admin_OrderManageFinish();
	public List<OrderModel> Admin_OrderManageFail();
	
	public Integer Admin_OrderManageUpdate(CarOrder carOrder);
	
	
}

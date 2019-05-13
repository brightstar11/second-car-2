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
	public List<OrderModel> Admin_OrderManageNew();
	public Integer Admin_OrderManageUpdate(CarOrder carOrder);
	
	//根据当前用户名 查询当前用户的订单
	public List<OrderModel> user_OrderManage(String ordername);
	//根据xxx删除订单表
	public Integer delectorderder(OrderModel orderModel);
	//添加订单
	public Integer orderinsertinsert(OrderModel orderModel);
	
	
}

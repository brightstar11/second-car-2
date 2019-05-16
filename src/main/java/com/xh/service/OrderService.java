package com.xh.service;

import java.util.List;

import com.xh.entity.CarOrder;
import com.xh.entity.Sellpeople_order;
import com.xh.web.model.OrderModel;

public interface OrderService {
public List<OrderModel> admin_OrderAll();

public List<OrderModel> Admin_OrderManageOnGoing();
public List<OrderModel> Admin_OrderManageFinish();
public List<OrderModel> Admin_OrderManageFail();
public List<OrderModel> Admin_OrderManageNew();

public List<OrderModel> searchOrderNo(Integer orderid);

public Integer Admin_OrderManageUpdate(CarOrder carOrder);
public List<OrderModel> user_OrderManage(String ordername);
public Integer delectorderder(OrderModel orderModel);
public Integer orderinsertinsert(OrderModel orderModel);


public Integer order_sellpeopleAdd(Sellpeople_order sellpeople_order);
public Integer order_sellpeopleUpdate(Integer orderid);

public List<OrderModel> Sellpeople_Orderselect(Integer orderid);
}

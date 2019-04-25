package com.xh.service;

import java.util.List;

import com.xh.entity.CarOrder;
import com.xh.web.model.OrderModel;

public interface OrderService {
public List<OrderModel> admin_OrderAll();

public List<OrderModel> Admin_OrderManageOnGoing();
public List<OrderModel> Admin_OrderManageFinish();
public List<OrderModel> Admin_OrderManageFail();

public List<OrderModel> searchOrderNo(Integer orderid);

public Integer Admin_OrderManageUpdate(CarOrder carOrder);
}

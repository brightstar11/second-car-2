package com.xh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.xh.web.model.Sellpeople_Order;

@Mapper
public interface Order_SellpeopleMapper {
@Select("select orderid  from sellpeople_order where sellpeopleid=#{sellpeopleid}")
public List<Integer> sellpeople_orderSelect(Integer sellpeopleid);

@Select("select o.orderid,os.orderstatic,a.realname,a.adminphone from orders o,orderstatic os,admin a,sellpeople_order spo where spo.orderid=o.orderid and spo.sellpeopleid=a.adminid and os.orderstaticid=o.orderstaticid")
	public List<Sellpeople_Order> Sellpeople_Orderlook();
	
}

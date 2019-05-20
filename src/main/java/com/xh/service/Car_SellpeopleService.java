package com.xh.service;

import java.util.List;

import com.xh.web.model.Sellpeople_car;




public interface Car_SellpeopleService {
	public List<Integer> carcarid(Integer sellpeopleid);
	 public Integer delectsellpeople_car(Integer sellpeopleid);
    
     public Integer delectsellpeople_order(Integer sellpeopleid);
     
     public List<Sellpeople_car> Sellpeople_carlook();
}

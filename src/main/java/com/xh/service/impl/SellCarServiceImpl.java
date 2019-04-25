package com.xh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xh.mapper.SellCarMapper;
import com.xh.service.SellCarService;

@Service
public class SellCarServiceImpl implements SellCarService{
	@Autowired
	private SellCarMapper sellcar;
	@Override
	public Integer Admin_CarManageDelect(Integer id) {
		
		return sellcar.Admin_CarManageDelect(id);
	}
 
}

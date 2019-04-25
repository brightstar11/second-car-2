package com.xh.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellCarMapper {
 /*
  * car id 为唯一
    删除汽车通过car id 
   当删除汽车的同时 应该删除和汽车有关联的出售汽车-用户表
  */
	@Delete("delete from sellcar where carid=#{id}")
	public Integer Admin_CarManageDelect(Integer id);
}

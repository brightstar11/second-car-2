package com.xh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.xh.web.model.Sellpeople_car;



@Mapper
public interface Car_SellpeopleMapper {
     @Select("Select carid from sellpeople_car where sellpeopleid=#{sellpeopleid}")
     public List<Integer> carcarid(Integer sellpeopleid);
     
     @Delete("delect from sellpeople_car where sellpeopleid=#{sellpeopleid}")
     public Integer delectsellpeople_car(Integer sellpeopleid);
     @Delete("delect from sellpeople_order where sellpeopleid=#{sellpeopleid}")
     public Integer delectsellpeople_order(Integer sellpeopleid);
     
     @Select("SELECT c.id,cb.brandname,c.carname,a.realname,a.adminphone,cl.carvalidate FROM car c,carbrands cb,admin a,carvalidate cl,sellpeople_car sc WHERE sc.carid=c.id AND  sc.sellpeopleid=a.adminid AND cb.carbrandid=c.carbrandid AND cl.carvalidateid=c.carvalidateid")
     public List<Sellpeople_car> Sellpeople_carlook();
     
}

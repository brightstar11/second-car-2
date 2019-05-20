package com.xh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.xh.entity.Car_Information;

@Mapper
public interface Car_InformationMapper {
 @Select("select * from aboutcarinformation ")
 public List<Car_Information> aboutcarinformation();
 @Select("select * from aboutcarinformation where title=#{title}")
 public List<Car_Information> aboutcarinformationO(String title);
 @Delete("delect  from aboutcarinformation where id=#{id}")
 public Integer carinformationDelect(Integer id);
 @Select("select * from aboutcarinformation where id=#{id}")
 public List<Car_Information> aboutcarinformationSee(Integer id);
 @Insert("Insert into aboutcarinformation(time,title,content) VALUES(#{time},#{title},#{content})")
 public Integer carinformationAdd(Car_Information car_Information) ;
}

package com.xh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.xh.web.model.CarModel;

@Mapper
public interface CarMapper {
   public List<CarModel> CarselectAll();
   
   public List<CarModel> searchCarName(String brandname);
   
   public List<CarModel> CarselectYes();
   public List<CarModel> CarselectNo();
   public List<CarModel> CarselectOne(Integer id);
   public Integer Admin_CarManageDelect(Integer id);
   @Update("update car set carvalidateid=#{carvalidateid} where id=#{id}")
   public Integer Admin_CarManageUpdate(@Param("carvalidateid")Integer carvalidateid,@Param("id")Integer id);
   
   //<!-- 根据车的品牌，进行模糊搜索 -->
   
   public List<CarModel> BuyCarSearch(String  carbrand);
}

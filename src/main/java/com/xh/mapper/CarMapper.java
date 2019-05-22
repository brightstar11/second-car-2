package com.xh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xh.entity.CarBirth;
import com.xh.entity.CarBrands;
import com.xh.entity.CarColor;

import com.xh.entity.CarMileAge;
import com.xh.entity.CarPmethod;
import com.xh.entity.CarPop;
import com.xh.entity.CarPower;
import com.xh.entity.Carlevel;
import com.xh.web.model.CarModel;

@Mapper
public interface CarMapper {
   public List<CarModel> CarselectAll();
   
   public List<CarModel> searchCarName(String brandname);
   
   public List<CarModel> CarselectYes();
   public List<CarModel> CarselectNo();
   //后台审核
   public List<CarModel> Car_Sellpeoplecarallocation();
   @Update("update car set carallocation='是' where id=#{id}")
   public Integer Car_Sellpeoplecarallocation2(Integer id);
   //后台 审核
   public List<CarModel> CarselectOne(Integer id);
   public Integer Admin_CarManageDelect(Integer id);
   @Update("update car set carvalidateid=#{carvalidateid} where id=#{id}")
   public Integer Admin_CarManageUpdate(@Param("carvalidateid")Integer carvalidateid,@Param("id")Integer id);
   
   //<!-- 根据车的品牌，进行模糊搜索 -->
   
   public List<CarModel> BuyCarSearch(String  brandname);
   public List<CarModel> BuyCarSearch2(Integer  carprice1,Integer  carprice2);
   public List<CarModel> BuyCarSearch3(String levelname);
   public List<CarModel> BuyCarSearch4(String carmileage);
   public List<CarModel> BuyCarSearch5(String carcolor);
   public List<CarModel> BuyCarSearch6(String carpop);
   public List<CarModel> BuyCarSearch7(String carpower);
   public List<CarModel> BuyCarSearch8(String carpmethod);
   
   public List<CarModel> BuyCarSearch21(Integer  carprice1,Integer  carprice2);
   public List<CarModel> BuyCarSearch23();
   public List<CarModel> BuyCarSearch24();
   //查询车的品牌，只使用carbrands表
   @Select("select * from carbrands limit 0,10")
   public List<CarBrands> CarbrandsAll0_10();
   //查询车的品牌，只使用carbrands表
   @Select("select * from carbrands")
   public List<CarBrands> CarbrandsAll();
   //查询车的级别，只使用carlevle表
   @Select("select * from carlevels")
   public List<Carlevel> CarLevelAll();
   //查询车的里程，只使用carmileage表
   @Select("select * from carmileage")
   public List<CarMileAge> CarmileageAll();
   //查询车ling,年，只使用carlntime表
   @Select("SELECT YEAR(CURRENT_DATE)-YEAR(carlntime) AS carlntime FROM car")
   public List<String> CarlntimeAllYear();
   //查询车ling,年，只使用carlntime表
   @Select("SELECT MONTH(CURRENT_DATE)-MONTH(carlntime) AS carlntime FROM car")
   public List<String> CarlntimeAllMonth();
   //颜色，只用carcolor
   @Select("select * from carcolor")
   public List<CarColor> CarcolorAll();
 //国别，只用carpop
   @Select("select * from carpop")
   public List<CarPop> CarpopAll();
   //能源，只用carpower
   @Select("select * from carpower")
   public List<CarPower> CarPowerAll();
   //类型，只用carpop
   @Select("select * from carpmethod")
   public List<CarPmethod> CarPmethodAll();
   //生产时间
   @Select("select * from carbirth")
   public List<CarBirth> Carbirth();
   //查询车架号
   @Select("select carno from car")
   public List<String> Carnono();
   @Select("select cartype from cartype")
   public List<String> Carcartype();
   @Select("select carname from car")
   public List<String> Carcarname();
   //存储车信息
   public Integer  insertCar(CarModel carModel);
   public Integer insertCar_User(String carno,String username);
   //更新car表热度
   public Integer  insertcarheat(CarModel carModel);
   public Integer  updatecarsell(CarModel carModel);
   
   //动态查询 汽车
   public List<CarModel> CarselectAlldong(CarModel carModel);
}

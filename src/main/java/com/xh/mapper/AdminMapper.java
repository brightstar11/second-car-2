package com.xh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xh.entity.Admin;
import com.xh.entity.Sellpeople_car;
import com.xh.entity.UserInfo;

@Mapper
public interface AdminMapper {
	@Select("select * from admin where adminName=#{adminName} and adminPwd=#{adminPwd}")
	 public List<Admin> adminquery(Admin admin);
	//查询状态为4的销售人员
	@Select("select * from admin where adminpermission=4")
	 public List<Admin> adminquery_adminpermission4();
	@Select("select * from admin where adminPermission=#{adminPermission} and adminName=#{adminName}")
	 public List<Admin> searchAdminName(Admin admin);
	
	    public Integer adminregister(Admin admin);
	    @Select("select adminName from admin")
	    public List<Admin> adminnameonly();
	    public Integer adminupdate(Admin admin);
	    @Select("select * from userinfo")
	    public List<UserInfo> usermanage();
	    
	    @Select("select * from userinfo where username=#{username}")
	    public List<UserInfo> SerarchUsermanage(String username);
	    
	    @Select("select * from userinfo where id=#{id}")
	    public List<UserInfo> usermanage2(Integer id);
	    //后台管理删除用户------------------------------------------------------------------------
	   @Delete("delete from userinfo where username=#{username}")
	   public Integer usermanagedelect1(String username); 
	   
	   @Delete("delete from user_login where username=#{username}")
	   public Integer usermanagedelect2(String username); 
	   //----------------------------------------------------------------------------
   //管理员查找显示在管理员页
	   @Select("select * from admin where adminPermission=#{adminPermission}")
			   public List<Admin> adminSeletAll(String adminPermission);
	   //查找单一管理员信息
	   @Select("select * from admin where adminId=#{adminId}")
	   public List<Admin> adminSeletOne(Integer adminId);
	   //通过用户名查找单一管理员信息
	   @Select("select * from admin where adminName=#{adminName}")
	   public List<Admin> adminSeletOne2(String adminName);
	   //修改管理员信息
	   @Update("update admin set adminname=#{adminName},adminpwd=#{adminPwd},adminphone=#{adminPhone},realname=#{realName} where adminid=#{adminId}")
	   public Integer adminUpdate(Admin admin);
	   //删除管理员
	   @Delete("delete from admin where adminName=#{adminName}")
	   public Integer adminmanagedelect(String adminName);
	   
	   @Delete("delete from admin where adminId=#{adminId}")
	   public Integer adminmanagedelect2(String adminId);
	   //添加管理员
	   @Insert("insert into admin(adminname,adminpwd,adminphone,adminPermission,realname) values(#{adminName},#{adminPwd},#{adminPhone},#{adminPermission},#{realName})")
	   public Integer adminmanageAdd(Admin admin);
	   
	   //添加管理员
	   @Insert("insert into admin(adminname,adminpwd,adminphone,adminPermission,realname,adminaddress) values(#{adminName},#{adminPwd},#{adminPhone},#{adminPermission},#{realName},#{adminaddress})")
	   public Integer adminmanageAdd2(Admin admin);
	   
	   
	   
	   
	   
	   
	   //这里为后台车辆的审核管理操作
	   //添加车辆信息和审核员的关联
	   @Insert("insert into sellpeople_car(carid,sellpeopleid) values(#{carid},#{sellpeopleid})")
	   public Integer car_sellpeopleAdd(Sellpeople_car sellpeople_car);
}

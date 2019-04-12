package com.xh.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xh.entity.UserLogin;


@Mapper
public interface User_LoginMapper {
	//登录sql处理
	@Select("select * from user_login where username=#{username} and userpwd=#{userpwd}")
	public List<UserLogin> userloginquery(UserLogin userLogin);
	//注册
	@Insert("insert into user_login(username,userpwd) values(#{username},#{userpwd})")
	public Integer userloginregister(UserLogin userLogin);
    //修改
	@Update("update user_login set username=#{username},userpwd=#{userpwd} where id=#{id}")
	public Integer userloginupdate(UserLogin userLogin );
    
    
    
    
}

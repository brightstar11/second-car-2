package com.xh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xh.entity.UserInfo;

//dao层   主要负责与数据库
@Mapper
public interface UserInfoMapper {
	//查询
    public List<UserInfo> userinfoquery(UserInfo userinfo);
    //注册
    public Integer userregister(UserInfo userInfo);
    //判断是否唯一
    public List<UserInfo> usernameonly(String username);
    //修改
    public Integer userupdate(UserInfo userInfo);
    //密码找回
    public List<UserInfo> pwdback(UserInfo userInfo);
    public Integer userpwdupdate(UserInfo userInfo);
    
	 //判断是否存在该用户
    @Select("select * from userinfo where username=#{arg0} and userpwd=#{arg1}")
    public Integer userinfohave(String username,String userpwd);
    //修改密码
    @Update("update userinfo set userpwd=#{arg0} where username=#{arg1}")
    public Integer userinfoupup1(String userpwd,String username);
   @Update("update user_login set userpwd=#{arg0} where username=#{arg1}")
    public Integer userinfoupup2(String userpwd,String username);
   //查询用户信息，根据用户名唯一
   @Select("select * from userinfo where username=#{username}")
   public List<UserInfo> selectuserinfo(String username);
   
}

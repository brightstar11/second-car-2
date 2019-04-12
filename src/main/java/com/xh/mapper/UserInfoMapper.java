package com.xh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
}

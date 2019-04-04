package com.xh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.xh.entity.Admin;
import com.xh.entity.UserInfo;

@Mapper
public interface AdminMapper {
	@Select("select * from admin where adminName=#{adminName} and adminPwd=#{adminPwd}")
	 public List<Admin> adminquery(Admin admin);
	
	    public Integer adminregister(Admin admin);
	    @Select("select adminName from admin")
	    public List<Admin> adminnameonly();
	    public Integer adminupdate(Admin admin);
	    @Select("select * from userinfo")
	    public List<UserInfo> usermanage();
	    @Select("select * from userinfo where id=#{id}")
	    public List<UserInfo> usermanage2(String id);
}

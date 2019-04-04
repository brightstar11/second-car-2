package com.xh.web.controller;



import java.util.List;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xh.common.MD5Util;
import com.xh.entity.UserInfo;
import com.xh.entity.UserLogin;
import com.xh.service.MailService;
import com.xh.service.UserInfoService;
import com.xh.service.User_LoginService;

@Controller
@RequestMapping("WebCar/userInfo")
public class UserInfoController {
   @Autowired
private UserInfoService userInfoService;
   @Autowired
   private User_LoginService User_LoginService;

   @Autowired
   private MailService mailService;
   /**
    * 加载登录页
    */
   @RequestMapping("/login")
   public String index() {
   	 return "login";
   }
   //登录------------------------------------------------------------------------------
   @RequestMapping("/dologin")
   public String userloginquery(UserLogin userLogin,HttpSession session ) {
	   System.out.println(userLogin.getUsername()+""+userLogin.getUserpwd());
	   //把密码进行MD5加密装换
	   String userpwd=MD5Util.MD5(userLogin.getUserpwd());
	   userLogin.setUserpwd(userpwd);
	   List<UserLogin> list=User_LoginService.userloginquery(userLogin);
//使用session 存储用户登录信息
	  session.setAttribute("LoginUser", list);
         if(list.size()>0) {
        	 //把list 转换成 实体类
        	 UserLogin userLogin2= (UserLogin)list.get(0);
		  
		   System.out.println(userLogin2.getUserid());
		        return "用户界面";
		   }else {
			   System.out.println("111");
		         return "登录错误界面";
		}
		
   }
   
   //注册-------------------------------------------------------------------------------
   @RequestMapping("/register")
   public String userRegister(UserInfo userInfo) {
	   //判断用户名是否重复
	   List<UserInfo> list=userInfoService.usernameonly();
	 for(int i=0;i<list.size();i++) {
		 UserInfo userInfo2=(UserInfo)list.get(i);
		 if(userInfo2.getUsername().equals(userInfo.getUsername())) {
			 System.out.println("用户名重复");
			 //返回用户名重复页面
		 }else {
		//把密码进行MD5转换
	String userpwd=userInfo.getUserpwd();
	String userpwd2=MD5Util.MD5(userpwd);
	 userInfo.setUserpwd(userpwd2);
	 //调用sql 获取添加结果返回值
	 int count=userInfoService.userinforegister(userInfo);
	 UserLogin userLogin=new UserLogin();
	 userLogin.setUsername(userInfo.getUsername());
	 userLogin.setUserpwd(userpwd2);
	 int count2=User_LoginService.userloginregister(userLogin);
	 System.out.println(count);
	 if(count==count2) {
		 return "添加成功界面";
	 }else {
		 return "添加失败界面";
	}
			}
	 }
	return null;
	   
   }
   //修改个人信息-----------------------------------------------------------------------
   @RequestMapping("/modifyInformation")
   public String modifyInformation(UserInfo userInfo){
	   //把密码进行MD5转换
		 String userpwd=  userInfo.getUserpwd();
		 userInfo.setUserpwd(MD5Util.MD5(userpwd));
		 //sql 修改个人信息 包括  密码 昵称 头像
		 int count=userInfoService.userupdate(userInfo);
		 UserLogin userLogin=new UserLogin();
		 userLogin.setUserid(userInfo.getId());
		 userLogin.setUsername(userInfo.getUsername());
         userLogin.setUserpwd(userInfo.getUserpwd());
         int count2=User_LoginService.userloginupdate(userLogin);
		 //判断是否修改成功
		 if (count==count2) {
			return "修改成功";
		}else {
			return "修改失败";
		}
   }
   //密码找回------------------------------------------------------------------------
   
   @RequestMapping("/pwdback")
   @ResponseBody
   public String pwdback(String useremail) throws MailException{
	  System.out.println(useremail);
	  //传入一个邮箱
	 //根据邮箱找到该用户信息
	  UserInfo userInfo=new UserInfo();
	  userInfo.setUseremail(useremail);
	 		List<UserInfo> list=userInfoService.pwdback(userInfo);
	 		System.out.println(list.size());
	 		if(list.size()>0) {
	 			
	 			UserInfo userInfo2=(UserInfo)list.get(0);
	 			
	 			System.out.println(userInfo2.toString());
	 			System.out.println(userInfo2.getUserpwd());
	 			//设置收件人和消息内容
	 		mailService.sendMail(useremail,"密码找回","二手车交易系统提醒您请勿回复本邮件.点击下面的链接,重设密码<br/><a href=http://localhost:8888/pwdbacktest2.html");
	 		        return "发送成功";
	 		     //返回找回密码成功界面
		 	}
	 		//返回找回密码失败界面，邮箱未注册
	return "";
	}
   @RequestMapping("userpwdupdate")
   public String userpwdupdate(UserInfo userInfo) {
	   
	   System.out.println(userInfo.getUseremail());
	   System.out.println(userInfo.getUserpwd());
	 //把密码进行MD5转换
		 String userpwd=  userInfo.getUserpwd();
		 userInfo.setUserpwd(MD5Util.MD5(userpwd));
	   int count=userInfoService.userpwdupdate(userInfo);
	   
	   if(count==1) {
	return "密码修改成功";
	   }else {
		   return "密码找回失败";
	   }
   }
}


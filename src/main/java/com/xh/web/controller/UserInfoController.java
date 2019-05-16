package com.xh.web.controller;



import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xh.common.MD5Util;
import com.xh.entity.UserInfo;
import com.xh.entity.UserLogin;
import com.xh.service.CarService;
import com.xh.service.MailService;
import com.xh.service.UserInfoService;
import com.xh.service.User_LoginService;
import com.xh.web.model.CarModel;

import net.sf.ehcache.pool.Size;

@Controller
@RequestMapping("WebCar/userInfo")
public class UserInfoController {
	StringBuilder sb;
   @Autowired
private UserInfoService userInfoService;
   @Autowired
   private User_LoginService User_LoginService;

   @Autowired
   private MailService mailService;
   @Autowired
   private CarService car;
   /**
    * 加载登录页
    */
   @RequestMapping("/login")
   public String index() {
   	 return "login";
   }
   
   @RequestMapping("/user_index")
   public String index6(Model model) {
	   List<CarModel> list1=car.BuyCarSearch21(0,5);
       model.addAttribute("listAll1",list1);
       List<CarModel> list2=car.BuyCarSearch21(5,10);
       model.addAttribute("listAll2",list2);
       //2年
       List<CarModel> list3=car.BuyCarSearch23();
       model.addAttribute("listAll3",list3);
       //中型车
       List<CarModel> list4=car.BuyCarSearch24();
       model.addAttribute("listAll4",list4);
   	 return "user_index";
   }
   @RequestMapping("/user_newindex")
   public String index7() {
   	 return "user_newindex";
   }
   @RequestMapping("/register")
   public String index2() {
   	 return "register";
   }
   @RequestMapping("/forget_password")
   public String index3() {
	   	 return "forget_password";
	   }
	@RequestMapping("/usermanageupdatesuccess")
	public String Index4() {
		return "usermanageupdatesuccess";
	}
	@RequestMapping("/usermanageupdateerror")
	public String Index5() {
		return "usermanageupdatesuccess";
	}
   
   
   
   
   
   
   //登录------------------------------------------------------------------------------
   @RequestMapping("/dologin")
   @ResponseBody
   public Integer userloginquery(UserLogin userLogin,HttpSession session,Model model ) {
	   System.out.println(userLogin.getUsername()+""+userLogin.getUserpwd());
	   //把密码进行MD5加密装换
	   String userpwd=MD5Util.MD5(userLogin.getUserpwd());
	   userLogin.setUserpwd(userpwd);
	   List<UserLogin> list=User_LoginService.userloginquery(userLogin);
	  
//使用session 存储用户登录信息
	  
         if(list.size()>0) {
        	 //把list 转换成 实体类
        	 
        	 UserLogin userLogin2= (UserLogin)list.get(0);
        	 
        	
        	 session.setAttribute("LoginUser", userLogin2);
        	 List<CarModel> list3=car.BuyCarSearch21(0,5);
              model.addAttribute("listAll",list3);
		   System.out.println(userLogin2.getId());
		        return 1;
		   }else {
			   System.out.println("111");
		         return 0;
		}
		
   }
   
   //注册-------------------------------------------------------------------------------
   @RequestMapping("/userregister")
   public String userRegister(String username,String userpwd,Model model) {
	   //判断用户名是否重复
	   List<UserInfo> list=userInfoService.usernameonly(username);
	 if(list.size()==1) {
		     System.out.println("用户名重复");
			 String value="用户名重复";
			 model.addAttribute("value",value);
			 return "register";
			 //返回用户名重复页面
			 }
	 //用户名可以使用
	 else {
		 UserInfo userInfo = new UserInfo();
	      String userpwd2=MD5Util.MD5(userpwd);
	       userInfo.setUsername(username);
	 userInfo.setUserpwd(userpwd2);
	 //调用sql 获取添加结果返回值
	 int count=userInfoService.userregister(userInfo);
	 UserLogin userLogin=new UserLogin();
	 userLogin.setUsername(userInfo.getUsername());
	 userLogin.setUserpwd(userpwd2);
	 int count2=User_LoginService.userloginregister(userLogin);
	 System.out.println(count);
	 if(count==count2) {
		 return "login";
	 }else {
		 return "register";
	}
	 }  
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
		 userLogin.setid(userInfo.getId());
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

 @RequestMapping("/pwdback")
@ResponseBody
 public Integer pwdback(String username){
	 System.out.println("进入密码找回");
	 System.out.println(username);
	//判断用户名是否存在
	   List<UserInfo> list=userInfoService.usernameonly(username);
	   System.out.println(list.size());
	if(list.size()==1) {
		System.out.println("存在该用户");
			return 1;
		}else {
			 return 0;
		 }
	 
 }
//密码找回-邮箱找回
 @RequestMapping("/email")
 @ResponseBody
 public Integer email(String useremail) {
	 String str="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	 sb=new StringBuilder(4);
	 for(int i=0;i<4;i++)
	 {
	 //public int nextInt(int n) 该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
	 char ch=str.charAt(new Random().nextInt(str.length()));
	 sb.append(ch);
	 }
	
	 System.out.println(sb.toString());
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
	 		mailService.sendMail(useremail,"密码找回","二手车交易系统提醒您请勿回复本邮件.你的验证码为:"+sb.toString());
 		       return 1;
 		     //返回找回密码成功界面
		 	}
	 		//返回找回密码失败界面，邮箱未注册
	
	 		//返回找回密码失败界面，邮箱未注册
	return 0;
	 
 }
//密码找回-邮箱找回
@RequestMapping("/email2")
@ResponseBody
public Integer email2(StringBuilder inputEmail) {
	System.out.println(inputEmail);
	System.out.println(sb);
	String sb2=sb.toString();
	String inputEmail2=inputEmail.toString();
	if(sb2.equals(inputEmail2)) {
	     System.out.println(111);
	     return 1;
	}else {
		return 0;
	}
}
}


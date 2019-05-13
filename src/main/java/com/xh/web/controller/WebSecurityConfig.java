//package com.xh.web.controller;
//
//import java.io.IOException;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import com.xh.common.GlobalConstant;
//
///**
// * Created by yStar on 2018/2/23 16:36:16
// * 拦截器配置
// */
//@Configuration
//public class WebSecurityConfig extends WebMvcConfigurerAdapter {
// 
//    public static final String SESSION_KEY="name";
// 
//    @Bean
//    public SecurityInterceptor getSecurityInterceptor(){
//        return  new SecurityInterceptor();
//    }
//    @Override
//    public  void addInterceptors(InterceptorRegistry registry){
//        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
// 
//        //排除配置
//        addInterceptor.excludePathPatterns("/error");
//        addInterceptor.excludePathPatterns("/login/**");
//        addInterceptor.excludePathPatterns("/captcha");//排除验证码
//        //拦截配置
//        addInterceptor.addPathPatterns("/admin/**");
//    }
// 
//    private class SecurityInterceptor extends HandlerInterceptorAdapter {
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws IOException{
//            HttpSession session = request.getSession();
// 
//            //判断是否已有该用户登录的session
//            if(session.getAttribute(GlobalConstant.LOGIN_KEY) !=null){
//                return  true;
//            }
//            //跳转到登录页
//            String url = "/admin/doLogin";
//            response.sendRedirect(url);
//            return false;
//        }
//    }
// 
//}

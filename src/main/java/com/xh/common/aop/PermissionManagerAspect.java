package com.xh.common.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.xh.common.GlobalConstant;
import com.xh.common.anno.Permission;
import com.xh.entity.Admin;

@Aspect
@Component
public class PermissionManagerAspect {
	@Autowired
	private HttpSession session;
	
	@Value("${loginPath}")
	private String loginPath;

	@Pointcut("execution(public * com.zrkc.web.controller..*.*(..))")
	public void pointCut() {
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) {
		boolean needCheck=false;
		// 目标方法返回值
		Object retVal = null;
		try {
			// 拦截的实体类
			Object target = joinPoint.getTarget();
			// 目标方法的类类型
			Class<? extends Object> c = target.getClass();
			Permission p = (Permission) c.getDeclaredAnnotation(Permission.class);
			
			String methodName = joinPoint.getSignature().getName();
			@SuppressWarnings("rawtypes")
			Class[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
			// 目标方法
			Method method = target.getClass().getMethod(methodName, parameterTypes);
			Permission mp = (Permission) method.getDeclaredAnnotation(Permission.class);
			// 类没有加注解Permission
			if (p == null) {
				// 方法加了注解Permission
				if(mp!=null){
					if(mp.checkLogin()==true){
						needCheck=true;
					}
				}
			} else {
				// 类加了注解Permission
				if(p.checkLogin()==true){
					if(mp==null){
						needCheck=true;
					}else if(mp!=null && mp.checkLogin()==true){
						needCheck=true;
					}
				}
			}
			
			if(needCheck){
				// 需要验证是否登录
				Admin admin = (Admin) session.getAttribute(GlobalConstant.LOGIN_KEY);
				if (admin == null) {
					return loginPath;
				}
			}
			retVal = joinPoint.proceed();
			return retVal;
			
		} catch (Throwable e) {
			
		}
		return retVal;
	}
}
package com.xh.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@Value("${errorPage}")
	private String errorPage;
	@Value("${ajaxReqReturnErrorMsg}")
	private boolean ajaxReqReturnErrorMsg;
	@Value("${reqReturnErrorMsg}")
	private boolean reqReturnErrorMsg;
	/**
	 * 当控制器层产生Exception异常的时候, 执行该方法
	 */
	@ExceptionHandler(Exception.class)
	public @ResponseBody Object exceptionHandler(Exception ex,HttpServletRequest req,HttpServletResponse resp) {
		String header = req.getHeader("X-Requested-With");
		// 如果发生该异常的是ajax请求,则返回json

		ex.printStackTrace();
		if (null != header && header.equals("XMLHttpRequest")) {
			log.error("控制层Ajax请求异常"+ex.getMessage());
			if(ajaxReqReturnErrorMsg){
				return  ResultUtil.error(ex.getMessage());
			}else{
				return  ResultUtil.error("执行错误!");
			}
		} else {
			try {
				log.error("控制层非Ajax请求异常"+ex.getMessage());
				// 非ajax请求则转发到自定义错误页
				if(reqReturnErrorMsg){
					req.setAttribute("result", ResultUtil.error(ex.getMessage()));
					req.getRequestDispatcher(errorPage).forward(req, resp);
				}else{
					req.setAttribute("result", ResultUtil.error("执行错误"));
					req.getRequestDispatcher(errorPage).forward(req, resp);
				}
			} catch (Exception e) {
				//log.error("控制层非Ajax请求异常"+ex.getMessage());
			}
			return null;
		}
	}

}
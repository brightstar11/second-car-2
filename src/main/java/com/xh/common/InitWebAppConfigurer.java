package com.xh.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@WebListener
@Component
public class InitWebAppConfigurer implements ServletContextListener{
	@Value("${title}")
	private String title;
	@Value("${logo}")
	private String logo;
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	ServletContext sc =sce.getServletContext();
    	try {
    		sc.setAttribute("title", new String(title.getBytes("iso-8859-1"),"utf-8"));
    		sc.setAttribute("logo", logo);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}


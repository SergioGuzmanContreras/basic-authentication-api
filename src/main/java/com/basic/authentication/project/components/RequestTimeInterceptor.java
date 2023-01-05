package com.basic.authentication.project.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestTimeInterceptor implements HandlerInterceptor{

	private final static Logger log = LoggerFactory.getLogger(RequestTimeInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hadler) throws Exception{
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
		var startTime = (Long) request.getAttribute("startTime");
		log.info("<== ### Request url: {} <-> TOTAL TIME: {} msg", request.getRequestURL(), (System.currentTimeMillis() - startTime));
	}

}

package org.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AppSessionInterceptor extends HandlerInterceptorAdapter {

	final static Logger logger = Logger.getLogger(AppSessionInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (!(((HandlerMethod) handler).getMethod().getName().equalsIgnoreCase("login"))) {
			HttpSession session = request.getSession(false);
			if (session == null || session.getAttribute("hasAccess") == null) {
				logger.info("Access denied for this request : " + request.getRequestURL());
				return false;
			}
		}

		return true;
	}
}

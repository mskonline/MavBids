package org.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AppSessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (!(((HandlerMethod) handler).getMethod().getName().equalsIgnoreCase("login"))) {
			HttpSession session = request.getSession();
			if (session == null || session.getAttribute("hasAccess") == null) {
				throw new Exception("Invalid session please login");
			}
		}

		return true;
	}
}

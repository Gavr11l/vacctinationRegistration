/**
 *
 */
package ua.nure.gavr.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ua.nure.gavr.model.Medemployee;

/**
 * @author gavr
 *
 */
public class CheckLoginInterceptor  extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Medemployee medemployee = SessionHelper.getMedemployee(request.getSession());
		if(medemployee == null && !request.getRequestURI().endsWith("/login")) {
			response.sendRedirect("login");
			return false;
		}
		return super.preHandle(request, response, handler);
	}

}

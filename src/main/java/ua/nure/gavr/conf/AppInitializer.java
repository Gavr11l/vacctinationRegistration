/**
 *
 */
package ua.nure.gavr.conf;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.catalina.filters.SetCharacterEncodingFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author gavr
 *
 */
public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(DiplomApplication.class);
		ctx.setServletContext(container);

		FilterRegistration.Dynamic filterRegistration = container.addFilter(
				"recaptchaResponseFilter", new SetCharacterEncodingFilter());
		filterRegistration.setInitParameter("encoding", "UTF-8");
		filterRegistration.addMappingForUrlPatterns(null, true, "/*");


		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

	}



}
package com.jaksona.app;

import com.jaksona.app.config.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;

/**
 *  服务器启动入口
 *  @author jaksona chenluyuanit@gmail.com
 */
public class WebApplicationStartup extends AbstractAnnotationConfigDispatcherServletInitializer {


	/**
	 * Specify {@link Configuration @Configuration}
	 * and/or {@link Component @Component} classes to be
	 * provided to the {@linkplain #createRootApplicationContext() root application context}.
	 *
	 * @return the configuration classes for the root application context, or {@code null}
	 * if creation and registration of a root context is not desired
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * Specify {@link Configuration @Configuration}
	 * and/or {@link Component @Component} classes to be
	 * provided to the {@linkplain #createServletApplicationContext() dispatcher servlet
	 * application context}.
	 *
	 * @return the configuration classes for the dispatcher servlet application context or
	 * {@code null} if all configuration is specified through root config classes.
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebMvcConfig.class};
	}

	/**
	 * Specify the servlet mapping(s) for the {@code DispatcherServlet} &mdash;
	 * for example {@code "/"}, {@code "/app"}, etc.
	 *
	 * @see #registerDispatcherServlet(ServletContext)
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}

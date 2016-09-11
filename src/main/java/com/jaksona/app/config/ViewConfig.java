package com.jaksona.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * 视图解析器配置
 * @author jaksona
 */
//@Configuration
public class ViewConfig {

	/**
	 * JSP视图解析器
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setViewClass(JstlView.class);
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setOrder(0);
		return internalResourceViewResolver;
	}

	/**
	 * FreeMarker 视图解析器
	 * @return
	 */
	@Bean
	public FreeMarkerViewResolver freeMarkerViewResolver() {
		FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
		freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
		freeMarkerViewResolver.setContentType("text/html; charset=utf-8");
		freeMarkerViewResolver.setCache(true);
		freeMarkerViewResolver.setRequestContextAttribute("basePath");
		freeMarkerViewResolver.setSuffix(".ftl");
		freeMarkerViewResolver.setOrder(1);
		return freeMarkerViewResolver;
	}

	/**
	 * FreeMarker 模板配置
	 * @return
	 */
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/freemarker/");
		freeMarkerConfigurer.setDefaultEncoding("UTF-8");
		return freeMarkerConfigurer;
	}

	private List<HttpMessageConverter<?>> createMessageConverters() {
		List<HttpMessageConverter<?>> converters = new ArrayList<>();

		// 字节数组消息转换器
		converters.add(new ByteArrayHttpMessageConverter());

		// 文本消息转换器
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
		stringHttpMessageConverter.setWriteAcceptCharset(false);
		// 文本消息转换器所支持的文本类型
		ArrayList<MediaType> textTypes = new ArrayList<>();
		// 原生格式
		textTypes.add(MediaType.TEXT_PLAIN);
		// HTML格式
		textTypes.add(MediaType.TEXT_HTML);
		// 以us-ascii编码XML内容格式
		textTypes.add(MediaType.TEXT_XML);
		// 以指定字符集编码的XML内容格式
		textTypes.add(MediaType.APPLICATION_XML);

		stringHttpMessageConverter.setSupportedMediaTypes(textTypes);
		converters.add(stringHttpMessageConverter);

		// XML消息转换器
		converters.add(new SourceHttpMessageConverter<>());
		converters.add(new Jaxb2RootElementHttpMessageConverter());

		// Json消息转换器
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		converters.add(jsonConverter);
		return converters;
	}

	/**
	 * 为映射请求处理器配置消息转换器
	 * @return
	 */
	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
		requestMappingHandlerAdapter.setMessageConverters(createMessageConverters());
		return requestMappingHandlerAdapter;
	}

}

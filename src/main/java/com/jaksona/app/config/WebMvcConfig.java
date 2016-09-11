package com.jaksona.app.config;


import com.jaksona.app.oauth2.PhotoInfo;
import com.jaksona.app.oauth2.PhotoService;
import com.jaksona.app.oauth2.SparklrUserApprovalHandler;
import com.jaksona.app.oauth2.controller.AccessConfirmationController;
import com.jaksona.app.oauth2.controller.AdminController;
import com.jaksona.app.oauth2.controller.PhotoController;
import com.jaksona.app.oauth2.controller.PhotoServiceUserController;
import com.jaksona.app.oauth2.impl.PhotoServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 应用程序配置
 * @author jaksona
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * 如果项目的一些资源文件放在/WEB-INF/resources/ 下面
	 * 在浏览器访问的地址就是类似：http://host:port/projectName/WEB-INF/resources/xxx.css
	 * 但是加了如下定义之后就可以这样访问
	 * http://host:port/projectName/resources/xxx.css
	 * @param registry
	 */
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/**/*").addResourceLocations("/WEB-INF/resources/");
//	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new BufferedImageHttpMessageConverter());
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public ContentNegotiatingViewResolver contentViewResolver() throws Exception {
		ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
		contentNegotiationManager.addMediaType("json", MediaType.APPLICATION_JSON);

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");

		MappingJackson2JsonView defaultView = new MappingJackson2JsonView();
		defaultView.setExtractValueFromSingleKeyModel(true);

		ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
		contentViewResolver.setContentNegotiationManager(contentNegotiationManager.getObject());
		contentViewResolver.setViewResolvers(Arrays.<ViewResolver> asList(viewResolver));
		contentViewResolver.setDefaultViews(Arrays.<View> asList(defaultView));
		return contentViewResolver;
	}

	@Bean
	public PhotoServiceUserController photoServiceUserController(PhotoService photoService) {
		PhotoServiceUserController photoServiceUserController = new PhotoServiceUserController();
		return photoServiceUserController;
	}

	@Bean
	public PhotoController photoController(PhotoService photoService) {
		PhotoController photoController = new PhotoController();
		photoController.setPhotoService(photoService);
		return photoController;
	}

	@Bean
	public AccessConfirmationController accessConfirmationController(ClientDetailsService clientDetailsService,
																	 ApprovalStore approvalStore) {
		AccessConfirmationController accessConfirmationController = new AccessConfirmationController();
		accessConfirmationController.setClientDetailsService(clientDetailsService);
		accessConfirmationController.setApprovalStore(approvalStore);
		return accessConfirmationController;
	}

	@Bean
	public PhotoServiceImpl photoServices() {
		List<PhotoInfo> photos = new ArrayList<PhotoInfo>();
		photos.add(createPhoto("1", "marissa"));
		photos.add(createPhoto("2", "paul"));
		photos.add(createPhoto("3", "marissa"));
		photos.add(createPhoto("4", "paul"));
		photos.add(createPhoto("5", "marissa"));
		photos.add(createPhoto("6", "paul"));

		PhotoServiceImpl photoServices = new PhotoServiceImpl();
		photoServices.setPhotos(photos);
		return photoServices;
	}

	// N.B. the @Qualifier here should not be necessary (gh-298) but lots of users report needing it.
	@Bean
	public AdminController adminController(TokenStore tokenStore,
										   @Qualifier("consumerTokenServices") ConsumerTokenServices tokenServices,
										   SparklrUserApprovalHandler userApprovalHandler) {
		AdminController adminController = new AdminController();
		adminController.setTokenStore(tokenStore);
		adminController.setTokenServices(tokenServices);
		adminController.setUserApprovalHandler(userApprovalHandler);
		return adminController;
	}

	private PhotoInfo createPhoto(String id, String userId) {
		PhotoInfo photo = new PhotoInfo();
		photo.setId(id);
		photo.setName("photo" + id + ".jpg");
		photo.setUserId(userId);
		photo.setResourceURL("/org/springframework/security/oauth/examples/sparklr/impl/resources/" + photo.getName());
		return photo;
	}

//	@Bean
//	public ViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("/WEB-INF/views/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
//
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
//
//	@Bean
//	public ContentNegotiatingViewResolver contentViewResolver() throws Exception {
//		ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
//		ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
//		contentNegotiationManager.addMediaType("json", MediaType.APPLICATION_JSON);
//		contentViewResolver.setContentNegotiationManager(contentNegotiationManager.getObject());
//		contentViewResolver.setDefaultViews(Arrays.<View> asList(new MappingJackson2JsonView()));
//		return contentViewResolver;
//	}
//
//	@Bean
//	public ConversionServiceFactoryBean conversionService() {
//		ConversionServiceFactoryBean conversionService = new ConversionServiceFactoryBean();
//		conversionService.setConverters(Collections.singleton(new AccessTokenRequestConverter()));
//		return conversionService;
//	}
//
//	@Configuration
//	@EnableOAuth2Client
//	protected static class ResourceConfiguration {
//
//		@Value("${accessTokenUri}")
//		private String accessTokenUri;
//
//		@Value("${userAuthorizationUri}")
//		private String userAuthorizationUri;
//
//		@Bean
//		public OAuth2ProtectedResourceDetails sparklr() {
//			AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
//			details.setId("sparklr/tonr");
//			details.setClientId("tonr");
//			details.setClientSecret("secret");
//			details.setAccessTokenUri(accessTokenUri);
//			details.setUserAuthorizationUri(userAuthorizationUri);
//			details.setScope(Arrays.asList("read", "write"));
//			return details;
//		}
//
//		@Bean
//		public OAuth2ProtectedResourceDetails sparklrRedirect() {
//			AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
//			details.setId("sparklr/tonr-redirect");
//			details.setClientId("tonr-with-redirect");
//			details.setClientSecret("secret");
//			details.setAccessTokenUri(accessTokenUri);
//			details.setUserAuthorizationUri(userAuthorizationUri);
//			details.setScope(Arrays.asList("read", "write"));
//			details.setUseCurrentUri(false);
//			return details;
//		}
//
//		@Bean
//		public OAuth2ProtectedResourceDetails facebook() {
//			AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
//			details.setId("facebook");
//			details.setClientId("233668646673605");
//			details.setClientSecret("33b17e044ee6a4fa383f46ec6e28ea1d");
//			details.setAccessTokenUri("https://graph.facebook.com/oauth/access_token");
//			details.setUserAuthorizationUri("https://www.facebook.com/dialog/oauth");
//			details.setTokenName("oauth_token");
//			details.setAuthenticationScheme(AuthenticationScheme.query);
//			details.setClientAuthenticationScheme(AuthenticationScheme.form);
//			return details;
//		}
//
//		@Bean
//		public OAuth2ProtectedResourceDetails trusted() {
//			ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
//			details.setId("sparklr/trusted");
//			details.setClientId("my-client-with-registered-redirect");
//			details.setAccessTokenUri(accessTokenUri);
//			details.setScope(Arrays.asList("trust"));
//			return details;
//		}
//
//		@Bean
//		public OAuth2RestTemplate facebookRestTemplate(OAuth2ClientContext clientContext) {
//			OAuth2RestTemplate template = new OAuth2RestTemplate(facebook(), clientContext);
//			MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//			converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON,
//					MediaType.valueOf("text/javascript")));
//			template.setMessageConverters(Arrays.<HttpMessageConverter<?>> asList(converter));
//			return template;
//		}
//
//		@Bean
//		public OAuth2RestTemplate sparklrRestTemplate(OAuth2ClientContext clientContext) {
//			return new OAuth2RestTemplate(sparklr(), clientContext);
//		}
//
//		@Bean
//		public OAuth2RestTemplate sparklrRedirectRestTemplate(OAuth2ClientContext clientContext) {
//			return new OAuth2RestTemplate(sparklrRedirect(), clientContext);
//		}
//
//		@Bean
//		public OAuth2RestTemplate trustedClientRestTemplate() {
//			return new OAuth2RestTemplate(trusted(), new DefaultOAuth2ClientContext());
//		}
//
//	}
}

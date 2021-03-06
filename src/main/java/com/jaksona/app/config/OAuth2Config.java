package com.jaksona.app.config;

/**
 * OAuth2 配置
 * @author jaksona
 */
//@Configuration
public class OAuth2Config {

//	private static final String SERVER_RESOURCE_ID = "oauth2server";
//
//	@Configuration
//	@EnableResourceServer
//	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//		@Override
//		public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//			resources.resourceId(SERVER_RESOURCE_ID).stateless(false);
//		}
//
//		@Override
//		public void configure(HttpSecurity http) throws Exception {
//			// @formatter:off
//			http
//					// Since we want the protected resources to be accessible in the UI as well we need
//					// session creation to be allowed (it's disabled by default in 2.0.6)
//					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//					.and()
//					.requestMatchers().antMatchers("/photos/**", "/oauth/users/**", "/oauth/clients/**","/me")
//					.and()
//					.authorizeRequests()
//					.antMatchers("/me").access("#oauth2.hasScope('read')")
////					.antMatchers("/photos").access("#oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_USER'))")
//					.antMatchers("/photos/trusted/**").access("#oauth2.hasScope('trust')")
//					.antMatchers("/photos/user/**").access("#oauth2.hasScope('trust')")
////					.antMatchers("/photos/**").access("#oauth2.hasScope('read') or (!#oauth2.isOAuth() and hasRole('ROLE_USER'))")
//					.regexMatchers(HttpMethod.DELETE, "/oauth/users/([^/].*?)/tokens/.*")
//					.access("#oauth2.clientHasRole('ROLE_CLIENT') and (hasRole('ROLE_USER') or #oauth2.isClient()) and #oauth2.hasScope('write')")
//					.regexMatchers(HttpMethod.GET, "/oauth/clients/([^/].*?)/users/.*")
//					.access("#oauth2.clientHasRole('ROLE_CLIENT') and (hasRole('ROLE_USER') or #oauth2.isClient()) and #oauth2.hasScope('read')")
//					.regexMatchers(HttpMethod.GET, "/oauth/clients/.*")
//					.access("#oauth2.clientHasRole('ROLE_CLIENT') and #oauth2.isClient() and #oauth2.hasScope('read')");
//			// @formatter:on
//		}
//	}
//
//	@Configuration
//	@EnableAuthorizationServer
//	protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
//
//		@Autowired
//		private TokenStore tokenStore;
//
//		@Autowired
//		private UserApprovalHandler userApprovalHandler;
//
//		@Autowired
//		@Qualifier("authenticationManagerBean")
//		private AuthenticationManager authenticationManager;
//
//		@Value("${tonr.redirect:http://localhost:8080/tonr2/sparklr/redirect}")
//		private String tonrRedirectUri;
//
//		@Override
//		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//			security.realm("sparklr2/client");
//		}
//
//		@Override
//		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//			// @formatter:off
//			clients.inMemory().withClient("tonr")
//					.resourceIds(SERVER_RESOURCE_ID)
//					.authorizedGrantTypes("authorization_code", "implicit")
//					.authorities("ROLE_CLIENT")
//					.scopes("read", "write")
//					.secret("secret")
//					.and()
//					.withClient("tonr-with-redirect")
//					.resourceIds(SERVER_RESOURCE_ID)
//					.authorizedGrantTypes("authorization_code", "implicit")
//					.authorities("ROLE_CLIENT")
//					.scopes("read", "write")
//					.secret("secret")
//					.redirectUris(tonrRedirectUri)
//					.and()
//					.withClient("my-client-with-registered-redirect")
//					.resourceIds(SERVER_RESOURCE_ID)
//					.authorizedGrantTypes("authorization_code", "client_credentials")
//					.authorities("ROLE_CLIENT")
//					.scopes("read", "trust")
//					.redirectUris("http://anywhere?key=value")
//					.and()
//					.withClient("my-trusted-client")
//					.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//					.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//					.scopes("read", "write", "trust")
//					.accessTokenValiditySeconds(60)
//					.and()
//					.withClient("my-trusted-client-with-secret")
//					.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//					.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//					.scopes("read", "write", "trust")
//					.secret("somesecret")
//					.and()
//					.withClient("my-less-trusted-client")
//					.authorizedGrantTypes("authorization_code", "implicit")
//					.authorities("ROLE_CLIENT")
//					.scopes("read", "write", "trust")
//					.and()
//					.withClient("my-less-trusted-autoapprove-client")
//					.authorizedGrantTypes("implicit")
//					.authorities("ROLE_CLIENT")
//					.scopes("read", "write", "trust")
//					.autoApprove(true);
//			// @formatter:on
//		}
//
//		@Override
//		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//			endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
//					.authenticationManager(authenticationManager);
//		}
//
//		@Bean
//		public TokenStore tokenStore() {
//			return new InMemoryTokenStore();
//		}
//	}
//
//	protected static class Stuff {
//
//		@Autowired
//		private ClientDetailsService clientDetailsService;
//
//		@Autowired
//		private TokenStore tokenStore;
//
//		@Bean
//		private ApprovalStore approvalStore() throws Exception {
//			TokenApprovalStore store = new TokenApprovalStore();
//			store.setTokenStore(tokenStore);
//			return store;
//		}
//
//		@Bean
//		@Lazy
//		@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
//		public JakUserApprovalHandler userApprovalHandler() throws Exception {
//			JakUserApprovalHandler handler = new JakUserApprovalHandler();
//			handler.setApprovalStore(approvalStore());
//			handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
//			handler.setClientDetailsService(clientDetailsService);
//			handler.setUseApprovalStore(true);
//			return handler;
//		}
//	}
}

package com.zy.SimpleDemo.config;

import com.zy.SimpleDemo.authentication.MyUserDetailsService;
import com.zy.security.annotation.EnableAuthorizationServer;
import com.zy.security.oauth2.config.AuthorizationServerConfigurerAdapter;
import com.zy.security.oauth2.config.subject.AuthorizationServerEndpointsConfigurer;
import com.zy.security.oauth2.config.subject.ClientDetailsServiceConfigurer;
import com.zy.security.oauth2.utils.Oauth2Utils;

/**
 * @author: zy;
 * @DateTime: 2020年3月26日 下午10:03:26;
 * @Description:
 */
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.inMemory()
				.withClient("client")
				.secret("123456")
				.authorizedGrantTypes(Oauth2Utils.authorization_code , Oauth2Utils.refresh_token)
				.scopes("scope:authorizationCode")
				.resourceIds("1")
				.secret("123456")
				.redirectUris("/send")
			.and()
			.withClient("c")
				.authorizedGrantTypes("implicit" ,"refresh_token" )
				.scopes("scope:implicit")
				.resourceIds("1")
				.secret("123456")
				.redirectUris("/send")
			.and()
			.withClient("password")
				.authorizedGrantTypes("password" ,"refresh_token" )
				.scopes("scope:password")
				.resourceIds("1")
				.secret("123456")
			.and()
			.withClient("java")
				.authorizedGrantTypes("client_credentials" ,"refresh_token" )
				.scopes("scope:clientCredentials")
				.resourceIds("1")
				.secret("123456");
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.userDetailsService(new MyUserDetailsService());
	}
}

package com.zy.SimpleDemo.config;

import com.zy.security.annotation.EnableResourceServer;
import com.zy.security.oauth2.config.ResourceServerConfigurerAdapter;
import com.zy.security.oauth2.config.subject.ResourceServerSecurityConfigurer;
import com.zy.security.web.config.subject.HttpSecurity;

/**
 * @author: zy;
 * @DateTime: 2020年3月24日 下午4:26:43;
 * @Description:
 */
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/getMsg","/post/*","/order/*");
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId("1");
	}
}

package com.zy.SimpleDemo.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zy.security.core.authentication.User;
import com.zy.security.core.authentication.interfaces.UserDetails;
import com.zy.security.core.authentication.interfaces.UserDetailsService;
import com.zy.security.web.util.AuthorityUtils;

/**
 * @author: zy;
 * @DateTime: 2020年3月7日 下午9:30:26;
 * @Description: 用于密码模式下验证提供的用户名和密码是否有效
 */
public class MyUserDetailsService implements UserDetailsService {
	
	public Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		logger.info("loadUserByUsername：{}",username);
		User user = new User(username, "123456", AuthorityUtils.createAuthorityList("user:add,edit,delete,select"));
		return user;
	}

}

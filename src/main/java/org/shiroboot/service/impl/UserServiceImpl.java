package org.shiroboot.service.impl;

import org.shiroboot.domain.User;
import org.shiroboot.mapper.UserMapper;
import org.shiroboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	public User findUser(User user){
		return userMapper.findUser(user);
	}
}

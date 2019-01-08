package org.shiroboot.mapper;

import org.shiroboot.domain.User;
import org.springframework.stereotype.Repository;
@Repository
public interface UserMapper {
	public User findUser(User user);
}

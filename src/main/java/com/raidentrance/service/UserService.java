/**
 * 
 */
package com.raidentrance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raidentrance.dao.UserDao;
import com.raidentrance.dao.UserLegacyDao;
import com.raidentrance.model.api.User;

/**
 * @author raidentrance
 *
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private UserLegacyDao userLegacyDao;

	public List<User> getUsers() {
		return userDao.findAll();
	}

	public List<User> getLegacyUsers() {
		return userLegacyDao.findAll();
	}

}

/**
 * 
 */
package com.raidentrance.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.raidentrance.assembler.UserAssembler;
import com.raidentrance.dto.UserDto;
import com.raidentrance.entities.User;
import com.raidentrance.model.ErrorType;
import com.raidentrance.model.ServiceException;
import com.raidentrance.repositories.UserRepository;

import jersey.repackaged.com.google.common.collect.Lists;

/**
 * @author maagapi
 *
 */
@Service
public class UserService implements Serializable {

	@Autowired
	private UserAssembler userAssembler;

	@Autowired
	private UserRepository userRepository;

	private static final long serialVersionUID = 8500967638946229530L;

	public List<UserDto> findAll() {
		List<User> users = Lists.newArrayList(userRepository.findAll());
		return userAssembler.toResources(users);
	}

	public UserDto findOne(Integer idUser) throws ServiceException {
		User requested = userRepository.findOne(idUser);
		if (requested != null) {
			return userAssembler.toResource(requested);
		} else {
			throw new ServiceException(HttpStatus.NOT_FOUND.value(),
					String.format(ErrorType.NOT_FOUND.getMessage(), "User"), ErrorType.NOT_FOUND.getCode());
		}
	}
}

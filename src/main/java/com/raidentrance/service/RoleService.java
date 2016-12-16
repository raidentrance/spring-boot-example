/**
 * 
 */
package com.raidentrance.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.raidentrance.assembler.RoleAssembler;
import com.raidentrance.dto.RoleDto;
import com.raidentrance.entities.Role;
import com.raidentrance.model.ErrorType;
import com.raidentrance.model.ServiceException;
import com.raidentrance.repositories.RoleRepository;

import jersey.repackaged.com.google.common.collect.Lists;

/**
 * @author maagapi
 *
 */
@Component
public class RoleService implements Serializable {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private RoleAssembler assembler;

	private static final long serialVersionUID = -3846695035829612520L;

	public List<RoleDto> findAll() {
		List<Role> role = Lists.newArrayList(roleRepository.findAll());
		return assembler.toResources(role);
	}

	public RoleDto findById(Integer id) throws ServiceException {
		Role requested = roleRepository.findOne(id);
		if (requested != null) {
			return assembler.toResource(requested);
		} else {
			throw new ServiceException(HttpStatus.NOT_FOUND.value(),
					String.format(ErrorType.NOT_FOUND.getMessage(), "Role"), ErrorType.NOT_FOUND.getCode());
		}
	}

}

/**
 * 
 */
package com.raidentrance.assembler;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raidentrance.dto.RoleDto;
import com.raidentrance.dto.UserDto;
import com.raidentrance.entities.User;
import com.raidentrance.mapper.UserMapper;
import com.raidentrance.resource.UserResource;

/**
 * @author raidentrance
 *
 */
@Component
public class UserAssembler extends JaxRsResourceAssemblerSupport<User, UserDto> {
	@Autowired
	private RoleAssembler assembler;

	private UserMapper mapper = Mappers.getMapper(UserMapper.class);

	public UserAssembler() {
		super(UserResource.class, UserDto.class);
	}

	@Override
	public UserDto toResource(User entity) {
		UserDto resource = createResourceWithId(entity.getIdUser(), entity);
		UserDto result = mapper.userEntityToUser(entity);
		RoleDto role = assembler.toResource(entity.getRole());
		result.add(resource.getLinks());
		result.setRole(role);
		return result;
	}
}

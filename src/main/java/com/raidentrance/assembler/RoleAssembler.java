/**
 * 
 */
package com.raidentrance.assembler;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.raidentrance.dto.RoleDto;
import com.raidentrance.entities.Role;
import com.raidentrance.mapper.UserMapper;
import com.raidentrance.resource.RoleResource;

/**
 * @author raidentrance
 *
 */
@Component
public class RoleAssembler extends JaxRsResourceAssemblerSupport<Role, RoleDto> {

	private UserMapper mapper = Mappers.getMapper(UserMapper.class);

	public RoleAssembler() {
		super(RoleResource.class, RoleDto.class);
	}

	@Override
	public RoleDto toResource(Role entity) {
		RoleDto role = createResourceWithId(entity.getIdRole(), entity);
		RoleDto result = mapper.roleEntityToRole(entity);
		result.add(role.getLinks());
		return result;
	}
}

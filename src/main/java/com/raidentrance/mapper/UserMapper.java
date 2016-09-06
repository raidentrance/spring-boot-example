/**
 * 
 */
package com.raidentrance.mapper;

import org.mapstruct.Mapper;

import com.raidentrance.dto.RoleDto;
import com.raidentrance.dto.UserDto;
import com.raidentrance.entities.Role;
import com.raidentrance.entities.User;

/**
 * @author raidentrance
 *
 */

@Mapper
public interface UserMapper {
	UserDto userEntityToUser(User entity);

	User userToUserEntity(UserDto dto);

	RoleDto roleEntityToRole(Role entity);

	Role roleToRoleEntity(RoleDto role);
}

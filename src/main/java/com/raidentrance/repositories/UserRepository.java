/**
 * 
 */
package com.raidentrance.repositories;

import org.springframework.data.repository.CrudRepository;

import com.raidentrance.entities.User;

/**
 * @author raidentrance
 *
 */
public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUsername(String username);
}

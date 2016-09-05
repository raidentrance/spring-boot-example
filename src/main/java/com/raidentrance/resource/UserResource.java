/**
 * 
 */
package com.raidentrance.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raidentrance.entities.User;
import com.raidentrance.repositories.UserRepository;

import jersey.repackaged.com.google.common.collect.Lists;

/**
 * @author raidentrance
 *
 */

@Component
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@GET
	public Response getUsers() {
		ArrayList<User> users = Lists.newArrayList(userRepository.findAll());
		return Response.ok(users).build();
	}

}

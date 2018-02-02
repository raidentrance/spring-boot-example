/**
 * 
 */
package com.raidentrance.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raidentrance.service.UserService;

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
	private UserService userService;

	private static final Logger log = LoggerFactory.getLogger(UserResource.class);

	@GET
	public Response getUsers() {
		log.info("Getting user");
		return Response.ok(userService.getUsers()).build();
	}

	@GET
	@Path("/legacy")
	public Response getLegacyUsers() {
		log.info("Getting user");
		return Response.ok(userService.getLegacyUsers()).build();
	}

}

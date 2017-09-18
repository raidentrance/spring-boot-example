/**
 * 
 */
package com.raidentrance.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raidentrance.dao.UserDao;
import com.raidentrance.model.ServiceException;

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
	private UserDao userDao;

	private static final Logger log = LoggerFactory.getLogger(UserResource.class);

	@GET
	public Response getUsers() {
		log.info("Getting users");
		return Response.ok(userDao.findAll()).build();
	}

	@GET
	@Path("/user/{username}")
	public Response getUser(@PathParam("username")String username) throws ServiceException {
		log.info("Getting users");
		return Response.ok(userDao.findByUsername(username)).build();
	}

}

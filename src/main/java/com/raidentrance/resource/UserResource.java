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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raidentrance.model.ServiceException;
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

	@GET
	public Response getUsers() {
		return Response.ok(userService.findAll()).build();
	}

	@GET
	@Path("/{idUser}")
	public Response getById(@PathParam("idUser") Integer idUser) throws ServiceException {
		return Response.ok(userService.findOne(idUser)).build();
	}

}

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

import org.springframework.stereotype.Component;

import com.codahale.metrics.annotation.Timed;

/**
 * @author raidentrance
 *
 */

@Component
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	@GET
	@Timed(name="get.all.users")
	public Response getUsers() {
		return Response.ok("It works !").build();
	}

	@GET
	@Path("/{userId}")
	@Timed(name="get.single.user",absolute=false)
	public Response getUserById(@PathParam("userId") String id) {
		return Response.ok("It works !").build();
	}

}

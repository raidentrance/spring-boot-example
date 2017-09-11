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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

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

	private static final Logger log = LoggerFactory.getLogger(UserResource.class);

	@GET
	public String getUsers() {
		log.info("Getting user");
		return String.format("{\"username\":\"raidentrance\"}");
	}

	@GET
	@Path("/error")
	public Response sampleError() throws ServiceException {
		throw new ServiceException(HttpStatus.NOT_FOUND.value(), "Sample Error Message", 1);
	}

	@GET
	@Path("/error/generic")
	public Response sampleGenericError() {
		throw new NullPointerException();
	}

}

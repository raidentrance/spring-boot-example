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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author maagapi
 *
 */
@Component
@Path("/configs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectConfigurationResource {

	@Value("${com.raidentrance.app.name}")
	private String appName;

	private static final Logger log = LoggerFactory.getLogger(UserResource.class);

	@GET
	@Path("/appName")
	public Response getAppName() {
		log.info("Getting project configuration");
		return Response.ok(appName).build();
	}
}

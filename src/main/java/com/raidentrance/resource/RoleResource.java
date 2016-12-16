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
import com.raidentrance.service.RoleService;

/**
 * @author maagapi
 *
 */
@Component
@Path("/roles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoleResource {

	@Autowired
	private RoleService roleService;

	@GET
	public Response getRoles() {
		return Response.ok(roleService.findAll()).build();
	}

	@GET
	@Path("/{idRole}")
	public Response getById(@PathParam("idRole") Integer idRole) throws ServiceException {
		return Response.ok(roleService.findById(idRole)).build();
	}
}

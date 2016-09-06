/**
 * 
 */
package com.raidentrance.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raidentrance.assembler.RoleAssembler;
import com.raidentrance.entities.Role;
import com.raidentrance.repositories.RoleRepository;

import jersey.repackaged.com.google.common.collect.Lists;

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
	private RoleRepository roleRepository;
	@Autowired
	private RoleAssembler assembler;

	@GET
	public Response getRoles() {
		List<Role> role = Lists.newArrayList(roleRepository.findAll());
		return Response.ok(assembler.toResources(role)).build();
	}

	@GET
	@Path("/{idRole}")
	public Response getById(@PathParam("idRole") Integer idRole) {
		Role requested = roleRepository.findOne(idRole);
		return Response.ok(assembler.toResource(requested)).build();
	}
}

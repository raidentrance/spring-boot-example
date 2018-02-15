/**
 * 
 */
package com.raidentrance.resource;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

/**
 * @author maagapi
 *
 */

@Component
@Path("/ping")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PingResource {

	private Meter meter;

	@Autowired
	private MetricRegistry metricRegistry;
	
	@PostConstruct
	public void init() {
		meter = metricRegistry.meter("custom.raidentrance.metric");
	}

	@GET
	public Response ping() {
		meter.mark();
		return Response.ok("Pong !").build();
	}
}

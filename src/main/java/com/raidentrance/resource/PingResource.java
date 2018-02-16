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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

/**
 * @author raidentrance
 *
 */

@Component
@Path("/ping")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PingResource {

	private Counter meter;

	@Autowired
	private MetricRegistry metricRegistry;

	public static final Logger log = LoggerFactory.getLogger(PingResource.class);

	@PostConstruct
	public void init() {
		meter = metricRegistry.counter("associates.created");
	}

	@GET
	public Response ping() {
		log.info("Ping executed");
		meter.inc();
		return Response.ok("Pong !").build();
	}
}

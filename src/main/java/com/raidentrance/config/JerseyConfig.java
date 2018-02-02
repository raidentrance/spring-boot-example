/**
 * 
 */
package com.raidentrance.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.raidentrance.resource.PingResource;
import com.raidentrance.resource.UserResource;

/**
 * @author raidentrance
 *
 */
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(UserResource.class);
		register(PingResource.class);
	}
}

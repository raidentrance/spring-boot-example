/**
 * 
 */
package com.raidentrance.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.raidentrance.resource.RoleResource;
import com.raidentrance.resource.UserResource;

/**
 * @author raidentrance
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		 register(UserResource.class);
		 register(RoleResource.class);
	}
}

/**
 * 
 */
package com.raidentrance.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.raidentrance.error.GenericExceptionMapper;
import com.raidentrance.error.RestExceptionMapper;
import com.raidentrance.resource.UserResource;

/**
 * @author raidentrance
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(UserResource.class);
		register(RestExceptionMapper.class);
		register(GenericExceptionMapper.class);
	}
}

/**
 * 
 */
package com.raidentrance;

import org.jolokia.http.AgentServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author raidentrance
 *
 */
@SpringBootApplication
public class SprinBootSampleApplication {

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new AgentServlet(), "/jolokia/*");
	}

	public static void main(String[] args) {
		SpringApplication.run(SprinBootSampleApplication.class, args);
	}

}

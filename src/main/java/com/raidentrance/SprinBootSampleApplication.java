/**
 * 
 */
package com.raidentrance;

import org.jolokia.http.AgentServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.jmx.JmxMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;

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

	@Bean
	@ExportMetricWriter
	public MetricWriter metricWriter(MBeanExporter exporter) {
		return new JmxMetricWriter(exporter);
	}

	public static void main(String[] args) {
		SpringApplication.run(SprinBootSampleApplication.class, args);
	}

}

/**
 * 
 */
package com.raidentrance;

import java.util.concurrent.TimeUnit;

import org.jolokia.http.AgentServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.jmx.JmxMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;

/**
 * @author raidentrance
 *
 */
@SpringBootApplication
public class SprinBootSampleApplication {
	@Autowired
	private MetricRegistry metricRegistry;

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new AgentServlet(), "/jolokia/*");
	}

	@Bean
	public JmxReporter getMetricsReporter(MBeanExporter exporter) {
		final JmxReporter reporter = JmxReporter.forRegistry(metricRegistry).build();
		reporter.start();
		return reporter;
	}
	
	@Bean
	public ConsoleReporter getConsoleReporter() {
		ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry).convertRatesTo(TimeUnit.SECONDS)
				.convertDurationsTo(TimeUnit.MILLISECONDS).build();
		reporter.start(5, TimeUnit.SECONDS);
		return reporter;
	}

	public static void main(String[] args) {
		SpringApplication.run(SprinBootSampleApplication.class, args);
	}

}

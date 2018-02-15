package com.raidentrance.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

/**
 * @author raidentrance
 *
 */
@Configuration
@EnableMetrics
public class DropwizardMetricsConfig extends MetricsConfigurerAdapter {
	@Autowired
	private MetricRegistry metricRegistry;

	@Override
	public void configureReporters(MetricRegistry metricRegistry) {
		registerReporter(ConsoleReporter.forRegistry(metricRegistry).build()).start(5, TimeUnit.MINUTES);
	}

	@Bean
	public JmxReporter getMetricsReporter(MBeanExporter exporter) {
		final JmxReporter reporter = JmxReporter.forRegistry(metricRegistry).build();
		reporter.start();
		return reporter;
	}

}

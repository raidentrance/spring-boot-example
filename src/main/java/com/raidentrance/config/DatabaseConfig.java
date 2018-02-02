/**
 * 
 */
package com.raidentrance.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author raidentrance
 *
 */
@Configuration
public class DatabaseConfig {
	@Bean(name = "dsSlave")
	@ConfigurationProperties(prefix = "legacy.datasource")
	public DataSource slaveDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "dsMaster")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource masterDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "jdbcSlave")
	@Autowired
	public JdbcTemplate slaveJdbcTemplate(@Qualifier("dsSlave") DataSource dsSlave) {
		return new JdbcTemplate(dsSlave);
	}

	@Bean(name = "jdbcMaster")
	@Autowired
	public JdbcTemplate masterJdbcTemplate(@Qualifier("dsMaster") DataSource dsMaster) {
		return new JdbcTemplate(dsMaster);
	}
}

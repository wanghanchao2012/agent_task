package com.emarbox.agent.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {
	@Bean(name = "dspDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.dsp")
	public DataSource dspDataSource(DataSourceProperties properties) {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "authDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.auth")
	public DataSource authDataSource(DataSourceProperties properties) {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	@Qualifier("dspJdbcTemplate")
	public JdbcTemplate dspJdbcTemplate(@Qualifier("dspDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	@Primary
	@Qualifier("authJdbcTemplate")
	public JdbcTemplate authJdbcTemplate(@Qualifier("authDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
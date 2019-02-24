package com.emarbox.agent.dbsync.factory;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JdbcTemplateFactory {

	private static JdbcTemplate dspJdbcTemplate;
	private static JdbcTemplate authJdbcTemplate;
	@Autowired
	@Qualifier("dspJdbcTemplate")
	JdbcTemplate _dspJdbcTemplate;
	@Autowired
	@Qualifier("authJdbcTemplate")
	JdbcTemplate _authJdbcTemplate;

	@PostConstruct
	public void init() {
		dspJdbcTemplate = _dspJdbcTemplate;
		authJdbcTemplate = _authJdbcTemplate;
	}

	public static JdbcTemplate auth() {
		return authJdbcTemplate;
	}

	public static JdbcTemplate dsp() {
		return dspJdbcTemplate;
	}

}

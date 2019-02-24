package com.emarbox.agent.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.emarbox.agent.dbsync.service.TableFlowService;

@Component
public class SystemStartRunner implements CommandLineRunner {
	@Autowired
	TableFlowService tableFlowService;

	public void run(String... args) {
		tableFlowService.initTable();
	}

}
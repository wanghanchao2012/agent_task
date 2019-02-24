package com.emarbox.agent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emarbox.agent.dbsync.service.TableFlowService;

@Controller
public class TestController {

	@Autowired

	TableFlowService tableFlowService;

	@RequestMapping("test")
	@ResponseBody
	public String test() {
		tableFlowService.dataStreamStarting();
		return "ok";
	}
}

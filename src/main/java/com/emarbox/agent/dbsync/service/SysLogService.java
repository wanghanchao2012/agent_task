package com.emarbox.agent.dbsync.service;

import org.springframework.stereotype.Service;

import com.emarbox.agent.dbsync.entity.SysLogBO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SysLogService {

	public boolean save(SysLogBO sysLogBO) {
		log.info(sysLogBO.toString());
		return true;
	}
}

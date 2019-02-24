package com.emarbox.agent.dbsync.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emarbox.agent.dbsync.enums.DataFlowEnum;

@Service
public class AppendDataProcessService implements IDataProcess {

	@Transactional
	@Override
	public boolean process(DataFlowEnum record) {
		return false;
	}

}

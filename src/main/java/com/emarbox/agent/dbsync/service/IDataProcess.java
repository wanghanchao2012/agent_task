package com.emarbox.agent.dbsync.service;

import com.emarbox.agent.dbsync.enums.DataFlowEnum;

public interface IDataProcess {

	public boolean process(DataFlowEnum record);
	
}

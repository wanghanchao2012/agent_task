package com.emarbox.agent.dbsync.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emarbox.agent.dbsync.enums.DataFlowEnum;
import com.emarbox.agent.dbsync.enums.DataProcessModelEnum;
import com.emarbox.agent.dbsync.service.ReplaceDataProcessService;

@Service
public class ProcessFactory {
	
	@Autowired
	ReplaceDataProcessService replaceDataProcessService;
	
	public boolean execute(DataFlowEnum record){
		boolean process = false;
		try {
			if(record.getProcessModel().equals(DataProcessModelEnum.REPLACE)){
				process = replaceDataProcessService.process(record);
			} else if(record.getProcessModel().equals(DataProcessModelEnum.APPEND)){
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return process;
	}
}

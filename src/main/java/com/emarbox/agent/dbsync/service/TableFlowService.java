package com.emarbox.agent.dbsync.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.emarbox.agent.dbsync.entity.TableFlowEntity;
import com.emarbox.agent.dbsync.enums.DataFlowEnum;
import com.emarbox.agent.dbsync.factory.ProcessFactory;

@Service
public class TableFlowService {
	Logger log = LoggerFactory.getLogger(ReplaceDataProcessService.class);

	@Autowired
	ProcessFactory processFactory;

	public void dataStreamStarting() {
		for (DataFlowEnum record : DataFlowEnum.values()) {
			processFactory.execute(record);
		}
	}

	public void initTable() {
		log.info("init table..");
		for (DataFlowEnum record : DataFlowEnum.values()) {
			JdbcTemplate toJdbcTemplate = record.getToJdbcTemplate();
			JdbcTemplate fromJdbcTemplate = record.getFromJdbcTemplate();
			List<TableFlowEntity> flowInfo = record.getFlowInfo();
			for (TableFlowEntity e : flowInfo) {
				Map<String, Object> queryForMap = fromJdbcTemplate.queryForMap("show create table " + e.getFromTable());
				Object tablesql = queryForMap.get("Create Table");
				StringBuffer sql = new StringBuffer();
				sql.append("drop table if exists " + e.getToTable()).append(";");
				sql.append(tablesql.toString()).append(";");
				toJdbcTemplate.update(sql.toString());
			}
			
			processFactory.execute(record);
		}
	}
}

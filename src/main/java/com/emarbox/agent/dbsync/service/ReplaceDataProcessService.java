package com.emarbox.agent.dbsync.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.emarbox.agent.annotations.SysLog;
import com.emarbox.agent.dbsync.entity.TableFlowEntity;
import com.emarbox.agent.dbsync.enums.DataFlowEnum;

@Service
public class ReplaceDataProcessService implements IDataProcess {
	Logger log = LoggerFactory.getLogger(ReplaceDataProcessService.class);

	@SysLog("data flow replace service process starting ")
	@Override
	public boolean process(DataFlowEnum record) {
		JdbcTemplate fromJdbcTemplate = record.getFromJdbcTemplate();
		JdbcTemplate toJdbcTemplate = record.getToJdbcTemplate();
		List<TableFlowEntity> flowInfo = record.getFlowInfo();
		for (TableFlowEntity e : flowInfo) {
			List<Map<String, Object>> sourceList = fromJdbcTemplate.queryForList("select * from " + e.getFromTable());
			StringBuffer insert = new StringBuffer("REPLACE INTO " + e.getToTable());
			insert.append(" values ");
			int i = 0;
			for (Map<String, Object> map : sourceList) {
				if (i != 0) {
					insert.append(",");
				}
				insert.append("(");
				int j = 0;
				for (Entry<String, Object> srecord : map.entrySet()) {
					if (j != 0) {
						insert.append(",");
					}
					if (srecord.getValue() == null) {
						insert.append("NULL");
					} else {
						insert.append("'" + srecord.getValue() + "'");
					}
					j++;
				}
				insert.append(")");
				i++;
			}
			log.info(insert.toString());
			toJdbcTemplate.execute(insert.toString());
		}
		return false;
	}

}

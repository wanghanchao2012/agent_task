package com.emarbox.agent.dbsync.factory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.emarbox.agent.dbsync.entity.TableFlowEntity;

import lombok.Data;

@Data
public class TableFlowConfig {
	private String fromTable;
	private String toTable;

	public static List<TableFlowEntity> getDspToAuth() {
		return Stream.<TableFlowEntity> builder()
				.add(new TableFlowEntity("project_set", "project_set")).build().collect(Collectors.toList());
	}

	public static List<TableFlowEntity> getAuthToDsp() {
		return Stream.<TableFlowEntity> builder()
				.add(new TableFlowEntity("tb_agent_user_project", "tb_agent_user_project")).build().collect(Collectors.toList());
	}

}

package com.emarbox.agent.dbsync.enums;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.emarbox.agent.dbsync.entity.TableFlowEntity;
import com.emarbox.agent.dbsync.factory.JdbcTemplateFactory;
import com.emarbox.agent.dbsync.factory.TableFlowConfig;

public enum DataFlowEnum {

	dspToAuth(JdbcTemplateFactory.dsp(), JdbcTemplateFactory.auth(), TableFlowConfig.getDspToAuth(),DataProcessModelEnum.REPLACE),
	authToDsp(JdbcTemplateFactory.auth(), JdbcTemplateFactory.dsp(), TableFlowConfig.getAuthToDsp(),DataProcessModelEnum.REPLACE);

	private JdbcTemplate fromJdbcTemplate;
	private JdbcTemplate toJdbcTemplate;
	private List<TableFlowEntity> flowInfo;
	private DataProcessModelEnum processModel;

	DataFlowEnum(JdbcTemplate fromDataSource, JdbcTemplate toDateSource, List<TableFlowEntity> flowInfo,DataProcessModelEnum processModel) {
		this.fromJdbcTemplate = fromDataSource;
		this.toJdbcTemplate = toDateSource;
		this.flowInfo = flowInfo;
		this.processModel = processModel;
	}

	public JdbcTemplate getFromJdbcTemplate() {
		return fromJdbcTemplate;
	}

	public void setFromJdbcTemplate(JdbcTemplate fromJdbcTemplate) {
		this.fromJdbcTemplate = fromJdbcTemplate;
	}

	public JdbcTemplate getToJdbcTemplate() {
		return toJdbcTemplate;
	}

	public void setToJdbcTemplate(JdbcTemplate toJdbcTemplate) {
		this.toJdbcTemplate = toJdbcTemplate;
	}

	public List<TableFlowEntity> getFlowInfo() {
		return flowInfo;
	}

	public void setFlowInfo(List<TableFlowEntity> flowInfo) {
		this.flowInfo = flowInfo;
	}

	public DataProcessModelEnum getProcessModel() {
		return processModel;
	}

	public void setProcessModel(DataProcessModelEnum processModel) {
		this.processModel = processModel;
	}
	

}

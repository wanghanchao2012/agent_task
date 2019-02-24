package com.emarbox.agent.dbsync.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableFlowEntity {
	public String fromTable;
	public String toTable;
}

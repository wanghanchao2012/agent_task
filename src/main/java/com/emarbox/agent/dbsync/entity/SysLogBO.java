package com.emarbox.agent.dbsync.entity;

import lombok.Data;

@Data
public class SysLogBO {

	private String className;

	private String methodName;

	private String params;

	private Long exeuTime;

	private String remark;

	private String createDate;

	@Override
	public String toString() {
		return "SysLogBO [className=" + className + ", methodName=" + methodName + ", params=" + params + ", exeuTime="
				+ exeuTime + ", remark=" + remark + ", createDate=" + createDate + "]";
	}

}
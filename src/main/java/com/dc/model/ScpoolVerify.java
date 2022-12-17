package com.dc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.util.UUID;

public class ScpoolVerify implements Serializable {

	@Id
	private String id;
	@Indexed
	private String CODE;
	private String NAME;
	private String createTime;


	public ScpoolVerify(String NAME, String CODE, String createTime){
		id=UUID.randomUUID().toString();
		this.setNAME(NAME);
		this.setCODE(CODE);
		this.setCreateTime(createTime);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}



}

package com.alexbt.solr;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Model {
	
	@Id
	@Field("id")
	private long id;
	
	@Field("value_s")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setId(long currentTimeMillis) {
		id = currentTimeMillis;
	}

	public long getId() {
		return id;
	}
	
	

}

package com.alexbt.solr;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;


@SolrDocument
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

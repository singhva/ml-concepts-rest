package com.ibm.watson.rest;

import java.util.Arrays;
import java.util.List;

import org.apache.lucene.document.Document;

public class LuceneResponse {
	Document document;
	String nciCode;
	String parentCode;
	List<String> names;
	String type;
	float score;
	
	public LuceneResponse() {
		
	}
	
	public LuceneResponse(Document document, float score) {
		this.nciCode = document.get("code");
		this.parentCode = document.get("parentCode");
		this.names = Arrays.asList(document.getValues("name"));
		this.type = document.get("type");
		this.score = score;
	}
	
	public String getNciCode() {
		return nciCode;
	}
	public void setNciCode(String nciCode) {
		this.nciCode = nciCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

}
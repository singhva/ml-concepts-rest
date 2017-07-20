package com.ibm.watson.rest;

import java.util.Arrays;
import java.util.List;

import org.apache.lucene.document.Document;

public class LuceneResponse {
	Document document;
	String nciCode;
	String ncimCui;
	String parentCode;
	String parentNcimCui;
	List<String> names;
	String type;
	float score;
	
	public LuceneResponse() {
		
	}
	
	public LuceneResponse(Document document, float score) {
		this.nciCode = document.get("code");
		this.ncimCui = document.get("cui");
		this.parentCode = document.get("parentCode");
		this.parentNcimCui = document.get("parentCui");
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

	public String getNcimCui() {
		return ncimCui;
	}

	public void setNcimCui(String ncimCui) {
		this.ncimCui = ncimCui;
	}

	public String getParentNcimCui() {
		return parentNcimCui;
	}

	public void setParentNcimCui(String parentNcimCui) {
		this.parentNcimCui = parentNcimCui;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

}
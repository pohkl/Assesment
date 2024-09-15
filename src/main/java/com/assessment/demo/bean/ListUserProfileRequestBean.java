package com.assessment.demo.bean;

import java.io.Serializable;

public class ListUserProfileRequestBean implements Serializable {
	
	private static final long serialVersionUID = 5254384826452940393L;
	
	private int page;
	
	private int pageSize;
	
	private String sortBy;
	
	private String sortDir;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortDir() {
		return sortDir;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}
	
}
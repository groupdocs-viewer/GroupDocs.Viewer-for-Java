package com.viewer.model;

public class LoadFileBrowserTreeDataParameters extends DocumentParameters {
	public int pageIndex;
	public int pageSize;
	public String orderBy;
	public Boolean orderAsc;
	public String filter;
	public String fileTypes;
	public Boolean extended;
	public String instanceIdToken;
	public String callBack;

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderAsc(Boolean orderAsc) {
		this.orderAsc = orderAsc;
	}

	public Boolean getOrderAsc() {
		return orderAsc;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getFilter() {
		return filter;
	}

	public void setFileTypes(String fileTypes) {
		this.fileTypes = fileTypes;
	}

	public String getFileTypes() {
		return fileTypes;
	}

	public void setExtended(Boolean extended) {
		this.extended = extended;
	}

	public Boolean getExtended() {
		return extended;
	}

	public void setInstanceIdToken(String instanceIdToken) {
		this.instanceIdToken = instanceIdToken;
	}

	public String getInstanceIdToken() {
		return instanceIdToken;
	}

	public void setCallback(String callBack) {
		this.callBack = callBack;
	}

	public String getCallback() {
		return callBack;
	}
}

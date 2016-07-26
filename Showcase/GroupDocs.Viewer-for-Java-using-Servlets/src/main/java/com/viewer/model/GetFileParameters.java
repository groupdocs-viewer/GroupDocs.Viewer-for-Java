package com.viewer.model;

public class GetFileParameters extends WatermarkedDocumentParameters {
	public Boolean getPdf;
	public Boolean isPrintable;
	public String displayName;
	public Boolean ignoreDocumentAbsence;
	public Boolean useHtmlBasedEngine;
	public Boolean supportPageRotation;
	public String instanceIdToken;

	public void setGetPdf(Boolean getPdf) {
		this.getPdf = getPdf;
	}

	public Boolean getGetPdf() {
		return getPdf;
	}

	public Boolean getIgnoreDocumentAbsence() {
		return ignoreDocumentAbsence;
	}

	public void setIgnoreDocumentAbsence(Boolean ignoreDocumentAbsence) {
		this.ignoreDocumentAbsence = ignoreDocumentAbsence;
	}

	public Boolean getUseHtmlBasedEngine() {
		return useHtmlBasedEngine;
	}

	public void setUseHtmlBasedEngine(Boolean useHtmlBasedEngine) {
		this.useHtmlBasedEngine = useHtmlBasedEngine;
	}

	public Boolean getSupportPageRotation() {
		return supportPageRotation;
	}

	public void setSupportPageRotation(Boolean supportPageRotation) {
		this.supportPageRotation = supportPageRotation;
	}

	public void setIsPrintable(Boolean isPrintable) {
		this.isPrintable = isPrintable;
	}

	public Boolean getIsPrintable() {
		return isPrintable;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setInstanceIdToken(String instanceIdToken) {
		this.instanceIdToken = instanceIdToken;
	}

	public String getInstanceIdToken() {
		return instanceIdToken;
	}

}
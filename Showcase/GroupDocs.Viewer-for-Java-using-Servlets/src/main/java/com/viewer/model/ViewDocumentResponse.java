package com.viewer.model;

public class ViewDocumentResponse extends OperationStatusResponse
{
	private String path;
	private String docType;
    private String fileType;
    private String url;
    private String pdfDownloadUrl;
    private String name;
    public String[] imageUrls;
    private boolean lic;
    private String pdfPrintUrl;
    private String[] pageHtml;
    private String[] pageCss;
    private String documentDescription;
    private String urlForResourcesInHtml;
    private String sharedCss;
    
    public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPdfDownloadUrl() {
		return pdfDownloadUrl;
	}
	public void setPdfDownloadUrl(String pdfDownloadUrl) {
		this.pdfDownloadUrl = pdfDownloadUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(String[] imageUrls) {
		this.imageUrls = imageUrls;
	}
	public boolean isLic() {
		return lic;
	}
	public void setLic(boolean lic) {
		this.lic = lic;
	}
	public String getPdfPrintUrl() {
		return pdfPrintUrl;
	}
	public void setPdfPrintUrl(String pdfPrintUrl) {
		this.pdfPrintUrl = pdfPrintUrl;
	}
	public String[] getPageHtml() {
		return pageHtml;
	}
	public void setPageHtml(String[] pageHtml) {
		this.pageHtml = pageHtml;
	}
	public String[] getPageCss() {
		return pageCss;
	}
	public void setPageCss(String[] pageCss) {
		this.pageCss = pageCss;
	}
	public String getDocumentDescription() {
		return documentDescription;
	}
	public void setDocumentDescription(String documentDescription) {
		this.documentDescription = documentDescription;
	}
	public String getUrlForResourcesInHtml() {
		return urlForResourcesInHtml;
	}
	public void setUrlForResourcesInHtml(String urlForResourcesInHtml) {
		this.urlForResourcesInHtml = urlForResourcesInHtml;
	}
	public String getSharedCss() {
		return sharedCss;
	}
	public void setSharedCss(String sharedCss) {
		this.sharedCss = sharedCss;
	}
	
}

 class OperationStatusResponse
{
    public OperationStatusResponse()
    {
        success = true;
    }

    private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
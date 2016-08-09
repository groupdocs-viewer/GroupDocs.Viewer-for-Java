package com.viewer.model;
public class GetResourceForHtmlParameters
 {
		private String documentPath;
		public final String getDocumentPath()
		{
			return documentPath;
		}
		public final void setDocumentPath(String value)
		{
			documentPath = value;
		}
		private String resourceName;
		public final String getResourceName()
		{
			return resourceName;
		}
		public final void setResourceName(String value)
		{
			resourceName = value;
		}
		private int pageNumber;
		public final int getPageNumber()
		{
			return pageNumber;
		}
		public final void setPageNumber(int value)
		{
			pageNumber = value;
		}
 }
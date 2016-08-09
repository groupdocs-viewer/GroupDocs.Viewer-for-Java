package com.viewer.model;
public class GetDocumentPageImageParameters extends WatermarkedDocumentParameters
{
		private int PageIndex;
		public final int getPageIndex()
		{
			return PageIndex;
		}
		public final void setPageIndex(int value)
		{
			this.PageIndex = value;
		}
		private Integer Width = null;
		public final Integer getWidth()
		{
			return Width;
		}
		public final void setWidth(Integer value)
		{
			Width = value;
		}
		private Integer Quality = null;
		public final Integer getQuality()
		{
			return Quality;
		}
		public final void setQuality(Integer value)
		{
			Quality = value;
		}
		private boolean UsePdf;
		public final boolean getUsePdf()
		{
			return UsePdf;
		}
		public final void setUsePdf(boolean value)
		{
			UsePdf = value;
		}
		private boolean IgnoreDocumentAbsence;
		public final boolean getIgnoreDocumentAbsence()
		{
			return IgnoreDocumentAbsence;
		}
		public final void setIgnoreDocumentAbsence(boolean value)
		{
			IgnoreDocumentAbsence = value;
		}
		private boolean UseHtmlBasedEngine;
		public final boolean getUseHtmlBasedEngine()
		{
			return UseHtmlBasedEngine;
		}
		public final void setUseHtmlBasedEngine(boolean value)
		{
			UseHtmlBasedEngine = value;
		}
		private boolean Rotate;
		public final boolean getRotate()
		{
			return Rotate;
		}
		public final void setRotate(boolean value)
		{
			Rotate = value;
		}
		private String InstanceIdToken;
		public final String getInstanceIdToken()
		{
			return InstanceIdToken;
		}
		public final void setInstanceIdToken(String value)
		{
			InstanceIdToken = value;
		}
		private String Locale;
		public final String getLocale()
		{
			return Locale;
		}
		public final void setLocale(String value)
		{
			Locale = value;
		}
}

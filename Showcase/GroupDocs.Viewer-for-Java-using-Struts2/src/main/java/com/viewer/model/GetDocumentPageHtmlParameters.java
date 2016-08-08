package com.viewer.model; 
public class GetDocumentPageHtmlParameters
{
		private String Path;
		public final String getPath()
		{
			return Path;
		}
		public final void setPath(String value)
		{
			Path = value;
		}

		private int PageIndex;
		public final int getPageIndex()
		{
			return PageIndex;
		}
		public final void setPageIndex(int value)
		{
			PageIndex = value;
		}

		private boolean UsePngImages;
		public final boolean getUsePngImages()
		{
			return UsePngImages;
		}
		public final void setUsePngImages(boolean value)
		{
			UsePngImages = value;
		}

		private boolean EmbedImagesIntoHtmlForWordFiles;
		public final boolean getEmbedImagesIntoHtmlForWordFiles()
		{
			return EmbedImagesIntoHtmlForWordFiles;
		}
		public final void setEmbedImagesIntoHtmlForWordFiles(boolean value)
		{
			EmbedImagesIntoHtmlForWordFiles = value;
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

		private boolean SaveFontsInAllFormats;
		public final boolean getSaveFontsInAllFormats()
		{
			return SaveFontsInAllFormats;
		}
		public final void setSaveFontsInAllFormats(boolean value)
		{
			SaveFontsInAllFormats = value;
		}
}

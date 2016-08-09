package com.viewer.model;

public class ViewDocumentParameters extends WatermarkedDocumentParameters
{
	private boolean UseHtmlBasedEngine;
	private boolean UsePngImagesForHtmlBasedEngine;
    private int Count;
    private int Width ;
    private int Quality ;
    private boolean UsePdf;
    private Integer PreloadPagesCount;
    private boolean ConvertWordDocumentsCompletely ;
    private String FileDisplayName;
    private boolean IgnoreDocumentAbsence;
    private boolean SupportPageRotation;
    private boolean SupportListOfContentControls;
    private boolean SupportListOfBookmarks ;
    private boolean EmbedImagesIntoHtmlForWordFiles ;
    private String InstanceIdToken ;
    private String Locale ;
    private String PasswordForOpening;
    private String password;
    private boolean SaveFontsInAllFormats;
    private String Callback;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getUseHtmlBasedEngine() {
		return UseHtmlBasedEngine;
	}
	public void setUseHtmlBasedEngine(boolean useHtmlBasedEngine) {
		UseHtmlBasedEngine = useHtmlBasedEngine;
	}
	public boolean getUsePngImagesForHtmlBasedEngine() {
		return UsePngImagesForHtmlBasedEngine;
	}
	public void setUsePngImagesForHtmlBasedEngine(
			boolean usePngImagesForHtmlBasedEngine) {
		UsePngImagesForHtmlBasedEngine = usePngImagesForHtmlBasedEngine;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public int getWidth() {
		return Width;
	}
	public void setWidth(int width) {
		Width = width;
	}
	public int getQuality() {
		return Quality;
	}
	public void setQuality(int quality) {
		Quality = quality;
	}
	public boolean getUsePdf() {
		return UsePdf;
	}
	public void setUsePdf(boolean usePdf) {
		UsePdf = usePdf;
	}
	public Integer getPreloadPagesCount() {
		return PreloadPagesCount;
	}
	public void setPreloadPagesCount(Integer preloadPagesCount) {
		PreloadPagesCount = preloadPagesCount;
	}
	public boolean getConvertWordDocumentsCompletely() {
		return ConvertWordDocumentsCompletely;
	}
	public void setConvertWordDocumentsCompletely(
			boolean convertWordDocumentsCompletely) {
		ConvertWordDocumentsCompletely = convertWordDocumentsCompletely;
	}
	public String getFileDisplayName() {
		return FileDisplayName;
	}
	public void setFileDisplayName(String fileDisplayName) {
		FileDisplayName = fileDisplayName;
	}
	public boolean getIgnoreDocumentAbsence() {
		return IgnoreDocumentAbsence;
	}
	public void setIgnoreDocumentAbsence(boolean ignoreDocumentAbsence) {
		IgnoreDocumentAbsence = ignoreDocumentAbsence;
	}
	public boolean getSupportPageRotation() {
		return SupportPageRotation;
	}
	public void setSupportPageRotation(boolean supportPageRotation) {
		SupportPageRotation = supportPageRotation;
	}
	public boolean getSupportListOfContentControls() {
		return SupportListOfContentControls;
	}
	public void setSupportListOfContentControls(boolean supportListOfContentControls) {
		SupportListOfContentControls = supportListOfContentControls;
	}
	public boolean getSupportListOfBookmarks() {
		return SupportListOfBookmarks;
	}
	public void setSupportListOfBookmarks(boolean supportListOfBookmarks) {
		SupportListOfBookmarks = supportListOfBookmarks;
	}
	public boolean getEmbedImagesIntoHtmlForWordFiles() {
		return EmbedImagesIntoHtmlForWordFiles;
	}
	public void setEmbedImagesIntoHtmlForWordFiles(
			boolean embedImagesIntoHtmlForWordFiles) {
		EmbedImagesIntoHtmlForWordFiles = embedImagesIntoHtmlForWordFiles;
	}
	public String getInstanceIdToken() {
		return InstanceIdToken;
	}
	public void setInstanceIdToken(String instanceIdToken) {
		InstanceIdToken = instanceIdToken;
	}
	public String getLocale() {
		return Locale;
	}
	public void setLocale(String locale) {
		Locale = locale;
	}
	public String getPasswordForOpening() {
		return PasswordForOpening;
	}
	public void setPasswordForOpening(String passwordForOpening) {
		PasswordForOpening = passwordForOpening;
	}
	public boolean getSaveFontsInAllFormats() {
		return SaveFontsInAllFormats;
	}
	public void setSaveFontsInAllFormats(boolean saveFontsInAllFormats) {
		SaveFontsInAllFormats = saveFontsInAllFormats;
	}
	public String getCallback() {
		return Callback;
	}
	public void setCallback(String callback) {
		Callback = callback;
	}
	
}

 abstract class WatermarkedDocumentParameters extends DocumentParameters
{
    private String WatermarkText;
    private int WatermarkColor; 
    private float WatermarkWidth;
    private WatermarkPosition WatermarkPosition = null;
    
    
    public WatermarkPosition getWatermarkPostion(){
    	return WatermarkPosition;
    }
    public void setWatermarkPosition(WatermarkPosition WatermarkPosition){
    	this.WatermarkPosition = WatermarkPosition;
    }
    
    public String getWatermarkText() {
		return WatermarkText;
	}

	public void setWatermarkText(String watermarkText) {
		WatermarkText = watermarkText;
	}

	public int getWatermarkColor() {
		return WatermarkColor;
	}

	public void setWatermarkColor(int watermarkColor) {
		WatermarkColor = watermarkColor;
	}

	public float getWatermarkWidth() {
		return WatermarkWidth;
	}

	public void setWatermarkWidth(float watermarkWidth) {
		WatermarkWidth = watermarkWidth;
	}

	
}

 abstract class DocumentParameters
{
	 private String Path;

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}
}
 

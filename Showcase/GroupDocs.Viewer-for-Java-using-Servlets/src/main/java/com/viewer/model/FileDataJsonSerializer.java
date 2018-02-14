package com.viewer.model;

import java.text.NumberFormat;
import java.text.ParseException;

import com.groupdocs.viewer.converter.options.FileDataOptions;
import com.groupdocs.viewer.domain.FileData;
import com.groupdocs.viewer.domain.PageData;
import com.groupdocs.viewer.domain.RowData;
import com.viewer.model.helper.*;

public class FileDataJsonSerializer
{
	   /** 
		 The _file data
	   */
		private FileData _fileData;
		/** 
		 The _options
		*/
		private FileDataOptions _options;

		/** 
		 The _default culture
		*/
		//private final CultureInfo _defaultCulture = CultureInfo.InvariantCulture;

		/** 
		 Initializes a new instance of the <see cref="FileDataJsonSerializer"/> class.
		 
		 @param fileData The file data.
		 @param options The options.
		*/
		public FileDataJsonSerializer(FileData fileData, FileDataOptions options)
		{
			_fileData = fileData;
			_options = options;
		}
		 public final String Serialize(boolean isDefault) throws ParseException
		 {
					return SerializeDefault();
		 }
		 private String SerializeDefault() throws ParseException
		 {
		 			StringBuilder json = new StringBuilder();

		 			json.append(String.format("{\"maxPageHeight\":%1$s,\"widthForMaxHeight\":%2$s", _fileData.getMaxHeight(), _fileData.getMaxHeight()));
		 			json.append(",\"pages\":[");

		 			int pageCount = _fileData.getPages().size();
		 			for (int i = 0; i < pageCount; i++)
		 			{
		 				PageData pageData = _fileData.getPages().get(i);

		 				boolean needSeparator = i > 0;
		 				if (needSeparator)
		 				{
		 					json.append(",");
		 				}

		 				AppendPage(pageData, json);

		 				boolean includeRows = _options.getUsePdf() && pageData.getRows().size() > 0;
		 				if (includeRows)
		 				{
		 					json.append(",\"rows\":[");
		 					for (int j = 0; j < pageData.getRows().size(); j++)
		 					{
		 						boolean appendRowSeaparator = j != 0;
		 						if (appendRowSeaparator)
		 						{
		 							json.append(",");
		 						}

		 						AppendRow(pageData.getRows().get(j), json);
		 					}
		 					json.append("]"); // rows
		 				}
		 				json.append("}"); // page
		 			}
		 			json.append("]"); // pages
		 			json.append("}"); // document

		 			return json.toString();
		 }

		 private void AppendPage(PageData pageData, StringBuilder json) throws ParseException
		 {
		 			json.append(String.format("{\"w\":%1$s,\"h\":%2$s,\"number\":%3$s", NumberFormat.getNumberInstance().parse(""+pageData.getWidth()), NumberFormat.getNumberInstance().parse(""+pageData.getHeight()), NumberFormat.getNumberInstance().parse(""+(pageData.getNumber() - 1))));
		 }
		 private String JsonEncode(String text)
		 {
					if (DotNetToJavaStringHelper.isNullOrEmpty(text))
					{
						return "";
					}

					int i;
					int length = text.length();
					StringBuilder stringBuilder = new StringBuilder(length + 4);
					for (i = 0; i < length; i += 1)
					{
						char c = text.charAt(i);
						switch (c)
						{
							case '\\':
							case '"':
							case '/':
								stringBuilder.append('\\');
								stringBuilder.append(c);
								break;
							case '\b':
								stringBuilder.append("\\b");
								break;
							case '\t':
								stringBuilder.append("\\t");
								break;
							case '\n':
								stringBuilder.append("\\n");
								break;
							case '\f':
								stringBuilder.append("\\f");
								break;
							case '\r':
								stringBuilder.append("\\r");
								break;
							default:
								if (c < ' ')
								{
		
									String t = "000" + String.format("%X",(byte)c );
									stringBuilder.append("\\u" + t.substring(t.length() - 4));
								}
								else
								{
									stringBuilder.append(c);
								}
								break;
						}
					}
					return stringBuilder.toString();
		 }
		 private void AppendRow(RowData rowData, StringBuilder json) throws ParseException
		 {
					String[] textCoordinates = new String[rowData.getTextCoordinates().size()];
					for (int i = 0; i < rowData.getTextCoordinates().size(); i++)
					{
						textCoordinates[i] = NumberFormat.getNumberInstance().parse(""+rowData.getTextCoordinates().get(i)).toString();
					}

					String[] characterCoordinates = new String[rowData.getCharacterCoordinates().size()];
					for (int i = 0; i < rowData.getCharacterCoordinates().size(); i++)
					{
						characterCoordinates[i] = NumberFormat.getNumberInstance().parse(""+rowData.getCharacterCoordinates().get(i)).toString();
					}

					json.append(String.format("{\"l\":%1$s,\"t\":%2$s,\"w\":%3$s,\"h\":%4$s,\"c\":[%5$s],\"s\":\"%6$s\",\"ch\":[%7$s]}", NumberFormat.getNumberInstance().parse(""+rowData.getLineLeft()), NumberFormat.getNumberInstance().parse(""+rowData.getLineTop()), NumberFormat.getNumberInstance().parse(""+rowData.getLineWidth()), NumberFormat.getNumberInstance().parse(""+rowData.getLineHeight()), DotNetToJavaStringHelper.join(",", textCoordinates), JsonEncode(rowData.getText()), DotNetToJavaStringHelper.join(",", characterCoordinates)));
		 }
		 
}

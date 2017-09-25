<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset ="utf-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>GroupDocs.Viewer for Java</title>
<c:url value="Scripts/jquery-1.9.1.min.js" var="jquery" />
<c:url value="Scripts/jquery-ui-1.10.3.min.js" var="jquery2" />
<c:url value="Scripts/knockout-3.2.0.js" var="knockout" />
<c:url value="Scripts/turn.min.js" var="turn" />
<c:url value="Scripts/modernizr.2.6.2.Transform2d.min.js" var="transform2d" />
<c:url value="Scripts/installableViewer.js" var="installableViewer" />
<c:url value="Scripts/GroupdocsViewer.all.js" var="GroupDocsViewer" />
<c:url value="Content/CSS/bootstrap.css" var="bootstrapCss" />
<c:url value="Content/CSS/groupdocsViewer.all.css" var="GroupDocsViewerCss" />
<c:url value="Content/CSS/dialog.css" var="dialogCss" />

<script src="${jquery}"></script>
<script src="${jquery2}"></script>
<script src="${knockout}"></script>

<script src="${turn}"></script>
<script src="${transform2d}"></script>
<script src="${installableViewer}"></script>

<script type='text/javascript'>
	$.ui.groupdocsViewer.prototype.applicationPath = 'http://localhost:8080';
</script>
<script type='text/javascript'>
	$.ui.groupdocsViewer.prototype.useHttpHandlers = false;
</script>
<script src="${GroupDocsViewer}"></script>

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${GroupDocsViewerCss}" rel="stylesheet" />
<link href="${dialogCss}" rel="stylesheet" />
<style>
	html, body, #docViewer {height: 100%; width: 100%; margin: 0; padding: 0}
</style>
</head>
<body>

<div id="docViewer"></div>
	<script>
		$(function() {
			var viewerSyle = {
				ScrollView : 1,
				DoublePageFlip : 2,
				OnePageInRow : 3,
				TwoPagesInRow : 4,
				CoverThenTwoPagesInRow : 5
			};

			$('#docViewer').groupdocsViewer({
				filePath : 'candy.pdf',
				zoomToFitWidth : true,
				zoomToFitHeight : true,
				showFolderBrowser : true,
				showHeader : true,
				showZoom : true,
				showPaging : true,
				showThumbnails : true,
//				width : 650,
//				height : 900,
				useHtmlBasedEngine : false,
				showDownload : true,
				downloadPdfFile : true,
				showPrint : true,
				usePdfPrinting : true,
				enableStandardErrorHandling : false,
				preloadPagesCount : 1,
				showFolderBrowser : true,
				viewerStyle : viewerSyle.ScrollView,
			
			//Layout type
			});

			//EnableRightClickMenu = false;
			// $('#viewerHtmlDiv')[0].oncontextmenu = function () { return false; };
		});
	</script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>

    <meta charset ="utf-8">
    <meta name = "viewport" content="width=device-width, initial-scale=1.0">
    <title>GroupDocs.Viewer for Java</title>

    <%-- jQuery --%>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>

    <%-- jQuery UI--%>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.js" integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha256-rByPlHULObEjJ6XQxW/flG2r+22R5dKiAoef+aXWfik=" crossorigin="anonymous" />

    <%-- Knockout --%>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.4.0/knockout-min.js" integrity="sha256-ly8TiTtwVsBWdjekTqTJlLGz3Rsg4YXr80eK6QhtdMs=" crossorigin="anonymous"></script>

    <%-- Turn.js --%>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/turn.js/3/turn.min.js" integrity="sha256-VjaAExWWIpIWfnyKgdCYYZbmWGHeNkSzkZyoXxHcdHY=" crossorigin="anonymous"></script>

    <%-- Modernizr --%>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" integrity="sha256-0rguYS0qgS6L4qVzANq4kjxPLtvnp5nn2nB5G1lWRv4=" crossorigin="anonymous"></script>

    <%-- Twitter Bootstrap --%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha256-916EbMg70RQy9LHiGkXzG8hSg9EdNy97GazNG/aiY1w=" crossorigin="anonymous" />
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha256-ZT4HPpdCOt2lvDkXokHuhJfdOKSPFLzeAJik5U/Q+l4=" crossorigin="anonymous" />
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha256-U5ZEeKfGNOja007MMD3YBI0A3OSZOQbeG6z2f2Y0hu8=" crossorigin="anonymous"></script>

    <%-- Local --%>
    <script src="Scripts/installableViewer.js"></script>
    <script>
        $.ui.groupdocsViewer.prototype.applicationPath = 'http://localhost:8080';
        $.ui.groupdocsViewer.prototype.useHttpHandlers = false;
    </script>
    <script src="Scripts/GroupdocsViewer.all.js"></script>
    <link href="Content/CSS/bootstrap.css" rel="stylesheet" />
    <link href="Content/CSS/groupdocsViewer.all.css" rel="stylesheet" />
    <link href="Content/CSS/dialog.css" rel="stylesheet" />

</head>
<body>
	<center>
		<h2>GroupDocs.Viewer for Java (using Servlet API)</h2>
		<div id="docViewer" style="width: 800px; height: 900px"></div>
	</center>
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
//				zoomToFitHeight : true,
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

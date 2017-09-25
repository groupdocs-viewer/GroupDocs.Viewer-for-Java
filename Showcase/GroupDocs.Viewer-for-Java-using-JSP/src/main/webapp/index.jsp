<%@ page import="com.groupdocs.ui.Document" pageEncoding="utf-8" %>
<%
    int pageNumber = 1;
    String filename = "Docx4j_GettingStarted.pdf";
    if (request.getParameterMap().containsKey("page")) {
        pageNumber = Integer.valueOf(request.getParameter("page"));
    }
    if (request.getParameterMap().containsKey("filename")) {
        filename = request.getParameter("filename");
    }

    Document doc = new Document();
    doc.setFilename(filename);
    doc.setPageNumber(pageNumber);
%>
<!DOCTYPE html>
<html>
<head>
    <title>GroupDocs.Viewer for Java</title>
    <style>
        article.content {
            margin-bottom: 70px;
        }
        .navbar .navbar-nav {
            display: inline-block;
            float: none;
        }
        .navbar .navbar-collapse {
            text-align: center;
        }
    </style>
</head>
<body>

<article class="content">
    <%= doc.getHtmlContent() %>
</article>

<nav class="navbar navbar-inverse navbar-fixed-bottom">
    <div id="navbar" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="index.jsp?page=1">First</a></li>
            <li><a href="index.jsp?page=<%= pageNumber - 1 %>">Previous</a></li>
            <li><a href="index.jsp?page=<%= pageNumber + 1 %>">Next</a></li>
            <li><a href="index.jsp?page=<%= doc.getPageCount() %>">Last</a></li>
        </ul>
    </div>
</nav>

<script src="//code.jquery.com/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>

package com.groupdocs.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.domain.FileDescription;
import com.groupdocs.viewer.handler.ViewerHtmlHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet("/files")
public class FilesListServlet
        extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        ViewerHtmlHandler handler = Utils.createViewerHtmlHandler();

        List<FileDescription> tree = null;
        try {
            tree = handler.loadFileTree().getFileTree();
        } catch (Exception x) {
            throw new RuntimeException(x);
        }

        List<String> result = tree
                .parallelStream()
                .filter(fd -> !fd.isDirectory()
                        && !"README.txt".equalsIgnoreCase(fd.getName())
                        && !Optional.ofNullable(fd.getName()).get().isEmpty()
                        && !Optional.ofNullable(fd.getDocumentType()).get().isEmpty()
                )
                .map(fd -> fd.getName())
                .collect(Collectors.toList());

        new ObjectMapper().writeValue(response.getOutputStream(), result);

    }
}

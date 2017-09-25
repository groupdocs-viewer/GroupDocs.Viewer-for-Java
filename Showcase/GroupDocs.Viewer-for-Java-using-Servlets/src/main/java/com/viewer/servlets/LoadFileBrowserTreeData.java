package com.viewer.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.domain.FileDescription;
import com.groupdocs.viewer.domain.containers.FileTreeContainer;
import com.groupdocs.viewer.domain.options.FileTreeOptions;
import com.viewer.ViewerUtils;
import com.viewer.model.FileBrowserTreeDataResponse;
import com.viewer.model.LoadFileBrowserTreeDataParameters;
import com.viewer.model.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/LoadFileBrowserTreeData")
public class LoadFileBrowserTreeData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.addHeader("Content-Type", "application/json");
        LoadFileBrowserTreeDataParameters parameters = new ObjectMapper().readValue(request.getInputStream(), LoadFileBrowserTreeDataParameters.class);

        String path = ViewerUtils.STORAGE_PATH;
        try {

            if (parameters.getPath() != null && !parameters.getPath().isEmpty())
                path = path + parameters.getPath();

            FileTreeOptions options = new FileTreeOptions(path);
            FileTreeContainer tree = ViewerUtils.getViewerImageHandler().loadFileTree(options);

            FileBrowserTreeDataResponse result = new FileBrowserTreeDataResponse();
            result.setNodes(Utils.ToFileTreeNodes(parameters.getPath(), tree.getFileTree()));
            List<FileDescription> mytree = tree.getFileTree();
            result.setCount(mytree.size());
            new ObjectMapper().writeValue(response.getOutputStream(), result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        FileBrowserTreeDataResponse result = new FileBrowserTreeDataResponse();
        new ObjectMapper().writeValue(response.getOutputStream(), result);
    }
}

package com.viewer.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.groupdocs.viewer.domain.FileDescription;
import com.groupdocs.viewer.domain.containers.FileTreeContainer;
import com.groupdocs.viewer.domain.options.FileTreeOptions;
import com.viewer.ViewerUtils;
import com.viewer.model.FileBrowserTreeDataResponse;
import com.viewer.model.LoadFileBrowserTreeDataParameters;
import com.viewer.model.Utils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class LoadFileBrowserTreeData {

    private InputStream result;

    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();
        LoadFileBrowserTreeDataParameters parameters = new ObjectMapper().readValue(request.getInputStream(), LoadFileBrowserTreeDataParameters.class);
        String path = ViewerUtils.STORAGE_PATH.toString();

        if (parameters.getPath() != null && !parameters.getPath().isEmpty())
            path = path + parameters.getPath();

        FileTreeOptions options = new FileTreeOptions(path);
        FileTreeContainer tree = ViewerUtils.getViewerImageHandler().loadFileTree(options);

        FileBrowserTreeDataResponse fileBrowserTreeDataResponse = new FileBrowserTreeDataResponse();
        fileBrowserTreeDataResponse.setNodes(Utils.ToFileTreeNodes(parameters.getPath(), tree.getFileTree()));
        List<FileDescription> mytree = tree.getFileTree();
        fileBrowserTreeDataResponse.setCount(mytree.size());

        this.result = new ByteArrayInputStream(new ObjectMapper().writeValueAsString(fileBrowserTreeDataResponse).getBytes());
        return "success";
    }

    public InputStream getResult() {
        return this.result;
    }
}

package com.groupdocs.ui.viewer.demosapitests;

import java.util.Objects;

public class LoadFileTreeResponse {
    private String guid;
    private String name;
    private Boolean isDirectory;
    private Long size = 0L;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDirectory() {
        return isDirectory;
    }

    public void setDirectory(Boolean directory) {
        isDirectory = directory;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoadFileTreeResponse that = (LoadFileTreeResponse) o;
        return Objects.equals(guid, that.guid) && Objects.equals(name, that.name) && Objects.equals(isDirectory, that.isDirectory) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, name, isDirectory, size);
    }

    @Override
    public String toString() {
        return "FileDescriptionEntity{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", isDirectory=" + isDirectory +
                ", size=" + size +
                '}';
    }
}

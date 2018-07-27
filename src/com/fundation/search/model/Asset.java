package com.fundation.search.model;

public class Asset {
    private String path;
    private String fileName;
    private String extent;
    private boolean hidden;
    private long size;

    public Asset() {
        this.path = this.path;
        this.hidden = this.hidden;
        this.fileName = this.fileName;
        this.size = this.size;
        this.extent = this.extent;
    }

    public Asset(String path, String fileName, String extent, boolean hidden, long size, String owner) {
        this.path = path;
        this.fileName = fileName;
        this.extent = extent;
        this.hidden = hidden;
        this.size = size;
        this.owner = owner;
    }


    public boolean isHidden() {
        return hidden;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    private String owner;
    //owner,date


    /**
     * Get the value of Path.
     *
     * @return string.
     */
    public String getPath() {
        return path;
    }

    /**
     * Modify the parameters.
     *
     * @param path string.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the value of Hidden.
     *
     * @return string.
     */
    public boolean getHidden() {
        return hidden;
    }

    /**
     * Modify the parameters.
     *
     * @param hidden string.
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * Get the value of fileName.
     *
     * @return string.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Modify the parameters.
     *
     * @param fileName string.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Get the value of size.
     *
     * @return long.
     */
    public long getSize() {
        return size;
    }

    /**
     * Modify the parameters.
     *
     * @param size long.
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * Get the value of extends.
     *
     * @return string.
     */
    public String getExtent() {
        return extent;
    }

    /**
     * Modify the parameters.
     *
     * @param extent string.
     */
    public void setExtent(String extent) {
        this.extent = extent;
    }
}


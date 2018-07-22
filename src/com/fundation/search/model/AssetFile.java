/*
 * @(#)AssertFile.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.fundation.search.model;

/**
 * Class AssertFile.
 */
public class AssetFile {
    private String path;
    private String hidden;
    private String fileName;
    private long size;
    private String extent;

    /**
     * Constructor of the class.
     *
     */
    public AssetFile() {
        this.path = path;
        this.hidden = hidden;
        this.fileName = fileName;
        this.size = size;
        this.extent = extent;
    }

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
    public String getHidden() {
        return hidden;
    }

    /**
     * Modify the parameters.
     *
     * @param hidden string.
     */
    public void setHidden(String hidden) {
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

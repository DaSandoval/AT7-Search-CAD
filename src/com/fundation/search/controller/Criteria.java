/*
 * @(#)Class .java
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
package com.fundation.search.controller;

/**
 * This class Search.
 *
 * @author Ana Mamani - AT-[07].
 * @version 1.0.
 */
import java.util.Date;

public class Criteria {
    private String path;
    private String fileName;
    private boolean hidden;
    private boolean folder;
    private String extension;
    private String owner;
    private long size;
    private boolean readOnly;
    private boolean keySensitive;

    /**
     * Method for get the value
     * @return String
     */
    public String getPath() {
        return path;
    }
    /**
     * Method for set the value
     *
     */
    public void setPath(String path) {
        this.path = path;
    }
    /**
     * Method for get the value
     * @return String
     */
    public String getFileName() {
        return fileName;
    }
    /**
     * Method for set the value
     *
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /**
     * Method for get the value
     * @return boolean
     */
    public boolean getHidden() {
        return hidden;
    }
    /**
     * Method for set the value
     *
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    /**
     * Method for get the value
     * @return boolean
     */
    public boolean getFolder() {
        return folder;
    }
    /**
     * Method for set the value
     *
     */
    public void setFolder(boolean folder) {
        this.folder = folder;
    }
    /**
     * Method for get the value
     * @return String
     */
    public String getExtension() {
        return extension;
    }
    /**
     * Method for set the value
     *
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }
    /**
     * Method for get the value
     * @return String
     */
    public String getOwner() {
        return owner;
    }
    /**
     * Method for set the value
     *
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    /**
     * Method for get the value
     * @return long
     */
    public long getSize() {
        return size;
    }
    /**
     * Method for set the value
     *
     */
    public void setSize(long size) {
        this.size = size;
    }
    /**
     * Method for get the value
     * @return boolean
     */
    public boolean getReadOnly() {
        return readOnly;
    }
    /**
     * Method for set the value
     *
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }
    /**
     * Method for get the value
     * @return boolean
     */
    public boolean getKeySensitive() {
        return keySensitive;
    }
    /**
     * Method for set the value
     *
     */
    public void setKeySensitive(boolean keySensitive) {
        this.keySensitive = keySensitive;
    }
}
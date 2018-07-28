/*
 *
 *   @(#)Class.java
 *
 *   Copyright (c) 2018 Jala Foundation.
 *   2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *   All rights reserved.
 *
 *   This software is the confidential and proprietary information of
 *   Jala Foundation, ("Confidential Information").  You shall not
 *   disclose such Confidential Information and shall use it only in
 *   accordance with the terms of the license agreement you entered into
 *   with Jala Foundation.
 *
 */

package com.fundation.search.controller;

import java.io.File;

public class Criteria {

    private File folderNew;
    private String path;
    private String fileName;
    private boolean hidden;
    private boolean folder;
    private String extension;
    private String owner;
    private long size;
    private boolean readOnly;
    private boolean keySensitive;
    private boolean isExtensionEnable;

    public boolean isExtensionEnable() {
        return isExtensionEnable;
    }

    public void setExtensionEnable(boolean extensionEnable) {
        isExtensionEnable = extensionEnable;
    }

    public Criteria(){
        clean();

    }

    public File getFolderNew() {


        return folderNew;
    }

    public void setFolderNew(File folderNew) {
        this.folderNew = folderNew;
    }

    public void clean (){
        this.folderNew = null;
        this.path = "";
        this.fileName ="";
        this.hidden = false;
        this.folder = false;
        this.extension = "";
        this.owner = "";
        this.size = 0;
        this.readOnly = false;
        this.keySensitive = false;
        this.isExtensionEnable = false;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isFolder() {
        return folder;
    }

    public void setFolder(boolean folder) {
        this.folder = folder;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isKeySensitive() {
        return keySensitive;
    }

    public void setKeySensitive(boolean keySensitive) {
        this.keySensitive = keySensitive;
    }

}

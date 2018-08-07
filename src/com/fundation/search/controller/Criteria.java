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
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * This class Search.
 *
 * @author Ana Mamani - AT-[07].
 * @version 1.0.
 */
public class Criteria {

    /**
     * folderNew of criteria.
     */
    private File folderNew;
    /**
     * path of criteria.
     */
    private String path;
    /**
     * file name of criteria.
     */
    private String fileName;
    /**
     * hidden of criteria.
     */
    private boolean hidden;
    /**
     * folder of criteria.
     */
    private boolean folder;
    /**
     * extension of criteria.
     */
    private String extension;
    /**
     * owner of criteria.
     */
    private String owner;
    /**
     * check owner of criteria.
     */
    private boolean checkOwner;
    /**
     * size of criteria.
     */
    private double size;
    /**
     * check size of criteria.
     */
    private boolean checkSize;
    /**
     * sing size of criteria.
     */
    private String signSize;
    /**
     * type size of criteria.
     */
    private String TypeSize;
    /**
     * read only of criteria.
     */
    private boolean readOnly;
    /**
     * key sensitive of criteria.
     */
    private boolean keySensitive;
    /**
     * extension enable of criteria.
     */
    private boolean isExtensionEnable;
    /**
     * ini creation file of criteria.
     */
    private Timestamp iniCreationFile;
    /**
     * fin creation file of criteria.
     */
    private Timestamp finCreationFile;
    /**
     * ini modify file of criteria.
     */
    private Timestamp iniModFile;
    /**
     * fin modify file  of criteria.
     */
    private Timestamp finModFile;
    /**
     * ini access file of criteria.
     */
    private Timestamp iniAccessFile;
    /**
     * fin access file of criteria.
     */
    private Timestamp finAccessFile;
    /**
     * content of criteria.
     */
    private String content;
    /**
     * check content of criteria.
     */
    private boolean checkContent;

    private boolean checkMulti;

    private String frameRate;

    private String videoCode;

    private String resolution;

    private ArrayList<String> formatsMulti;

    private String scale;

    private String operator;

    private double cantMulti;
    /**
     * Method for clean
     */
    public void clean() {
        this.folderNew = null;
        this.path = "";
        this.fileName = "";
        this.hidden = false;
        this.folder = false;
        this.extension = "";
        this.owner = "";
        this.size = 0;
        this.readOnly = false;
        this.keySensitive = false;
        this.isExtensionEnable = false;
        this.size = 0;
        this.checkSize = false;
        this.signSize = "";
        this.TypeSize = "";
        this.iniAccessFile = new Timestamp(System.currentTimeMillis());
        this.iniCreationFile = new Timestamp(System.currentTimeMillis());
        this.iniModFile = new Timestamp(System.currentTimeMillis());
        this.finAccessFile = new Timestamp(System.currentTimeMillis());
        this.finCreationFile = new Timestamp(System.currentTimeMillis());
        this.finModFile = new Timestamp(System.currentTimeMillis());
        this.content = "";
        this.checkContent = false;
        this.checkMulti = false;
        this.formatsMulti = new ArrayList<>();
        this.frameRate = "";
        this.resolution = "";
        this.videoCode = "";
        this.scale = "";
        this.operator = "";
        this.cantMulti = 0.0;

    }

    public void addItem (String value) {
        formatsMulti.add(value);
    }

    public void  clearList () {
        formatsMulti.clear();
    }

    public Criteria() {
        clean();

    }


    /**
     * method for the get extension
     *
     * @return a boolean
     */
    public boolean isExtensionEnable() {
        return isExtensionEnable;
    }

    /**
     * method for the set extension
     *
     * @param extensionEnable
     */
    public void setExtensionEnable(boolean extensionEnable) {
        isExtensionEnable = extensionEnable;
    }

    /**
     * method for the get Folder New
     *
     * @return file
     */
    public File getFolderNew() {


        return folderNew;
    }

    /**
     * method for the set folder new
     *
     * @param folderNew
     */
    public void setFolderNew(File folderNew) {
        this.folderNew = folderNew;
    }

    /**
     * method for the get path
     *
     * @return a String
     */
    public String getPath() {
        return path;
    }

    /*
     * method for the get path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * method for the get File name
     *
     * @return String
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * method for the get  fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * method for the get hidden
     *
     * @return a boolean
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * method for the set Hidden
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * method for the get folder
     *
     * @return a boolean
     */
    public boolean isFolder() {
        return folder;
    }

    /**
     * method for the set folder
     */
    public void setFolder(boolean folder) {
        this.folder = folder;
    }

    /**
     * method for the get extension
     *
     * @return
     */
    public String getExtension() {
        return extension;
    }

    /**
     * method for the set extension
     *
     * @param extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * method for the get owner
     *
     * @return String
     */
    public String getOwner() {
        return owner;
    }

    /**
     * method for the set owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * method for the get size
     *
     * @return a double
     */
    public double getSize() {
        return size;
    }

    /**
     * method for the set Size
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * method for the get read only
     *
     * @return boolean
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * method for the  set read only
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * method for the get value
     *
     * @return boolean
     */
    public boolean isKeySensitive() {
        return keySensitive;
    }

    /**
     * method for the  set
     */
    public void setKeySensitive(boolean keySensitive) {
        this.keySensitive = keySensitive;
    }

    /**
     * method for the  set
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * method for the get value
     *
     * @return boolean
     */
    public boolean isCheckSize() {
        return checkSize;
    }

    /**
     * method for the  set
     */
    public void setCheckSize(boolean checkSize) {
        this.checkSize = checkSize;
    }

    /**
     * method for the get value
     *
     * @return boolean
     */
    public String getSignSize() {
        return signSize;
    }

    /**
     * method for the  set
     */
    public void setSignSize(String signSize) {
        this.signSize = signSize;
    }

    /**
     * method for the get value
     *
     * @return boolean
     */
    public String getType() {
        return TypeSize;
    }

    /**
     * method for the  set
     */
    public void setType(String type) {
        TypeSize = type;
    }

    /**
     * method for the  set
     */
    public boolean isCheckOwner() {
        return checkOwner;
    }

    /**
     * method for the  set
     */
    public void setCheckOwner(boolean checkOwner) {
        this.checkOwner = checkOwner;
    }

    /**
     * method for the get value
     *
     * @return boolean
     */
    public String getTypeSize() {
        return TypeSize;
    }

    /**
     * method for the  set
     */
    public void setTypeSize(String typeSize) {
        TypeSize = typeSize;
    }

    /**
     * method for the get value
     *
     * @return boolean
     */
    public Timestamp getIniCreationFile() {
        return iniCreationFile;
    }

    /**
     * method for the  set
     */
    public void setIniCreationFile(Timestamp iniCreationFile) {
        this.iniCreationFile = iniCreationFile;
    }

    /**
     * method for the get value
     *
     * @return timesTamp
     */
    public Timestamp getFinCreationFile() {
        return finCreationFile;
    }

    /**
     * method for the  set
     */
    public void setFinCreationFile(Timestamp finCreationFile) {
        this.finCreationFile = finCreationFile;
    }

    /**
     * method for the get value
     *
     * @return timesTamp
     */
    public Timestamp getIniModFile() {
        return iniModFile;
    }

    /**
     * method for the  set
     */
    public void setIniModFile(Timestamp iniModFile) {
        this.iniModFile = iniModFile;
    }

    /**
     * method for the get value
     *
     * @return timesTamp
     */
    public Timestamp getFinModFile() {
        return finModFile;
    }

    /**
     * method for the  set
     */
    public void setFinModFile(Timestamp finModFile) {
        this.finModFile = finModFile;
    }

    /**
     * method for the get value
     *
     * @return timesTamp
     */
    public Timestamp getIniAccessFile() {
        return iniAccessFile;
    }

    /**
     * method for the  set
     */
    public void setIniAccessFile(Timestamp iniAccessFile) {
        this.iniAccessFile = iniAccessFile;
    }

    /**
     * method for the get value
     *
     * @return timesTamp
     */
    public Timestamp getFinAccessFile() {
        return finAccessFile;
    }

    /**
     * method for the  set
     */
    public void setFinAccessFile(Timestamp finAccessFile) {
        this.finAccessFile = finAccessFile;
    }

    /**
     * method for the get value
     *
     * @return String
     */
    public String getContent() {
        return content;
    }

    /**
     * method for the  set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * method for the get value
     *
     * @return boolean
     */
    public boolean isCheckContent() {
        return checkContent;
    }

    /**
     * method for the  set
     */
    public void setCheckContent(boolean checkContent) {
        this.checkContent = checkContent;
    }

    public boolean isCheckMulti() {
        return checkMulti;
    }

    public void setCheckMulti(boolean checkMulti) {
        this.checkMulti = checkMulti;
    }

    public ArrayList<String> getFormatsMulti() {
        return formatsMulti;
    }

    public void setFormatsMulti(ArrayList<String> formatsMulti) {
        this.formatsMulti = formatsMulti;
    }

    public String getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getCantMulti() {
        return cantMulti;
    }

    public void setCantMulti(double cantMulti) {
        this.cantMulti = cantMulti;
    }

}


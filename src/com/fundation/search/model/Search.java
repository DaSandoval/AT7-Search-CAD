/*
 * @(#)Class Search.java
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

import com.fundation.search.controller.Criteria;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class Search.
 *
 * @author Ana Mamani - AT-[07].
 * @version 1.0.
 */
public class Search {

    private List<AssetFile> asset;

    /**
     * Method for search to path, fileName.
     *
     * @param path       address.
     * @param fileName   name of the file.
     * @param extension  the file.
     * @param fileHidden name file hidden.
     */
    public void searchPath(String path, String fileName, String extension, boolean fileHidden) {
        File folder = new File(path);
        File[] listFolder = folder.listFiles();
        asset = new ArrayList<AssetFile>();
        for (File aListFolder : listFolder) {
            if (aListFolder.isFile()) {
                if (aListFolder.isHidden() != fileHidden) {
                    continue;
                }
                if (fileName.isEmpty() && !aListFolder.getName().contains(fileName)) {
                    continue;
                }
                if (extension.isEmpty() && aListFolder.getName().endsWith(extension)) {

                    continue;
                }
                if(aListFolder.getName().contains(fileName) & aListFolder.getName().endsWith(extension)){
                    AssetFile asstFile = new AssetFile();
                    asstFile.setExtent(extension);
                    asstFile.setHidden(fileHidden);
                    asstFile.setSize(aListFolder.length());
                    asstFile.setPath(aListFolder.getAbsolutePath());
                    asstFile.setFileName(aListFolder.getName());
                    asset.add(asstFile);
                }
            } else if (aListFolder.isDirectory()) {
                searchPath(aListFolder.getAbsolutePath(), fileName, extension, fileHidden);
            }
        }
    }

    /**
     * Method Method fileName and not estencion.
     *
     * @param path     address.
     * @param fileName      Name of file.
     * @param fileHidden    file Hidden.
     */
    public void searchPathNotExtencion(String path, String fileName, boolean fileHidden) {
        File folder = new File(path);
        File[] listFolder = folder.listFiles();
        asset = new ArrayList<AssetFile>();
        for (File aListFolder : listFolder) {
            if (aListFolder.isFile()) {
                if (fileHidden != aListFolder.isHidden()) {
                    continue;
                }
                if (fileName.isEmpty() && !aListFolder.getName().contains(fileName)) {
                    continue;
                }
                if (aListFolder.getName().contains(fileName)) {
                    AssetFile asstFile = new AssetFile();
                    asstFile.setExtent(aListFolder.getName().substring(aListFolder.getName().indexOf(".")));
                    asstFile.setHidden(fileHidden);
                    asstFile.setSize(aListFolder.length());
                    asstFile.setPath(aListFolder.getAbsolutePath());
                    asstFile.setFileName(aListFolder.getName());
                    asset.add(asstFile);
                }
            } else if (aListFolder.isDirectory()) {
                searchPathNotExtencion(aListFolder.getAbsolutePath(), fileName,fileHidden);
            }
        }
    }

    

    public List<AssetFile> getResult() {
        return asset;
    }
}
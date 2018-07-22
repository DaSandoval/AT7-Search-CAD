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

import java.io.File;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * This class Search.
 *
 * @author Ana Mamani - AT-[07].
 * @version 1.0.
 */
public class Search {

    private List<AssetFile> assetFile;

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
        assetFile = new ArrayList<AssetFile>();
        for (File aListFolder : listFolder) {
            if (aListFolder.isFile()) {
                if (aListFolder.isHidden() != fileHidden) {
                    break;
                }
                if (fileName.isEmpty() && !aListFolder.getName().contains(fileName)) {
                    break;
                }
                if (extension.isEmpty() && aListFolder.getName().endsWith(extension)) {
                    break;
                }
                if (aListFolder.getName().contains(fileName)) {
                    AssetFile asstFile = new AssetFile();
                    asstFile.setExtent(extension);
                    asstFile.setHidden(String.valueOf(fileHidden));
                    asstFile.setSize(Long.valueOf(String.valueOf(fileName.length())));
                    asstFile.setPath(aListFolder.getAbsolutePath());
                    asstFile.setFileName(aListFolder.getName());
                    assetFile.add(asstFile);
                }
            } else if (aListFolder.isDirectory()) {
                searchPath(aListFolder.getAbsolutePath(), fileName, extension, false);
            }
        }
        //return assetFile;
    }

    public void searchPathNotExtencion(String path, String fileName, boolean fileHidden) {
        File folder = new File(path);
        File[] listFolder = folder.listFiles();
        assetFile = new ArrayList<AssetFile>();
        for (File aListFolder : listFolder) {
            if (aListFolder.isFile()) {
                if (aListFolder.isHidden() != fileHidden) {
                    break;
                }
                if (fileName.isEmpty() && !aListFolder.getName().contains(fileName)) {
                    break;
                }
                if (aListFolder.getName().contains(fileName)) {
                    AssetFile asstFile = new AssetFile();
                    asstFile.setExtent("");
                    asstFile.setHidden(String.valueOf(fileHidden));
                    asstFile.setSize(Long.valueOf(String.valueOf(fileName.length())));
                    asstFile.setPath(aListFolder.getAbsolutePath());
                    asstFile.setFileName(aListFolder.getName());
                    assetFile.add(asstFile);
                }
            } else if (aListFolder.isDirectory()) {
                searchPathNotExtencion(aListFolder.getAbsolutePath(), fileName,false);
            }
        }
        //return assetFile;
    }

    public List<AssetFile> getResult() {
        return assetFile;
    }
}
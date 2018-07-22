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
import java.util.List;

/**
 * This class Search.
 *
 * @author Ana Mamani - AT-[07].
 * @version 1.0.
 */
public class Search {
    /**
     * List that content a object od the class AssetFile.
     */
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
        if (!path.isEmpty()) {
            for (int i = 0; i < listFolder.length; i++) {
                if (listFolder[i].isFile()) {
                    if (listFolder[i].isHidden() != fileHidden) {
                        break;
                    }
                    if (fileName.isEmpty() && !listFolder[i].getName().contains(fileName)) {
                        break;
                    }
                    if (extension.isEmpty() && listFolder[i].getName().endsWith(extension)) {
                        break;
                    }
                    AssetFile asstFile = new AssetFile();
                    asstFile.setPath(listFolder[i].getAbsolutePath());
                    asstFile.setFileName(listFolder[i].getName());
                    asstFile.setSize(Long.valueOf(fileName.length()));
                    asstFile.setHidden(listFolder[i].isHidden());
                    assetFile.add(asstFile);
                } else if (listFolder[i].isDirectory()) {
                    searchPath(listFolder[i].getAbsolutePath(), fileName, extension, false);
                }
            }
        }
    }

    /**
     * Generation a list of file or directori.
     *
     * @return a List of AssetFile.
     */
    public List<AssetFile> getResult() {
        return assetFile;
    }
}

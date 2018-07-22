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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
    public List<AssetFile> searchPath(String path, String fileName, String extension, boolean fileHidden) {
        File folder = new File(path);
        File[] listFolder = folder.listFiles();
        assetFile = new ArrayList<AssetFile>();
        if (!path.isEmpty()) {
            for(int i = 0; i < listFolder.length; i++) {
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
                    //asstFile.setHidden(listFolder[i].isHidden());
                    assetFile.add(asstFile);
                } else if (listFolder[i].isDirectory()) {
                    searchPath(listFolder[i].getAbsolutePath(), fileName, extension, false);
                }
            }
        }
        return assetFile;
    }

    /**
     * Generation a list of file or directori.
     *
     * @return a List of AssetFile.
     */
    public List<AssetFile> getResult() {
        for (AssetFile file : assetFile) {
            System.out.println(file.getPath());
        }
        return assetFile;
    }

    public static void main(String[] a) {
        Search s = new Search();
        s.searchPath("C:\\Users\\HP\\Desktop\\prueba8\\AT7-Search-CAD", "redme", ".txt", false);
        s.getResult();
    }
}

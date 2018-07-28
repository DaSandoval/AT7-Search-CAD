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

    private List<AssetFile> assetFile;

    public Search() {
        this.assetFile = new ArrayList<>();
    }

    public void searchPath(Criteria inputDate) {
        File folder = new File(inputDate.getPath());
        assetFile.clear();
        for (File aListFolder : folder.listFiles())
            if (aListFolder.isFile()) {
                if (aListFolder.isHidden() != inputDate.isHidden()) {
                    continue;
                }
                if (inputDate.getFileName().isEmpty() && !aListFolder.getName().contains(inputDate.getFileName())) {
                    continue;
                }
                if (inputDate.isExtensionEnable() && inputDate.getExtension().isEmpty() && aListFolder.getName().endsWith(inputDate.getExtension())) {

                    continue;
                }
                if (aListFolder.getName().contains(inputDate.getFileName())) {
                    if (inputDate.isExtensionEnable()) {
                        if (aListFolder.getName().endsWith(inputDate.getExtension())) {
                            AssetFile asstFile = new AssetFile();
                            asstFile.setExtent(inputDate.getExtension());
                            asstFile.setHidden(inputDate.isHidden());
                            asstFile.setSize(aListFolder.length());
                            asstFile.setPath(aListFolder.getAbsolutePath());
                            asstFile.setFileName(aListFolder.getName());

                            assetFile.add(asstFile);
                        }
                    }
                    else {
                        AssetFile asstFile = new AssetFile();
                        asstFile.setExtent(aListFolder.getName().substring(aListFolder.getName().indexOf(".")));
                        asstFile.setHidden(inputDate.isHidden());
                        asstFile.setSize(aListFolder.length());
                        asstFile.setPath(aListFolder.getAbsolutePath());
                        asstFile.setFileName(aListFolder.getName());

                        assetFile.add(asstFile);
                    }
                }
            } else if (aListFolder.isDirectory()) {
                inputDate.setPath(aListFolder.getAbsolutePath());
                searchPath(inputDate);
            }
    }


    public List<AssetFile> getResult() {
        return assetFile;
    }
}
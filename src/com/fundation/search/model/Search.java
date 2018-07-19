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

/**
 * This class Search.
 *
 * @author Ana Mamani - AT-[07].
 * @version 1.0.
 */
public class Search {
    /**
     * Method for search to path, fileName.
     *
     * @param path       address.
     * @param fileName   name of the file.
     * @param extension  the file.
     * @param fileHidden name file hidden.
     */
    public void searchPath(String path, String fileName, String extension, String fileHidden) {
        File folder = new File(path);
        File[] listFolder = folder.listFiles();
        if (!path.isEmpty()) {
            for (int i = 0; i < listFolder.length; i++) {
                if (listFolder[i].isFile()) {
                    if (!fileHidden.isEmpty() && listFolder[i].isHidden() && fileName.isEmpty() && extension.isEmpty()) {
                        System.out.println(listFolder[i].getName());
                    } else {
                        if (!fileName.isEmpty() && listFolder[i].getName().contains(fileName) && !extension.isEmpty() && listFolder[i].getName().endsWith(extension) && fileHidden.isEmpty()) {
                            System.out.println(listFolder[i].getName());
                        } else if (fileName.isEmpty() && !extension.isEmpty() && listFolder[i].getName().endsWith(extension) && fileHidden.isEmpty()) {
                            System.out.println(listFolder[i].getName());
                        } else if (extension.isEmpty() && !fileName.isEmpty() && listFolder[i].getName().contains(fileName) && fileHidden.isEmpty()) {
                            System.out.println(listFolder[i].getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("No path");
        }
    }
}

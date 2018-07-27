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

public class AssetFile extends Asset {


    public AssetFile() {
        super();
    }

    public AssetFile(String path, String fileName, String extent, boolean hidden, long size, String owner) {
        super(path, fileName, extent, hidden, size, owner);
    }
}
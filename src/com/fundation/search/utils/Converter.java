/*
 * @(#)Converter.java
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

package com.fundation.search.utils;

/**
 * Class that will contain converters.
 *
 * @author Daniel Sandoval - AT-[07].
 * @version 1.0.
 */
public class Converter {
    /**
     * Size of the file or movies or audio, gigas, megas, kilobyte.
     * SIZEFILE this is capacity.
     */
    private final String GIGAS = "gb";
    private final String MEGAS = "mg";
    private final String KILOBYTS = "kb";
    private final int SIZEFILE = 1024;

    /**
     * Method that convert the size of the file to bytes.
     *
     * @param size     of the file actual.
     * @param capacity string gb, mb, kb.
     * @return the new size in byte.
     */
    public long convertSize(int size, String capacity) {

        long convert = 0;
        if (capacity.equalsIgnoreCase(GIGAS)) {
            convert = (long) (size * Math.pow(SIZEFILE, 3));
        }
        if (capacity.equalsIgnoreCase(MEGAS)) {
            convert = (long) (size * Math.pow(SIZEFILE, 2));
        }
        if (capacity.equalsIgnoreCase(KILOBYTS)) {
            convert = (long) (size * Math.pow(SIZEFILE, 1));
        }

        return convert;
    }
}

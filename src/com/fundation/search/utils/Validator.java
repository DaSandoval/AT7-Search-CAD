/*
 * @(#)Validator.java
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

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * This class Validatos can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Daniel Sandoval - AT-[07].
 * @version 1.0.
 */

public class Validator {

    /**
     * Verify if is a path valid.
     *
     * @param isPath this is a direction of the file.
     * @return true y false.
     */
    public boolean isValidPath(String isPath) {
        File file = new File(isPath);
        return file.isAbsolute() && file.isDirectory();
    }

    /**
     * Verify this is a file in the directory of a path.
     *
     * @param fileExist this is a direction of a file.
     * @return true o false.
     */
    public boolean isFile(String fileExist) {
        File file = new File(fileExist);
        return (file.exists()) ? true : false;
    }

    /**
     * Verify that the file this is audio of different format.
     *
     * @param typeOfFile this is the direction of a file.
     * @param extend     this  is extend of a file of audio, movi, text and others.
     * @return true o false.
     */
    public boolean fileAndExtends(String typeOfFile, String extend) {
        String[] formato = typeOfFile.split(Pattern.quote("."));
        for (int i = 0; i < formato.length; i++)
            if (formato[i].equalsIgnoreCase(extend)) {
                return true;
            }
        return false;
    }

    /**
     * Verify if is a number the date insert.
     *
     * @param cadena this is a numbrer or string or chracter or others values.
     * @return true o fasle.
     */
    public boolean isValidNumber(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }

    /**
     * Verify if is an extend the String inseert.
     *
     * @param extend type of extend insert.
     * @return true orfalse.
     */
    public boolean isAExtend(String extend) {
        return (extend.charAt(0) == '.' && extend.length() > 3 && extend.length() < 7) ? true : false;
    }

    /**
     * Verify that the names insert they are equal without considering uppercase and lowercase.
     *
     * @param firstName  name enter foe keyboard.
     * @param secondName name of the file in the cpu.
     * @return true or false.
     */
    public boolean isNameEquals(String firstName, String secondName) {
        return (firstName.equalsIgnoreCase(secondName)) ? true : false;
    }

    /**
     * Verify it is the name to have space.
     *
     * @param nameFile name of the file they are space.
     * @return true or false.
     */
    public boolean nameWithSpace(String nameFile) {
        String[] cadenaNameFile = nameFile.split(" ");
        return (cadenaNameFile.length == 0) ? false : true;
    }

    /**
     * Verify if is a date valid dia/mes/año.
     *
     * @param date to verify.
     * @return true o false.
     */
    public boolean validateDate(String date) {
        try {
            SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
            formatofecha.setLenient(false);
            formatofecha.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}

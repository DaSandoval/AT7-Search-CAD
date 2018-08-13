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

package com.fundation.search.model;

import java.sql.Timestamp;

/**
 * This class AssetFile .
 *
 * @author Cesar Calvi - AT-[07].
 * @version 1.0.
 */
public class Asset {

    /**
     * Atributes of file.
     */
    private String path;
    private String fileName;
    private long size;
    private String extent;
    private boolean hidden;
    private String owner;
    private boolean realOnline;
    private Timestamp dateCreacion;
    private Timestamp dateModi;
    private Timestamp dateAccess;
    private boolean multimedia;

    /**
     * Constructor of the class.
     */
    public Asset() {
        this.path = "";
        this.hidden = false;
        this.fileName = "";
        this.size = 0;
        this.extent = "";
        this.owner = "";
        this.realOnline = false;
        this.dateAccess = new Timestamp(System.currentTimeMillis());
        this.dateCreacion = new Timestamp(System.currentTimeMillis());
        this.dateModi = new Timestamp(System.currentTimeMillis());
        this.multimedia = false;
    }

    /**
     * Get the value of Path.
     *
     * @return string.
     */
    public String getPath() {
        return path;
    }

    /**
     * Modify the parameters.
     *
     * @param path string.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the value of Hidden.
     *
     * @return string.
     */
    public boolean getHidden() {
        return hidden;
    }

    /**
     * Modify the parameters.
     *
     * @param hidden string.
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * Get the value of fileName.
     *
     * @return string.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Modify the parameters.
     *
     * @param fileName string.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Get the value of size.
     *
     * @return long.
     */
    public long getSize() {
        return size;
    }

    /**
     * Modify the parameters.
     *
     * @param size long.
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * Get the value of extends.
     *
     * @return string.
     */
    public String getExtent() {
        return extent;
    }

    /**
     * Modify the parameters.
     *
     * @param extent string.
     */
    public void setExtent(String extent) {
        this.extent = extent;
    }

    /**
     * Method get of Hidden of file.
     *
     * @return hidden.
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Method get of Owner of filr.
     *
     * @return owner.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Method set Owner of a file.
     *
     * @param owner input.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Method get Read Online of a file.
     *
     * @return readonly.
     */
    public boolean isRealOnline() {
        return realOnline;
    }

    /**
     * Method set Read Onli of a file.
     *
     * @param realOnline
     */
    public void setRealOnline(boolean realOnline) {
        this.realOnline = realOnline;
    }

    /**
     * Method get Date Creation of a file.
     *
     * @return datecreation.
     */
    public Timestamp getDateCreacion() {
        return dateCreacion;
    }

    /**
     * Method set Data Creation of a file.
     *
     * @param dateCreacion input.
     */
    public void setDateCreacion(Timestamp dateCreacion) {
        this.dateCreacion = dateCreacion;
    }

    /**
     * Method get Date Modification of a file.
     *
     * @return datemodifi.
     */
    public Timestamp getDateModi() {
        return dateModi;
    }

    /**
     * Method set Date Modification of a file.
     *
     * @param dateModi input.
     */
    public void setDateModi(Timestamp dateModi) {
        this.dateModi = dateModi;
    }

    /**
     * Method get Date Access of a file.
     *
     * @return dateAccess.
     */
    public Timestamp getDateAccess() {
        return dateAccess;
    }

    /**
     * Method set Date Access of a file.
     *
     * @param dateAccess input.
     */
    public void setDateAccess(Timestamp dateAccess) {
        this.dateAccess = dateAccess;
    }

    /**
     * Method of override of the class.
     *
     * @return String.
     */
    @Override
    public String toString() {
        return "Asset{" +
                "path='" + path + '\'' +
                ", fileName='" + fileName + '\'' +
                ", size=" + size +
                ", extent='" + extent + '\'' +
                ", hidden=" + hidden +
                ", owner='" + owner + '\'' +
                ", realOnline=" + realOnline +
                ", dateCreacion=" + dateCreacion +
                ", dateModi=" + dateModi +
                ", dateAccess=" + dateAccess +
                ", multimedia=" + multimedia +
                '}';
    }

    /**
     * Method get Multimedia of a file.
     *
     * @return Flag.
     */
    public boolean isMultimedia() {
        return multimedia;
    }

    /**
     * Method set Multimedia of a file.
     *
     * @param multimedia value of check.
     */
    public void setMultimedia(boolean multimedia) {
        this.multimedia = multimedia;
    }


}

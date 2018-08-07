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
     *
     * @return hidden.
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     *
     * @return owner.
     */
    public String getOwner() {
        return owner;
    }

    /**
     *
     * @param owner input.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     *
     * @return readonly.
     */
    public boolean isRealOnline() {
        return realOnline;
    }

    /**
     *
     * @param realOnline
     */
    public void setRealOnline(boolean realOnline) {
        this.realOnline = realOnline;
    }

    /**
     *
     * @return datecreation.
     */
    public Timestamp getDateCreacion() {
        return dateCreacion;
    }

    /**
     *
     * @param dateCreacion input.
     */
    public void setDateCreacion(Timestamp dateCreacion) {
        this.dateCreacion = dateCreacion;
    }

    /**
     *
     * @return datemodifi.
     */
    public Timestamp getDateModi() {
        return dateModi;
    }

    /**
     *
     * @param dateModi input.
     */
    public void setDateModi(Timestamp dateModi) {
        this.dateModi = dateModi;
    }

    /**
     *
     * @return dateAccess.
     */
    public Timestamp getDateAccess() {
        return dateAccess;
    }

    /**
     *
     * @param dateAccess input.
     */
    public void setDateAccess(Timestamp dateAccess) {
        this.dateAccess = dateAccess;
    }


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
     *
     * @return Flag.
     */
    public boolean isMultimedia() {
        return multimedia;
    }

    /**
     *
     * @param multimedia value of check.
     */
    public void setMultimedia(boolean multimedia) {
        this.multimedia = multimedia;
    }


}

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

/**
 * This class FrameSearch can be FileResult.
 *
 * @author Cesar Calvi - AT-[07].
 * @version 1.0.
 */
public class AssetMultimed extends Asset {

    /**
     * Constructor of the class.
     */
    public AssetMultimed() {
        super();
    }

    @Override
    public String toString() {
        return "AssetMultimed{" +
                "duracion=" + duracion +
                ", codec='" + codec + '\'' +
                ", frameRate='" + frameRate + '\'' +
                ", resolucion='" + resolucion + '\'' +
                '}';
    }

    private double duracion;
    private String codec;
    private String frameRate;
    private String resolucion;

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public String getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
}

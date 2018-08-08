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

import org.apache.log4j.Logger;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.probe.FFmpegStream;
import org.apache.commons.lang3.math.Fraction;


import org.slf4j.LoggerFactory;

import ucar.nc2.util.log.LoggerFactory;

import com.google.common.base.MoreObjects;
import com.google.gson.TypeAdapterFactory;
import org.slf4j.impl.StaticLoggerBinder;

import com.fundation.search.controller.Criteria;
import com.fundation.search.utils.LoggerWraper;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * This class Search.
 *
 * @author Ana Mamani - AT-[07].
 * @version 1.0.
 */
public class Search {
    final static Logger log = Logger.getLogger(Search.class);
    private List<Asset> assetList;

    /**
     * Attribute for the movie.
     */
    private FFprobe movie;
    private FFmpegProbeResult result;
    private FFmpegStream stream;
    private FFmpegStream stream2;

    private String PATH_TO_FFPROBE = "ffmpeg\\bin\\ffprobe.exe";

    /**
     * Method of the constructor.
     */
    public Search() {
        this.assetList = new ArrayList<>();
        log.info("Constructor Search: Start");
        try {
            movie = new FFprobe(this.PATH_TO_FFPROBE);
        } catch (IOException ex) {
            log.warn("The path ffmpeg\\bin\\ffprobe.exe " + ex.toString());
        }
        log.info("Constructor Search: End");
    }

    /**
     * Method that search in the path.
     *
     * @param inputData direcction of the file.
     */
    public void searchPath(Criteria inputData) {
        log.info("searchPath: Start " + inputData);
        File folder = new File(inputData.getPath());
        File[] listFolder = folder.listFiles();
        assetList.clear();
        for (File aListFolder : listFolder) {
            log.debug("searchPath: for each " + aListFolder.getPath());
            if (aListFolder.isFile()) {
                log.debug("searchPath: is file " + aListFolder.isFile());
                if (aListFolder.isHidden() != inputData.isHidden()) {
                    log.debug("searchPath: is hidden " + aListFolder.isHidden());
                    continue;
                }
                if (inputData.getFileName().isEmpty() && !inputData.isKeySensitive() && !aListFolder.getName().contains(inputData.getFileName())) {
                    log.debug("searchPath: content " + inputData.getFileName());
                    continue;
                }
                if (inputData.getFileName().isEmpty() && inputData.isKeySensitive() && !aListFolder.getName().toLowerCase().contains(inputData.getFileName().toLowerCase())) {
                    log.debug("searchPath: content sensiti " + aListFolder.getName());
                    continue;
                }
                if (inputData.isExtensionEnable() && !aListFolder.getName().endsWith(inputData.getExtension())) {
                    log.debug("searchPath: extention of file " + inputData.getExtension());
                    continue;
                }
                log.debug("searchPath: creation a current of Asset");
                Asset current = new Asset();
                if (this.searchSze(aListFolder.getAbsolutePath()).contains("audio") | this.searchSze(aListFolder.getAbsolutePath()).contains("video")) {
                    log.debug("searchPath: content audio or video " + aListFolder.getAbsolutePath());
                    AssetMultimed multi = new AssetMultimed();
                    multi.setPath(aListFolder.getAbsolutePath());
                    this.getMultimediaData(multi);
                    System.out.println("" + multi.toString());
                    System.out.println(((Asset) multi).toString());
                    current = multi;
                    current.setMultimedia(true);

                } else {
                    log.debug("searchPath: no content audio or video");
                    AssetFile asstFile = new AssetFile();
                    current = asstFile;
                    asstFile.setMultimedia(false);
                }
                log.debug("searchPath: set to current");
                current.setExtent(aListFolder.getName().substring(aListFolder.getName().indexOf(".")));
                current.setHidden(aListFolder.isHidden());
                current.setSize(aListFolder.length());
                current.setPath(aListFolder.getAbsolutePath());
                current.setFileName(aListFolder.getName());
                try {
                    log.debug("searchPath: set to current date");
                    current.setOwner(Files.getOwner(aListFolder.toPath()).getName());
                    current.setDateCreacion(new Timestamp(new Date(Files.readAttributes(aListFolder.toPath(), BasicFileAttributes.class).creationTime().toMillis()).getTime()));
                    current.setDateAccess(new Timestamp(new Date(Files.readAttributes(aListFolder.toPath(), BasicFileAttributes.class).lastAccessTime().toMillis()).getTime()));
                    current.setDateModi(new Timestamp(new Date(Files.readAttributes(aListFolder.toPath(), BasicFileAttributes.class).lastModifiedTime().toMillis()).getTime()));
                } catch (IOException e) {
                    log.error("searchPath: " + e.toString());
                    e.printStackTrace();
                }
                if (aListFolder.canWrite()) {
                    log.debug("searchPath: " + aListFolder.canWrite());
                    current.setRealOnline(false);
                } else {
                    log.debug("searchPath: true");
                    current.setRealOnline(true);
                }
                if (inputData.isKeySensitive()) {
                    log.debug("searchPath: " + inputData.isKeySensitive());
                    if (aListFolder.getName().toLowerCase().contains(inputData.getFileName().toLowerCase()) & aListFolder.getName().endsWith(inputData.getExtension())) {
                        if (!inputData.isFolder()) {
                            log.debug("searchPath: " + !inputData.isFolder());
                            assetList.add(current);
                        }

                    }
                } else {
                    log.debug("searchPath: " + !inputData.isKeySensitive());
                    if (aListFolder.getName().contains(inputData.getFileName()) & aListFolder.getName().endsWith(inputData.getExtension())) {
                        if (!inputData.isFolder()) {
                            assetList.add(current);
                        }
                    }
                }
            } else {
                log.debug("searchPath: is file " + !aListFolder.isFile());
                if (aListFolder.isDirectory()) {
                    inputData.setPath(aListFolder.getAbsolutePath());

                    if (inputData.getFileName().isEmpty() && !inputData.isKeySensitive() && !aListFolder.getName().contains(inputData.getFileName())) {
                        log.debug("searchPath: content folder " + inputData.getFileName());
                        continue;
                    }
                    if (inputData.getFileName().isEmpty() && inputData.isKeySensitive() && !aListFolder.getName().toLowerCase().contains(inputData.getFileName().toLowerCase())) {
                        log.debug("searchPath: content folder sensitiv " + inputData.getFileName());
                        continue;
                    }
                    log.debug("searchPath: create name file of AssetFile");
                    AssetFile nameFile = new AssetFile();
                    nameFile.setFileName(aListFolder.getName());
                    if (inputData.isKeySensitive()) {
                        log.debug("searchPath: " + inputData.isKeySensitive());
                        if (aListFolder.getName().toLowerCase().contains(inputData.getFileName().toLowerCase()) && inputData.isFolder()) {
                            assetList.add(nameFile);
                        }

                    } else {
                        log.debug("searchPath: " + !inputData.isKeySensitive());
                        if (aListFolder.getName().contains(inputData.getFileName()) && inputData.isFolder()) {
                            assetList.add(nameFile);
                        }
                    }
                    List<Asset> aux = new ArrayList<>(assetList);
                    searchPath(inputData);
                    assetList.addAll(aux);
                }
            }
        }
        log.info("searchPath: End " + inputData);
    }

    /**
     * Method about search of the owner.
     *
     * @param fileList ArrayList.
     * @param value    criteria.
     * @return ArrayList.
     */
    public ArrayList<Asset> owner(ArrayList<Asset> fileList, Criteria value) {
        log.info("owner: search for owner");
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            log.debug("owner: " + i.getOwner());
            if (i.getOwner().contains(value.getOwner())) {
                aux.add(i);
                log.debug("owner: adition to aux of type ArrayList");
            }
        }
        log.debug("owner: size of aux " + aux.size());
        return aux;
    }

    /**
     * Method that seach a content of file.
     *
     * @param value    criteria.
     * @param fileList of a ArrayList.
     * @return ArrayList.
     */
    public ArrayList<Asset> searchContent(Criteria value, ArrayList<Asset> fileList) {
        log.info("searchContent: search for content");
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            List<String> fl;
            try {
                fl = Files.readAllLines(new File(i.getPath()).toPath());
                log.debug("searchContent: " + fl.toString());
                for (String i2 : fl) {
                    if (i2.contains(value.getContent())) {
                        log.debug("searchContent: " + i2.contains(value.getContent()));
                        aux.add(i);
                        break;
                    }
                }
            } catch (Exception ex) {
                log.warn("searchContent: " + ex.toString());
            }
        }
        log.debug("searchContent: size of aux " + aux.size());
        return aux;
    }

    /**
     * method  about the search for file of readOnly.
     *
     * @param fileList ArrayList.
     * @param value    criteria.
     * @return Arraylist.
     */
    public ArrayList<Asset> searchReadOnly(ArrayList<Asset> fileList, Criteria value) {
        log.info("searchReadOnly: search for Read Only ");
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            if (i.isRealOnline() == value.isReadOnly()) {
                log.debug("searchReadOnly: " + (i.isRealOnline() == value.isReadOnly()));
                aux.add(i);
            }
        }
        log.debug("searchReadOnly: size of aux " + aux.size());
        return aux;
    }

    /**
     * Method about date creation.
     *
     * @param fileList ArrayList.
     * @param value    criteria.
     * @return ArrayList.
     */
    public ArrayList<Asset> searchDateCreation(ArrayList<Asset> fileList, Criteria value) {
        log.info("searchDateCreation: search for Date Creation ");
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            try {
                log.debug("searchDateCreation: date check ");
                Date f1 = new Date(value.getIniCreationFile().getTime());
                Date f2 = new Date(value.getFinCreationFile().getTime());
                Date f3 = new Date(i.getDateCreacion().getTime());
                if (f3.after(f1) & f3.before(f2)) {
                    aux.add(i);

                }

            } catch (Exception e) {
                log.warn("searchDateCreation: " + e.toString());
                e.printStackTrace();
            }
        }
        log.debug("searchDateCreation: content of date" + aux.size());
        return aux;
    }

    /**
     * Method about seach data access.
     *
     * @param fileList ArrayList.
     * @param value    criteria.
     * @return ArrayList.
     */
    public ArrayList<Asset> searchDateAccess(ArrayList<Asset> fileList, Criteria value) {
        log.info("searchDateAccess: search for Date Access");
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            try {
                log.debug("searchDateAccess: date check");
                Date f1 = new Date(value.getIniAccessFile().getTime());
                Date f2 = new Date(value.getFinAccessFile().getTime());
                Date f3 = new Date(i.getDateAccess().getTime());
                if (f3.after(f1) && f3.before(f2)) {
                    aux.add(i);

                }

            } catch (Exception e) {
                log.info("searchDateAccess: " + e.toString());
                e.printStackTrace();
            }
        }
        log.debug("searchDateAccess: content of date" + aux.size());
        return aux;

    }

    /**
     * Method about search date modification.
     *
     * @param fileList ArrayLisyt.
     * @param value    criteria.
     * @return ArrayList.
     */
    public ArrayList<Asset> searchDateMod(ArrayList<Asset> fileList, Criteria value) {
        log.info("searchDateMod: search for Date Modification");
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            try {
                log.debug("searchDateMod: date check");
                Date f1 = new Date(value.getIniModFile().getTime());
                Date f2 = new Date(value.getFinModFile().getTime());
                Date f3 = new Date(i.getDateModi().getTime());
                if (f3.after(f1) && f3.before(f2)) {
                    aux.add(i);

                }

            } catch (Exception e) {
                log.warn("searchDateMod: " + e.toString());
                e.printStackTrace();
            }
        }
        log.debug("searchDateMod: content of date " + aux.size());
        return aux;

    }

    /**
     * Method about search for size.
     *
     * @param fileList ArrayList.
     * @param value    criteria.
     * @return ArrayList.
     */
    public ArrayList<Asset> searchSze(ArrayList<Asset> fileList, Criteria value) {
        log.info("searchSze: search for Size");
        ArrayList<Asset> aux = new ArrayList<>();
        if (value.getSignSize().equals("Kbytes")) {
            log.debug("searchSze: " + value.getSignSize());
            value.setSize(value.getSize() * 1000.0);
        }
        if (value.getSignSize().equals("Mbytes")) {
            log.debug("searchSze: " + value.getSignSize());
            value.setSize(value.getSize() * 1000000.0);
        }

        for (Asset i : fileList) {
            double n1 = value.getSize();
            double n2 = Double.parseDouble(String.valueOf(i.getSize()));
            n1 = Math.round(n1 * 1000) / 1000;
            n2 = Math.round(n2 * 1000) / 1000;
            System.out.println(i.getFileName() + "  " + n1 + "  " + n2);
            if (value.getType().equals("=")) {
                log.debug("searchSze: type " + value.getType());
                System.out.println("igual");
                if (n2 == n1) {
                    log.debug("searchSze: n2 = n1 " + (n2 == n1));
                    aux.add(i);
                }
            }
            if (value.getType().equals("<")) {
                log.debug("searchSze: type " + value.getType());
                if (n2 < n1) {
                    log.debug("searchSze: n2 < n1 " + (n2 < n1));
                    aux.add(i);
                }
            }
            if (value.getType().equals(">")) {
                log.info("searchSze: type " + value.getType());
                if (n2 > n1) {
                    log.debug("searchSze: n2 > n1 " + (n2 > n1));
                    aux.add(i);
                }
            }
        }
        log.debug("searchSze: content of date " + aux.size());
        return aux;

    }

    /**
     * Method about seach file for movie.
     *
     * @param url direction string.
     * @return string.
     */
    public String searchSze(String url) {
        log.info("searchSze: search for Size imput date String url");
        String aux;
        TikaConfig config = TikaConfig.getDefaultConfig();
        Detector detector = config.getDetector();
        TikaInputStream stream;
        try {
            log.debug("searchSze: config " + config.toString());
            stream = TikaInputStream.get(new File(url));
            Metadata metadata = new Metadata();
            metadata.add(Metadata.RESOURCE_NAME_KEY, new File(url).getName());
            MediaType mediaType = detector.detect(stream, metadata);
            aux = mediaType.toString();
        } catch (Exception ex) {
            log.warn("searchSze: " + ex.toString());
            aux = "error";
        }
        log.debug("searchSze: return String " + aux);
        return aux;
    }

    /**
     * Method about search multimedia.
     *
     * @param fileList Arraylist.
     * @param value    criteria.
     * @return ArrayList.
     */
    public ArrayList<Asset> searchMultimedia(ArrayList<Asset> fileList, Criteria value) {
        log.info("searchMultimedia: search for multimedia");
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            if (i.isMultimedia()) {
                log.debug("searchMultimedia: is multimedia " + i.isMultimedia());
                aux.add(i);
            }
        }
        log.debug("searchMultimedia: content of date " + aux.size());
        return aux;
    }

    /**
     * Method about the get multimedia data.
     *
     * @param as criteria multimedia.
     */
    public void getMultimediaData(AssetMultimed as) {
        log.info("getMultimediaData: get date of multimedia");
        try {

            log.debug("getMultimediaData: fill in date AssetMultimed");
            stream = movie.probe(as.getPath()).getStreams().get(0);/*
            System.out.println("duracion   : " + stream.duration);
            System.out.println("codec      : " + stream.codec_name);
            System.out.println("frame rate : " + stream.avg_frame_rate);
            System.out.println("frame rate : " + stream);
            System.out.println("resolucion : " + stream.width + " x " + stream.height);*/

            stream = movie.probe(as.getPath()).getStreams().get(0);
            System.out.println("duracion   : "+stream.duration);
            System.out.println("codec      : "+stream.codec_name);
            //System.out.println("frame rate : "+stream.avg_frame_rate);
            System.out.println("frame rate : "+stream);
            System.out.println("resolucion : "+stream.width + " x " + stream.height);

            as.setDuracion(stream.duration);
            as.setCodec(stream.codec_name);
            as.setFrameRate(this.getFPS(stream.avg_frame_rate.toString()));
            as.setResolucion(stream.width + "x" + stream.height);
        } catch (IOException ex) {
            log.warn("getMultimediaData: " + ex.toString());
        }
    }

    /**
     * Method about check multimedia.
     *
     * @param fileList ArrayList.
     * @param value    criteria.
     * @return ArrayList.
     */
    public ArrayList<Asset> checkMulti(ArrayList<Asset> fileList, Criteria value) {
        log.info("checkMulti: check option multimedia");
        ArrayList<Asset> aux = new ArrayList<>();
        for (String j : value.getFormatsMulti()) {
            ArrayList<Asset> aux1 = new ArrayList<>();
            for (Asset i : fileList) {
                log.debug("checkMulti: " + i.getPath());
                String ext = i.getFileName().substring(i.getFileName().indexOf(".") + 1);
                ext = ext.toUpperCase();
                if (ext.equals(j)) {
                    log.debug("checkMulti: " + ext);
                    aux1.add(i);
                }
            }
            aux.addAll(aux1);
        }
        log.debug("checkMulti: conten of date " + aux.size());
        return aux;
    }

    /**
     * Method about verify of the check Frame ratio.
     *
     * @param fileList ArrayList.
     * @param value    criteria.
     * @return ArrayList.
     */
    public ArrayList<Asset> checkFrame(ArrayList<Asset> fileList, Criteria value) {
        log.info("checkFrame: check frame rate");
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            AssetMultimed asm = (AssetMultimed) i;
            String frame = ((asm).getFrameRate());
            System.out.println(frame + "        " + value.getFrameRate());
            frame = frame.substring(0, frame.indexOf("/"));
            if (frame != null && value.getFrameRate().equals(frame)) {
                log.debug("checkFrame: frame rate " + value.getFrameRate());
                aux.add(i);
            }
        }
        log.debug("checkFrame: conten of date " + aux.size());
        return aux;
    }

    /**
     * Method about for teh get ffprobe.
     *
     * @param ax string.
     * @return string.
     */
    public String getFPS(String ax) {
        log.info("getFPS: ");
        String aux = ax;
        double fr = Double.parseDouble(ax.substring(0, ax.indexOf("/")));
        double sg = Double.parseDouble(ax.substring(ax.indexOf("/") + 1));
        if (sg != 1.0) {
            log.debug("getFPS: 1.0 diferent " + sg);
            fr = fr / sg;
            String res = String.valueOf(Math.round(fr));
            aux = res + "/1";
        }
        log.debug("getFPS: conten of date " + aux);
        return aux;
    }

    /**
     * Method about the check Video Code.
     *
     * @param fileList ArrayList.
     * @param value    criteria.
     * @return ArrayList.
     */
    public ArrayList<Asset> checkVideoCode(ArrayList<Asset> fileList, Criteria value) {
        log.info("checkVideoCode: check Video Code");
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            AssetMultimed asm = (AssetMultimed) i;
            String frame = ((asm).getCodec());
            frame = frame.toUpperCase();
            if (value.getVideoCode().equals(frame)) {
                log.debug("checkVideoCode: " + value.getVideoCode());
                aux.add(i);
            }
        }
        log.info("checkVideoCode: content of date " + aux.size());
        return aux;
    }

    /**
     * Method about the check resolution.
     *
     * @param fileList ArrayList.
     * @param value    criteria.
     * @return ArrayList.
     */
    public ArrayList<Asset> checkResolution(ArrayList<Asset> fileList, Criteria value) {
        log.info("checkResolution: check Resolution");
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            AssetMultimed asm = (AssetMultimed) i;
            String frame = ((asm).getResolucion());
            if (value.getResolution().equals(frame)) {
                log.debug("checkResolution: " + value.getResolution());
                aux.add(i);
            }
        }
        log.info("checkResolution: content of date " + aux.size());
        return aux;
    }

    /**
     * Method about serch Duration of the movie.
     *
     * @param fileList ArrayList.
     * @param value    criteria.
     * @return ArrayList.
     */
    public ArrayList<Asset> searcDuration(ArrayList<Asset> fileList, Criteria value) {
        log.info("searcDuration: search of Duration");
        ArrayList<Asset> aux = new ArrayList<>();
        if (value.getScale().equals("H")) {
            log.debug("searcDuration: H == " + value.getScale());
            value.setCantMulti(value.getCantMulti() * 3600.0);
        }
        if (value.getScale().equals("M")) {
            log.debug("searcDuration: M == " + value.getScale());
            value.setCantMulti(value.getCantMulti() * 60.0);
        }
        for (Asset i : fileList) {
            AssetMultimed asm = (AssetMultimed) i;
            double n1 = value.getCantMulti();
            double n2 = asm.getDuracion();
            n1 = Math.round(n1 * 1000) / 1000;
            n2 = Math.round(n2 * 1000) / 1000;
            log.info("searcDuration: " + n1 + " " + n2);
            System.out.println(i.getFileName() + "  " + n1 + "  " + n2);
            if (value.getOperator().equals("=")) {
                log.debug("searcDuration: operator = is equals at " + value.getOperator());
                if (n2 == n1) {
                    log.debug("searcDuration: n2 == n1 " + (n2 == n1));
                    aux.add(i);
                }
            }
            if (value.getOperator().equals("<")) {
                log.debug("searcDuration: operator < is equals at " + value.getOperator());
                if (n2 < n1) {
                    log.debug("searcDuration: n2 < n1 " + (n2 < n1));
                    aux.add(i);
                }
            }
            if (value.getOperator().equals(">")) {
                log.debug("searcDuration: operator > is equals at " + value.getOperator());
                if (n2 > n1) {
                    log.debug("searcDuration: n2 > n1 " + (n2 > n1));
                    aux.add(i);
                    ;
                }
            }
        }
        log.info("searcDuration: content of date " + aux.size());
        return aux;

    }

    /**
     * Method of the get Result.
     *
     * @return List of criteria.
     */
    public List<Asset> getResult() {
        log.info("getResult: return of AssetList");
        return assetList;
    }
}
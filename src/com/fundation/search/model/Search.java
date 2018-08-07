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

    private List<Asset> assetList;

    private FFprobe movie;
    private FFmpegProbeResult result;
    private FFmpegStream stream;
    private FFmpegStream stream2;

    private String PATH_TO_FFPROBE = "ffmpeg\\bin\\ffprobe.exe";
    //C:\Users\admin-hp\Documents\FUNDACION-JALA\BUG ADVOCITY\ffmpeg\bin\ffprobe.exe

    public Search() {
        this.assetList = new ArrayList<>();
        try {
            movie = new FFprobe(this.PATH_TO_FFPROBE);
        } catch (IOException ex) {
        }
    }

    public void searchPath(Criteria inputData) {
        File folder = new File(inputData.getPath());
        File[] listFolder = folder.listFiles();
        assetList.clear();
        for (File aListFolder : listFolder) {
            if (aListFolder.isFile()) {
                if (aListFolder.isHidden() != inputData.isHidden()) {
                    continue;
                }
                if (inputData.getFileName().isEmpty() && !inputData.isKeySensitive() && !aListFolder.getName().contains(inputData.getFileName())) {
                    continue;
                }
                if (inputData.getFileName().isEmpty() && inputData.isKeySensitive() && !aListFolder.getName().toLowerCase().contains(inputData.getFileName().toLowerCase())) {
                    continue;
                }
                if (inputData.isExtensionEnable() && !aListFolder.getName().endsWith(inputData.getExtension())) {

                    continue;
                }
                Asset current = new Asset();
                if (this.searchSze(aListFolder.getAbsolutePath()).contains("audio")| this.searchSze(aListFolder.getAbsolutePath()).contains("video")) {
                    AssetMultimed multi = new AssetMultimed();
                    multi.setPath(aListFolder.getAbsolutePath());
                    this.getMultimediaData(multi);
                    System.out.println(""+multi.toString());
                    System.out.println(((Asset)  multi).toString());
                    current = multi;
                    current.setMultimedia(true);

                }
                else {
                    AssetFile asstFile = new AssetFile();
                    current = asstFile;
                    asstFile.setMultimedia(false);
                }
                current.setExtent(aListFolder.getName().substring(aListFolder.getName().indexOf(".")));
                current.setHidden(aListFolder.isHidden());
                current.setSize(aListFolder.length());
                current.setPath(aListFolder.getAbsolutePath());
                current.setFileName(aListFolder.getName());
                try {
                    current.setOwner(Files.getOwner(aListFolder.toPath()).getName());
                    current.setDateCreacion(new Timestamp(new Date(Files.readAttributes(aListFolder.toPath(), BasicFileAttributes.class).creationTime().toMillis()).getTime()));
                    current.setDateAccess(new Timestamp(new Date(Files.readAttributes(aListFolder.toPath(), BasicFileAttributes.class).lastAccessTime().toMillis()).getTime()));
                    current.setDateModi(new Timestamp(new Date(Files.readAttributes(aListFolder.toPath(), BasicFileAttributes.class).lastModifiedTime().toMillis()).getTime()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (aListFolder.canWrite()){
                    current.setRealOnline(false);
                }
                else {
                    current.setRealOnline(true);
                }
                if (inputData.isKeySensitive()){
                    if(aListFolder.getName().toLowerCase().contains(inputData.getFileName().toLowerCase()) & aListFolder.getName().endsWith(inputData.getExtension())){
                        if (!inputData.isFolder()){
                            assetList.add(current);
                        }

                    }
                }
                else {
                    if(aListFolder.getName().contains(inputData.getFileName()) & aListFolder.getName().endsWith(inputData.getExtension())){
                        if (!inputData.isFolder()){
                            assetList.add(current);
                        }
                    }
                }
            } else {
                if (aListFolder.isDirectory()) {
                    inputData.setPath(aListFolder.getAbsolutePath());

                    if (inputData.getFileName().isEmpty() && !inputData.isKeySensitive() && !aListFolder.getName().contains(inputData.getFileName())){
                        continue;
                    }
                    if (inputData.getFileName().isEmpty() && inputData.isKeySensitive() && !aListFolder.getName().toLowerCase().contains(inputData.getFileName().toLowerCase())){
                        continue;
                    }

                    AssetFile nameFile = new AssetFile();
                    nameFile.setFileName(aListFolder.getName());
                    if (inputData.isKeySensitive()) {
                        System.out.println("if ");
                        if (aListFolder.getName().toLowerCase().contains(inputData.getFileName().toLowerCase()) && inputData.isFolder()){
                            assetList.add(nameFile);
                        }

                    }else {
                        System.out.println("-else-");
                        if (aListFolder.getName().contains(inputData.getFileName()) && inputData.isFolder()){
                            assetList.add(nameFile);
                        }
                    }
                    List<Asset> aux = new ArrayList<>(assetList);
                    searchPath(inputData);
                    assetList.addAll(aux);
                }
            }
        }
    }
    public ArrayList<Asset> owner(ArrayList<Asset> fileList, Criteria value){
        ArrayList<Asset> aux = new ArrayList<>();
        for(Asset i : fileList){
            if (i.getOwner().contains(value.getOwner())){
                aux.add(i);
            }
        }
        return aux;

    }

    public ArrayList<Asset> searchContent(Criteria value, ArrayList<Asset> fileList){
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            List<String> fl;
            try {
                fl = Files.readAllLines(new File(i.getPath()).toPath());
                for(String i2 : fl){
                    if(i2.contains(value.getContent())){
                        aux.add(i);
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Warning - MalformedInputException");
            }
        }
        return aux;
    }

    public ArrayList<Asset> searchReadOnly (ArrayList<Asset> fileList, Criteria value){
        ArrayList<Asset> aux = new ArrayList<>();
        for(Asset i : fileList){
            if (i.isRealOnline()== value.isReadOnly()){
                aux.add(i);
            }
        }
        return aux;
    }

    public ArrayList<Asset> searchDateCreation (ArrayList<Asset> fileList, Criteria value){
        ArrayList<Asset> aux = new ArrayList<>();
        for(Asset i : fileList){
            try {
                Date f1 = new Date(value.getIniCreationFile().getTime());
                Date f2 = new Date(value.getFinCreationFile().getTime());
                Date f3 = new Date(i.getDateCreacion().getTime());
                if (f3.after(f1)  & f3.before(f2)) {
                    aux.add(i);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LoggerWraper.getIntance().getLog().info("SALE A BUSCAR POR FECHA DE CREACION");
        return aux;
    }

    public ArrayList<Asset> searchDateAccess (ArrayList<Asset> fileList, Criteria value){
        ArrayList<Asset> aux = new ArrayList<>();
        for(Asset i : fileList){
            try {
                Date f1 = new Date(value.getIniAccessFile().getTime());
                Date f2 = new Date(value.getFinAccessFile().getTime());
                Date f3 = new Date(i.getDateAccess().getTime());
                if (f3.after(f1)  & f3.before(f2)) {
                    aux.add(i);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return aux;

    }

    public ArrayList<Asset> searchDateMod (ArrayList<Asset> fileList, Criteria value){
        ArrayList<Asset> aux = new ArrayList<>();
        for(Asset i : fileList){
            try {
                Date f1 = new Date(value.getIniModFile().getTime());
                Date f2 = new Date(value.getFinModFile().getTime());
                Date f3 = new Date(i.getDateModi().getTime());
                if (f3.after(f1)  & f3.before(f2)) {
                    aux.add(i);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return aux;

    }

    public ArrayList<Asset> searchSze(ArrayList<Asset> fileList, Criteria value) {
        ArrayList<Asset> aux = new ArrayList<>();
        if (value.getSignSize().equals("Kbytes")) {
            value.setSize(value.getSize() * 1000.0);
        }
        if (value.getSignSize().equals("Mbytes")) {
            value.setSize(value.getSize() * 1000000.0);
        }

        for (Asset i : fileList) {
            double n1 = value.getSize();
            double n2 = Double.parseDouble(String.valueOf(i.getSize()));
            n1 = Math.round(n1 * 1000) / 1000;
            n2 = Math.round(n2 * 1000) / 1000;
            System.out.println(i.getFileName() + "  " + n1 + "  " + n2);
            if (value.getType().equals("=")) {
                System.out.println("igual");
                if (n2 == n1) {
                    aux.add(i);
                    System.out.println("igual");
                }
            }
            if (value.getType().equals("<")) {
                if (n2 < n1) {
                    aux.add(i);
                    System.out.println("menor");
                }
            }
            if (value.getType().equals(">")) {
                if (n2 > n1) {
                    aux.add(i);
                    System.out.println("mayor");
                }
            }
        }
        System.out.println("metodo search" + aux.size());
        return aux;

    }

    public String searchSze(String url) {
        String aux;
        TikaConfig config = TikaConfig.getDefaultConfig();
        Detector detector = config.getDetector();
        TikaInputStream stream;
        try {
            stream = TikaInputStream.get(new File(url));
            Metadata metadata = new Metadata();
            metadata.add(Metadata.RESOURCE_NAME_KEY, new File(url).getName());
            MediaType mediaType = detector.detect(stream, metadata);
            aux = mediaType.toString();
        } catch (Exception ex) {
            aux = "error";
        }
        return aux;
    }

    public ArrayList<Asset> searchMultimedia (ArrayList<Asset> fileList, Criteria value) {
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            if (i.isMultimedia()) {
                aux.add(i);
            }
        }
        return aux;
    }

    public void getMultimediaData(AssetMultimed as){
        try {
            stream = movie.probe(as.getPath()).getStreams().get(0);
            System.out.println("duracion   : "+stream.duration);
            System.out.println("codec      : "+stream.codec_name);
            System.out.println("frame rate : "+stream.avg_frame_rate);
            System.out.println("frame rate : "+stream);
            System.out.println("resolucion : "+stream.width + " x " + stream.height);
            as.setDuracion(stream.duration);
            as.setCodec(stream.codec_name);
            as.setFrameRate(this.getFPS(stream.avg_frame_rate.toString()));
            as.setResolucion(stream.width + "x" + stream.height);
        } catch (IOException ex) {
        }
    }

    public ArrayList<Asset> checkMulti (ArrayList<Asset> fileList, Criteria value) {
        ArrayList<Asset> aux = new ArrayList<>();
        for (String j : value.getFormatsMulti()) {
            ArrayList<Asset> aux1 = new ArrayList<>();
            for (Asset i : fileList) {
                String ext = i.getFileName().substring(i.getFileName().indexOf(".")+1);
                ext = ext.toUpperCase();
                if (ext.equals(j)) {
                    aux1.add(i);
                }
            }
            aux.addAll(aux1);
        }
        return aux;
    }

    public ArrayList<Asset> checkFrame (ArrayList<Asset> fileList, Criteria value) {
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            AssetMultimed asm = (AssetMultimed) i;
            String frame = ((asm).getFrameRate());
            System.out.println(frame+ "        "+value.getFrameRate());
            frame = frame.substring(0,frame.indexOf("/"));
            if (frame != null && value.getFrameRate().equals(frame)) {
                aux.add(i);
            }
        }
        return aux;
    }

    public String getFPS(String ax){
        String aux = ax;
        double fr = Double.parseDouble(ax.substring(0,ax.indexOf("/")));
        double sg = Double.parseDouble(ax.substring(ax.indexOf("/")+1));
        if(sg != 1.0){
            fr = fr / sg;
            String res = String.valueOf(Math.round(fr));
            aux = res + "/1";
        }
        return aux;
    }

    public ArrayList<Asset> checkVideoCode (ArrayList<Asset> fileList, Criteria value) {
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            AssetMultimed asm = (AssetMultimed) i;
            String frame = ((asm).getCodec());
            frame = frame.toUpperCase();
            if (value.getVideoCode().equals(frame)) {
                aux.add(i);
            }
        }
        return aux;
    }

    public ArrayList<Asset> checkResolution (ArrayList<Asset> fileList, Criteria value) {
        ArrayList<Asset> aux = new ArrayList<>();
        for (Asset i : fileList) {
            AssetMultimed asm = (AssetMultimed) i;
            String frame = ((asm).getResolucion());
            System.out.println("  frame"+frame+ " value"+value.getResolution() );
            if (value.getResolution().equals(frame)) {
                aux.add(i);
            }
        }
        return aux;
    }

    public ArrayList<Asset> searcDuration(ArrayList<Asset> fileList, Criteria value) {
        ArrayList<Asset> aux = new ArrayList<>();
        System.out.println("dato de entrada duracion"+value.getCantMulti()+"   "+value.getScale());
        if (value.getScale().equals("H")) {
            value.setCantMulti(value.getCantMulti() * 3600.0);
        }
        System.out.println("dato de entrada duracion 1    "+value.getCantMulti());
        if (value.getScale().equals("M")) {
            value.setCantMulti(value.getCantMulti() * 60.0);
        }
        System.out.println("dato de entrada duracion 2    "+value.getCantMulti());
        for (Asset i : fileList) {
            AssetMultimed asm = (AssetMultimed) i;
            double n1 = value.getCantMulti();
            double n2 = asm.getDuracion();
            n1 = Math.round(n1 * 1000) / 1000;
            n2 = Math.round(n2 * 1000) / 1000;
            System.out.println(i.getFileName() + "  " + n1 + "  " + n2);
            if (value.getOperator().equals("=")) {
                System.out.println("igual");
                if (n2 == n1) {
                    aux.add(i);
                    System.out.println("igual");
                }
            }
            if (value.getOperator().equals("<")) {
                if (n2 < n1) {
                    aux.add(i);
                    System.out.println("menor");
                }
            }
            if (value.getOperator().equals(">")) {
                if (n2 > n1) {
                    aux.add(i);
                    System.out.println("mayor");
                }
            }
        }
        System.out.println("metodo search" + aux.size());
        return aux;

    }

    public List<Asset> getResult() {
        return assetList;
    }
}
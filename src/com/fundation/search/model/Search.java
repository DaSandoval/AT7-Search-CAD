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

    private List<AssetFile> assetFile;

    /**
     * Constructor of the class.
     */
    public Search() {
        this.assetFile = new ArrayList<>();
    }

    /**
     *
     * @param inputData data of input.
     */
    public void searchPath(Criteria inputData) {
        File folder = new File(inputData.getPath());
        File[] listFolder = folder.listFiles();
        assetFile = new ArrayList<AssetFile>();
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
                if (inputData.isKeySensitive()){
                    if(aListFolder.getName().toLowerCase().contains(inputData.getFileName().toLowerCase()) & aListFolder.getName().endsWith(inputData.getExtension())){
                        AssetFile asstFile = new AssetFile();
                        asstFile.setExtent(aListFolder.getName().substring(aListFolder.getName().indexOf(".")));
                        asstFile.setHidden(aListFolder.isHidden());
                        asstFile.setSize(aListFolder.length());
                        asstFile.setPath(aListFolder.getAbsolutePath());
                        asstFile.setFileName(aListFolder.getName());
                        try {
                            asstFile.setOwner(Files.getOwner(aListFolder.toPath()).getName());
                            asstFile.setDateCreacion(new Timestamp(new Date(Files.readAttributes(aListFolder.toPath(), BasicFileAttributes.class).creationTime().toMillis()).getTime()));
                            asstFile.setDateAccess(new Timestamp(new Date(Files.readAttributes(aListFolder.toPath(), BasicFileAttributes.class).lastAccessTime().toMillis()).getTime()));
                            asstFile.setDateModi(new Timestamp(new Date(Files.readAttributes(aListFolder.toPath(), BasicFileAttributes.class).lastModifiedTime().toMillis()).getTime()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (aListFolder.canWrite()){
                            asstFile.setRealOnline(false);
                        }
                        else {
                            asstFile.setRealOnline(true);
                        }
                        if (!inputData.isFolder()){
                            assetFile.add(asstFile);
                        }

                    }
                }
                else {
                    if(aListFolder.getName().contains(inputData.getFileName()) & aListFolder.getName().endsWith(inputData.getExtension())){
                        AssetFile asstFile = new AssetFile();
                        asstFile.setExtent(aListFolder.getName().substring(aListFolder.getName().indexOf(".")));
                        asstFile.setHidden(aListFolder.isHidden());
                        asstFile.setSize(aListFolder.length());
                        asstFile.setPath(aListFolder.getAbsolutePath());
                        asstFile.setFileName(aListFolder.getName());
                        try {
                            asstFile.setOwner(Files.getOwner(aListFolder.toPath()).getName());
                            asstFile.setDateCreacion(new Timestamp(new Date(Files.readAttributes(aListFolder.toPath(), BasicFileAttributes.class).creationTime().toMillis()).getTime()));
                            asstFile.setDateAccess(new Timestamp(new Date(Files.readAttributes(aListFolder.toPath(), BasicFileAttributes.class).lastAccessTime().toMillis()).getTime()));
                            asstFile.setDateModi(new Timestamp(new Date(Files.readAttributes(aListFolder.toPath(), BasicFileAttributes.class).lastModifiedTime().toMillis()).getTime()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (aListFolder.canWrite()){
                            asstFile.setRealOnline(false);
                        }
                        else {
                            asstFile.setRealOnline(true);
                        }
                        if (!inputData.isFolder()){
                            assetFile.add(asstFile);
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


                    if (inputData.isKeySensitive()) {
                        System.out.println("if ");
                        if (aListFolder.getName().toLowerCase().contains(inputData.getFileName().toLowerCase()) && inputData.isFolder()){
                            AssetFile nameFile = new AssetFile();
                            nameFile.setFileName(aListFolder.getName());
                            assetFile.add(nameFile);
                        }

                    }else {
                        System.out.println("-else-");
                        if (aListFolder.getName().contains(inputData.getFileName()) && inputData.isFolder()){
                            AssetFile nameFile = new AssetFile();
                            nameFile.setFileName(aListFolder.getName());
                            assetFile.add(nameFile);
                        }
                    }
                    List<AssetFile> aux = new ArrayList<AssetFile>(assetFile);
                    searchPath(inputData);
                    assetFile.addAll(aux);
                }
            }
        }
    }

    /**
     *
     * @param fileList value.
     * @param value input data.
     * @return list.
     */
    public ArrayList<AssetFile> owner(ArrayList<AssetFile> fileList, Criteria value){
        ArrayList<AssetFile> aux = new ArrayList<>();
        for(AssetFile i : fileList){
            if (i.getOwner().contains(value.getOwner())){
                aux.add(i);
            }
        }
        return aux;

    }

    /**
     *
     * @param fileList value.
     * @param value input data.
     * @return list.
     */
    public ArrayList<AssetFile> searchContent(Criteria value, ArrayList<AssetFile> fileList){
        ArrayList<AssetFile> aux = new ArrayList<>();
        for (AssetFile i : fileList) {
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
            }
        }
        return aux;
    }

    /**
     *
     * @param fileList value.
     * @param value input data.
     * @return list.
     */
    public ArrayList<AssetFile> searchReadOnly (ArrayList<AssetFile> fileList, Criteria value){
        ArrayList<AssetFile> aux = new ArrayList<>();
        for(AssetFile i : fileList){
            if (i.isRealOnline()== value.isReadOnly()){
                aux.add(i);
            }
        }
        return aux;
    }

    /**
     *
     * @param fileList value.
     * @param value input data.
     * @return list.
     */
    public ArrayList<AssetFile> searchDateCreation (ArrayList<AssetFile> fileList, Criteria value){
        ArrayList<AssetFile> aux = new ArrayList<>();
        for(AssetFile i : fileList){
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
        return aux;

    }

    /**
     *
     * @param fileList value.
     * @param value input data.
     * @return list.
     */
    public ArrayList<AssetFile> searchDateAccess (ArrayList<AssetFile> fileList, Criteria value){
        ArrayList<AssetFile> aux = new ArrayList<>();
        for(AssetFile i : fileList){
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

    /**
     *
     * @param fileList value.
     * @param value input data.
     * @return list.
     */
    public ArrayList<AssetFile> searchDateMod (ArrayList<AssetFile> fileList, Criteria value){
        ArrayList<AssetFile> aux = new ArrayList<>();
        for(AssetFile i : fileList){
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

    /**
     *
     * @param fileList value.
     * @param value input data.
     * @return list.
     */
    public ArrayList<AssetFile> searchSze(ArrayList<AssetFile> fileList, Criteria value) {
        ArrayList<AssetFile> aux = new ArrayList<>();
        if (value.getSignSize().equals("Kbytes")) {
            value.setSize(value.getSize() * 1000.0);
        }
        if (value.getSignSize().equals("Mbytes")) {
            value.setSize(value.getSize() * 1000000.0);
        }

        for (AssetFile i : fileList) {
            double n1 = value.getSize();
            double n2 = Double.parseDouble(String.valueOf(i.getSize()));
            n1 = Math.round(n1 * 1000) / 1000;
            n2 = Math.round(n2 * 1000) / 1000;
            if (value.getType().equals("=")) {
                if (n2 == n1) {
                    aux.add(i);
                }
            }
            if (value.getType().equals("<")) {
                if (n2 < n1) {
                    aux.add(i);
                }
            }
            if (value.getType().equals(">")) {
                if (n2 > n1) {
                    aux.add(i);
                }
            }
        }
        return aux;

    }

    public List<AssetFile> getResult() {
        return assetFile;
    }
}
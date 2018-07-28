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
package com.fundation.search.controller;

import com.fundation.search.model.AssetFile;
import com.fundation.search.model.Search;
import com.fundation.search.view.FrameSearch;
import com.fundation.search.view.util.Constantes;

import javax.swing.ImageIcon;
import java.io.File;
import java.util.ArrayList;

/**
 * This class Search.
 *
 * @author Cesar Calvi - AT-[07].
 * @version 1.0.
 */
public class Controller {

    private FrameSearch frameSearch;
    private Criteria criteria;



    /**
     * Method of Controller of search constructs.
     * @param frameSearch
     */
    public Controller(FrameSearch frameSearch) {
        this.frameSearch = frameSearch;
        this.criteria = new Criteria();
    }


    /**
     * Method that reads event from the search button.
     */
    public void star() {
        frameSearch.getPnSearch().getBtSearch().addActionListener(a -> getAtribut());
    }

    /**
     * Method to see the values ​​of the view and add the spaces.
     */
    private void getAtribut() {
        frameSearch.cleanTable();
        Search search = new Search();
        criteria.clean();
        criteria.setFolderNew(new File(frameSearch.getPnSearch().getTxLocation().getText()));
        criteria.setFileName(frameSearch.getPnSearch().getTxSearch().getText());
        criteria.setPath(frameSearch.getPnSearch().getTxLocation().getText());
        criteria.setHidden(frameSearch.getPnSearch().getChFileHidden().isSelected());
        criteria.setExtensionEnable(frameSearch.getPnSearch().getChSearchText().isSelected());
        ArrayList<String> resul = frameSearch.getPnSearch().getExtencion();
        ArrayList<AssetFile> fileList = new ArrayList<>();
        if (resul.size()>0) {
            for (String file : resul) {
                criteria.setExtension(file);
                search.searchPath(criteria);
                fileList.addAll(search.getResult());
            }
        }
        else { search.searchPath(criteria);
            fileList = (ArrayList<AssetFile>) search.getResult();
        }

        for (AssetFile file : fileList) {
            frameSearch.addRowTable(
                    new ImageIcon(Constantes.getFileIcon()),
                    file.getFileName(),
                    file.getExtent(),
                    (Double.parseDouble(String.valueOf(file.getSize()))/1000000),
                    file.getPath(),
                    file.getHidden()
            );

        }
    }
}
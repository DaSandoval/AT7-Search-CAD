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
import java.util.ArrayList;

/**
 * This class Search.
 *
 * @author Cesar Calvi - AT-[07].
 * @version 1.0.
 */
public class Controller {

    private FrameSearch frameSearch;


    /**
     * Method of Controller of search constructs.
     * @param frameSearch
     */
    public Controller(FrameSearch frameSearch) {
        this.frameSearch = frameSearch;
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
        String name = frameSearch.getPnSearch().getTxSearch().getText();
        String path = frameSearch.getPnSearch().getTxLocation().getText();
        Search search = new Search();
        ArrayList<String> resul = frameSearch.getPnSearch().getExtencion();
        ArrayList<AssetFile> fileList = new ArrayList<>();
        if (resul.size()>0) {
            for (String file : resul) {
                search.searchPath(path, name, file, false);
                fileList.addAll(search.getResult());
            }
        }
        else { search.searchPathNotExtencion(path, name, false);
            fileList = (ArrayList<AssetFile>) search.getResult();
        }

        for (AssetFile file : fileList) {
            frameSearch.addRowTable(
                    new ImageIcon(Constantes.getFileIcon()),
                    file.getFileName(),
                    file.getExtent(),
                    file.getSize(),
                    file.getPath(),
                    file.getHidden()
            );

        }
    }
}

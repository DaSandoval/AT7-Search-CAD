package com.fundation.search.controller;

import com.fundation.search.model.AssetFile;
import com.fundation.search.model.Search;
import com.fundation.search.view.FrameSearch;
import com.fundation.search.view.util.Constantes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private FrameSearch frameSearch;


    public Controller(FrameSearch frameSearch) {
        this.frameSearch = frameSearch;
    }


    public void star() {
        frameSearch.getPnSearch().getBtSearch().addActionListener(a -> getAtribut());
    }

    private void getAtribut() {
        frameSearch.cleanTable();
        String name = frameSearch.getPnSearch().getTxSearch().getText();
        String Path = frameSearch.getPnSearch().getTxLocation().getText();
        Search search = new Search();
        ArrayList<String> resul = frameSearch.getPnSearch().getExtencion();
        ArrayList<AssetFile> fileList = new ArrayList<>();
        if (resul.size()>0) {
            for (String file : resul) {
                search.searchPath(Path, name, file, false);
                fileList.addAll(search.getResult());
            }
        }
        else { search.searchPathNotExtencion(Path, name, false);
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

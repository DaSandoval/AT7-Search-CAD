package com.fundation.search;

import com.fundation.search.controller.Controller;
import com.fundation.search.view.FrameSearch;

public class Main {
    public static void main(String[] a) {
        FrameSearch fra = new FrameSearch();
        Controller control = new Controller(fra);
        control.star();
        fra.setVisible(true);
    }
}

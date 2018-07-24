package com.fundation.search;

import com.fundation.search.controller.Controller;
import com.fundation.search.view.FrameSearch;

/**
 * The connection between the view and the model.
 */
public class Main {
    public static void main(String[] a) {
        FrameSearch viewFrame = new FrameSearch();
        Controller control = new Controller(viewFrame);
        control.star();
        viewFrame.setVisible(true);
    }
}

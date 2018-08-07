package com.fundation.search;

import com.fundation.search.controller.Controller;
import com.fundation.search.utils.LoggerWraper;
import com.fundation.search.view.FrameSearch;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.watermark.SubstanceImageWatermark;

/**
 * The connection between the view and the model.
 */
public class Main {
    public static void main(String[] a) {
        LoggerWraper.getIntance().getLog().info("Main");
        FrameSearch viewFrame = new FrameSearch();
        viewFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin");
        SubstanceLookAndFeel.setCurrentWatermark(new SubstanceImageWatermark("image//folder.jpg"));
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.4));
        Controller control = new Controller(viewFrame);
        control.star();
        viewFrame.setVisible(true);
    }
}

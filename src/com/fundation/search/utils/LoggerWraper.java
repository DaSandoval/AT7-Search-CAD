package com.fundation.search.utils;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;


public class LoggerWraper {

    private static LoggerWraper logwraper;
    private Logger log;


    private LoggerWraper() {
        BasicConfigurator.configure();
        log = Logger.getLogger(getClass().toString());
        try {
            PropertyConfigurator.configure(new FileInputStream("config/log4j.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*log.setUseParentHandlers(false);
        PropertiesConfiguration.configure("C:\\Users\\admin-hp\\Documents\\FUNDACION-JALA\\Prog102\\git lunes\\AT7-Search-CAD\\config\\log4j.properties");
        log.setUseParentHandlers(false);*/
    }
    //log.setUseParentHandlers(false);

    public static LoggerWraper getIntance() {
        if (logwraper == null) {
            logwraper = new LoggerWraper();
        }
        return logwraper;
    }

    public Logger getLog() {
        return log;
    }
}

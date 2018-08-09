package com.fundation.search.dataBase;
/*
 * @(#)Class SearchConnection.java
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.JDBC;
/**
 * This class SearchConnection.
 *
 * @author Ana Mamani - AT-[07].
 * @version 1.0.
 */
public class SearchConnection {

    private static SearchConnection searchConnection;
    private static Connection connection;

    public SearchConnection(){
        init();
    }
    public static SearchConnection getInstance(){
        if(searchConnection == null){
            searchConnection= new SearchConnection();
        }
        return searchConnection;
    }
    public void init(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection("jdbc:sqlite:search.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement state = null;
        try {
            state = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            state.execute("create table if not exists criteria(id INTEGER, criteriaJSON VARCHAR(500), primary key (id));");
            // state.execute("create table if not exists criteria(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, criteriaJSON VARCHAR(500))");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){
        return connection;
    }
}

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
package com.fundation.search.dataBase;

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

    /**
     * Attribut for the connection of the database.
     */
    private static SearchConnection searchConnection;
    private static Connection connection;

    /**
     * Inicialice the constructor.
     */
    public SearchConnection(){
        init();
    }

    /**
     * Method that search if exist a connection to the database.
     *
     * @return new conecction database or the database existent.
     */
    public static SearchConnection getInstance(){
        if(searchConnection == null){
            searchConnection= new SearchConnection();
        }
        return searchConnection;
    }

    /**
     * Method taht initialice the database.
     */
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that does the connection.
     *
     * @return the connection to the database.
     */
    public static Connection getConnection(){
        return connection;
    }
}

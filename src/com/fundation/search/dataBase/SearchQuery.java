/*
 * @(#)Class SearchQuery.java
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

import com.fundation.search.controller.Criteria;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * This class SearchQuery.
 *
 * @author Ana Mamani - AT-[07].
 * @version 1.0.
 */
public class SearchQuery {

    /**
     * attribute of connection.
     */
    private Connection connection;

    /**
     * Constructor of the class.
     */
    public SearchQuery(){
        connection= SearchConnection.getInstance().getConnection();
    }

    /**
     * Method that insert criteria in the database.
     * @param valueCriteriaJSON criteria convert in Json.
     */
    public void insertCriteria(String valueCriteriaJSON){
        String insert = "insert into criteria values(?, ?);";
        PreparedStatement pre = null;
        try {
            pre =connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pre.setString(2, valueCriteriaJSON);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that consult of the database.
     * @return consult.
     */
    public ResultSet getAllCriteria(){
        Statement state= null;
        try {
            state = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet set = null;
        try {
            set = state.executeQuery("Select id, criteriaJSON from criteria");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }
}

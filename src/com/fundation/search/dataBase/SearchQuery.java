package com.fundation.search.dataBase;
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
    private Connection connection;

    public SearchQuery(){
        connection= SearchConnection.getInstance().getConnection();
    }

    public void insertCriteria(String valueCriteriaJSON){
        System.out.println(valueCriteriaJSON);
        String insert = "insert into criteria values(?, ?);";
        PreparedStatement pre = null;
        try {
            pre =connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // System.out.println(pre);

        try {
            // System.out.println(pre);
            //  pre.setInt(1,1);
            pre.setString(2, valueCriteriaJSON);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        try {
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

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

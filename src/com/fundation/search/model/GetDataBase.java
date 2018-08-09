/*
 * @(#)Class Search.java
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

package com.fundation.search.model;

import com.fundation.search.controller.Criteria;
import com.fundation.search.dataBase.SearchQuery;
import com.google.gson.Gson;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class get value of data base.
 *
 * @author Daniel Sandoval - AT-[07].
 * @version 1.0.
 */
public class GetDataBase {
    private Map<String, String> saveMap;

    public Map<Integer, Criteria> getDataBaseInHashMap() throws SQLException {
        Map<Integer, Criteria> saveMap = new HashMap<Integer, Criteria>();
        SearchQuery searchQuery = new SearchQuery();
        ResultSet set = searchQuery.getAllCriteria();
        Gson gson = new Gson();
        while (set.next()) {
            Criteria recoverCriteria = gson.fromJson(set.getString("CriteriaJSON"), Criteria.class);
            int id = set.getInt("ID");
            saveMap.put(id, recoverCriteria);

        }
        return saveMap;
    }

}

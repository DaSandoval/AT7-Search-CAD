/*
 * @(#)View.java
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
package com.fundation.search.view.util;

/**
 * This class Constantes can be FileResult.
 *
 * @author Cesar Calvi - AT-[07].
 * @version 1.0.
 */
public abstract class Constantes{
	
	private static final String RESOURCE_FOLDER = "src/com/fundation/search/view/resources/";
	private static final String RESOURCE_FOLDER_IMG = "img/";
	private static final String FOLDER_ICON = "folder.png";
	private static final String FILE_ICON = "file.png";
	private static final String HIDDEN_FOLDER_ICON = "hidden-folder.png";
	
	public static String getFolderIcon(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(FOLDER_ICON).toString();
	}
	
	public static String getFileIcon(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(FILE_ICON).toString();
	}
	
}
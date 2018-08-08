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
	private static final String SEARCH_IMAGEN = "searchImage.jpg";
	private static final String SEARCH_BUTTON = "blue.png";
	private static final String SEARCH_IMAGE_ADV = "multimedia.jpg";
	private static final String SEARCH_IMAGE_TXT = "texto.png";
	private static final String SEARCH_IMAGE_PDF = "pdf.png";
	private static final String SEARCH_IMAGE_VIDEO = "video.png";
	private static final String SEARCH_IMAGE_JALA = "jala.png";
	private static final String HIDDEN_FOLDER_ICON = "hidden-folder.png";

	public static String getFolderIcon(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(FOLDER_ICON).toString();
	}

	public static String getFileIcon(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(FILE_ICON).toString();
	}
	public static String getLupaIcon(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(FOLDER_ICON).toString();
	}
	public static String getSearch(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_IMAGEN).toString();
	}
	public static String getSearchButton(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_BUTTON).toString();
	}
	public static String getSearchImageAdv(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_IMAGE_ADV).toString();
	}
	public static String getSearchImageTxt(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_IMAGE_TXT).toString();
	}
	public static String getSearchImagePdf(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_IMAGE_PDF).toString();
	}
	public static String getSearchImageVideo(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_IMAGE_VIDEO).toString();
	}
	public static String getSearchImageJala(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_IMAGE_JALA).toString();
	}
}
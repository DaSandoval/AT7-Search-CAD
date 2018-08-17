/*
 * @(#)Constantes.java
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

	/**
	 * Atributes for the imagens int he project.
	 */
	private static final String RESOURCE_FOLDER = "src/com/fundation/search/view/resources/";
	private static final String RESOURCE_FOLDER_IMG = "img/";
	private static final String FOLDER_ICON = "folder.png";
	private static final String FILE_ICON = "file.png";
	private static final String SEARCH_IMAGEN = "searchImage.jpg";
	private static final String SEARCH_BUTTON = "blue.png";
	private static final String SEARCH_IMAGE_ADV = "multi.jpg";
	private static final String SEARCH_IMAGE_TXT = "exten.png";
	private static final String SEARCH_IMAGE_PDF = "pdf.png";
	private static final String SEARCH_IMAGE_VIDEO = "video.png";
	private static final String SEARCH_IMAGE_JALA = "jala.png";
	private static final String SEARCH_DATE_BASE = "dataBase.png";
	private static final String SEARCH_SEVEND = "bd.png";

	/**
	 * Method get folderIcon.
	 *
	 * @return direction of the imagen.
	 */
	public static String getFolderIcon(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(FOLDER_ICON).toString();
	}

	/**
	 * Method get file icon.
	 *
	 * @return direction of the imagen.
	 */
	public static String getFileIcon(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(FILE_ICON).toString();
	}

	/**
	 * Method get lupa icon.
	 *
	 * @return direction of the imagen.
	 */
	public static String getLupaIcon(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(FOLDER_ICON).toString();
	}

	/**
	 * Method get search.
	 *
	 * @return direction of the imagen.
	 */
	public static String getSearch(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_IMAGEN).toString();
	}

	/**
	 * Method get search button.
	 *
	 * @return direction of the imagen.
	 */
	public static String getSearchButton(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_BUTTON).toString();
	}

	/**
	 * Method get image adv.
	 *
	 * @return direction of the imagen.
	 */
	public static String getSearchImageAdv(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_IMAGE_ADV).toString();
	}

	/**
	 * Method get image txt.
	 *
	 * @return direction of the imagen.
	 */
	public static String getSearchImageTxt(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_IMAGE_TXT).toString();
	}

	/**
	 * Method get image pdf.
	 *
	 * @return direction of the imagen.
	 */
	public static String getSearchImagePdf(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_IMAGE_PDF).toString();
	}

	/**
	 * Method get imagevideo.
	 *
	 * @return direction of the imagen.
	 */
	public static String getSearchImageVideo(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_IMAGE_VIDEO).toString();
	}

	/**
	 * Method get imagejala..
	 *
	 * @return direction of the imagen.
	 */
	public static String getSearchImageJala(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_IMAGE_JALA).toString();
	}

	/**
	 * Method get search data base.
	 *
	 * @return direction of the imagen.
	 */
	public static String getSearchDateBase(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_DATE_BASE).toString();
	}

	/**
	 * Method get search save.
	 *
	 * @return direction of the imagen.
	 */
	public static String getSearchSevend(){
		return new StringBuilder().append(RESOURCE_FOLDER).append(RESOURCE_FOLDER_IMG).append(SEARCH_SEVEND).toString();
	}
}
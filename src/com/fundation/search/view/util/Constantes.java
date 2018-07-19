package com.fundation.search.view.util;

public abstract class Constantes{
	
	private static final String RESOURCE_FOLDER = "resources/";
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
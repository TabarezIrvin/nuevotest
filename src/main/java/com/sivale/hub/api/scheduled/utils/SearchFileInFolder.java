/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: This class is used for ... 
 * Class created on 18 jul. 2019.
 * 
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class SearchFileInFolder {
    
    /**
     * 
     * Method used for ...
     * Returns an object of type boolean.
     * Method created on 9 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param pathFile
     * @return
     */
    public boolean validExistenceFolder(String pathFile) {
	File file = new File(pathFile);
	return file.isDirectory();
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type String[].
     * Method created on 9 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param pathFile
     * @param ext
     * @return
     */
    public String[] listContentsFolder(String pathFile, String ext) {
	File file = new File(pathFile);
	String[] files = file.list();
	List<String> fileList = new ArrayList<>();
	for(String archive: files) {
	    if(archive.contains(ext)) {
		fileList.add(archive);
	    }
	}
	if(!fileList.isEmpty()) {
	    files = fileList.toArray(new String[fileList.size()]);
	} else {
	    files = null;
	}
	return files;
    }
}

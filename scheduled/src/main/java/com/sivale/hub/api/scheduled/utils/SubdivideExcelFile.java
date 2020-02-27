/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivale.hub.api.scheduled.constants.Constantes;
import com.sivale.hub.api.scheduled.exception.HubException;

/**
 * Description: This class is used for ...
 * Class created on 27 sep. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class SubdivideExcelFile {
    
    static final Logger log = LoggerFactory.getLogger(SubdivideExcelFile.class);
    
    private String space = " ";
    private String dividerWindows = "\\";
    private String replacementDividerWindows = "**";
    private String replacementSpace = "#";
    
    /**
     * 
     * Method used for ...
     * Returns an object of type void.
     * Method created on 27 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param origin
     * @param destination
     * @param pathC
     * @param pathPython
     */
    public void excelMasterSection(String origin, String destination, String pathC, String pathPython) {
	SearchFileInFolder baec = new SearchFileInFolder();
	String[] existingFilesXlsx = baec.listContentsFolder(origin, Constantes.EXTENSION_XLSX);
	if (existingFilesXlsx != null) {
	    try {
		for (int i = 0; i < existingFilesXlsx.length; i++) {
		    Runtime rt = Runtime.getRuntime();
		    StringBuilder command = new StringBuilder();
		    command.append(pathC);
		    command.append(Constantes.FILE_C);
		    command.append(space);
		    command.append(pathPython.replace(dividerWindows, replacementDividerWindows));
		    command.append(space);
		    command.append(existingFilesXlsx[i].replace(Constantes.EXTENSION_XLSX, "").replaceAll(space,
			    replacementSpace));
		    command.append(space);
		    command.append(origin.replace(dividerWindows, replacementDividerWindows));
		    command.append(space);
		    command.append(destination.replace(dividerWindows, replacementDividerWindows));
		    command.append(space);
		    rt.exec(command.toString());
		    String[] extFilTxt = null;
		    while(true) {
			extFilTxt = baec.listContentsFolder(destination, Constantes.EXTENSION_EON);
			if (extFilTxt==null) {
			    Thread.sleep(Constantes.UN_MINUTO);
			}else {
			    Path directory = Paths.get(destination+extFilTxt[Constantes.CERO]);
			    Files.delete(directory);
			    break;
			}
		    }
		}
	    } catch (Exception e) {
		HubException he = new HubException();
		log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	    }
	}
    }

}

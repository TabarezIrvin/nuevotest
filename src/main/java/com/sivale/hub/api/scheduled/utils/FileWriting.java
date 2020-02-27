/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.utils;

import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivale.hub.api.scheduled.constants.Constantes;
import com.sivale.hub.api.scheduled.exception.HubException;

/**
 * Description: This class is used for ...
 * Class created on 18 jul. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class FileWriting {
    
    static final Logger log = LoggerFactory.getLogger(FileWriting.class);
    
    /**
     * 
     * Method used for ...
     * Returns an object of type FileWriter.
     * Method created on 18 jul. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param pathNameFile
     * @return
     */
    public PrintWriter openingFileWriting(String pathNameFile) {
	PrintWriter fileWrite = null;
	try {
	    fileWrite = new PrintWriter(pathNameFile, Constantes.UTF8);
	} catch (Exception e) {
	    HubException he = new HubException();
	    log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	}
	return fileWrite;
    }
   
    /**
     * 
     * Method used for ...
     * Returns an object of type void.
     * Method created on 18 jul. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param fileWrite
     * @param linea
     */
    public void writeInFile(PrintWriter fileWrite, String line) {
	if (!line.isEmpty()) {
	    fileWrite.write(line + "\n");
	}
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type void.
     * Method created on 18 jul. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param fileWrite
     */
    public void closedFileWrite(PrintWriter fileWrite) {
	fileWrite.close();
    }

}

/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivale.hub.api.scheduled.constants.Constantes;
import com.sivale.hub.api.scheduled.exception.HubException;

/**
 * Description: This class is used for ...
 * Class created on 30 ago. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class ProcessedRejected {
    
    static final Logger log = LoggerFactory.getLogger(ProcessedRejected.class);
    
    /**
     * 
     * Method used for ...
     * Returns an object of type boolean.
     * Method created on 1 oct. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param pathRejectedFiles
     * @return
     */
    public boolean checkRejected(String pathRejectedFiles) {
	return this.listContent(pathRejectedFiles).length>Constantes.UNO;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type void.
     * Method created on 1 oct. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param pathRejectedFiles
     * @param factor
     * @param pathAcceptedFiles
     */
    public void divideRejectedFiles(String pathRejectedFiles, int factor, String pathAcceptedFiles) {
	String[] files = this.listContent(pathRejectedFiles);
	int i = Constantes.CERO;
	if(files!=null) {
	    while(i<files.length) {
		String nameFile = String.format("%s%s", pathRejectedFiles, files[i]);
		if (!files[i].contains(Constantes.ARCHIVOS_RECHAZADOS_FINAL)) {
		    this.procesaRechazado(nameFile, factor, i, pathAcceptedFiles);
		    Path directory = Paths.get(nameFile);
//		    try {
//			Files.delete(directory);
//			
//		    } catch (IOException e) {
//			HubException he = new HubException();
//			log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
//		    }
		}
		i++;
	    }
	}
    }
    
    private void procesaRechazado(String pathRejectedFiles, int factor, int process,
	    String pathAcceptedFiles) {
	String line = null;
	int count = Constantes.CERO;
	FileWriting csv = new FileWriting();
	PrintWriter fileWriterCSV = null;
	try (BufferedReader br = new BufferedReader(new FileReader(pathRejectedFiles))) {
	    String subElement = String.format(Constantes.ARCHIVO_SUBPROCESADO, pathAcceptedFiles,
		    (int) Math.pow(Constantes.DIEZ, factor), process, count);
	    fileWriterCSV = csv.openingFileWriting(subElement);
	    while ((line = br.readLine()) != null) {
		if ((factor > Constantes.CERO) && (count > Constantes.DOS && (count % Math.pow(Constantes.DIEZ, factor)) == Constantes.UNO)) {
		    csv.closedFileWrite(fileWriterCSV);
		    subElement = String.format(Constantes.ARCHIVO_SUBPROCESADO, pathAcceptedFiles,
			    (int) Math.pow(Constantes.DIEZ, factor), process, count);
		    fileWriterCSV = csv.openingFileWriting(subElement);
		}
		csv.writeInFile(fileWriterCSV, line);
		if(factor == Constantes.CERO) {
		    csv.closedFileWrite(fileWriterCSV);
		    subElement = String.format(Constantes.ARCHIVO_SUBPROCESADO, pathAcceptedFiles,
			    (int) Math.pow(Constantes.DIEZ, factor), process, count+Constantes.UNO);
		    fileWriterCSV = csv.openingFileWriting(subElement);
		}
		count++;
	    }
	    csv.closedFileWrite(fileWriterCSV);
	} catch (Exception e) {
	    HubException he = new HubException();
	    log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	} finally {
	    if(fileWriterCSV!=null) {
		fileWriterCSV.close();
	    }
	}
    }
    
    private String[] listContent(String pathRejectedFiles) {
	SearchFileInFolder baec = new SearchFileInFolder();
	return baec.listContentsFolder(pathRejectedFiles, Constantes.EXTENSION_CSV);
    }

}

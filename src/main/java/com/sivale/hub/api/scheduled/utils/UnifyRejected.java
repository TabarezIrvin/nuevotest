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
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivale.hub.api.scheduled.constants.Constantes;
import com.sivale.hub.api.scheduled.exception.HubException;

/**
 * Description: This class is used for ...
 * Class created on 2 sep. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class UnifyRejected {
    
    static final Logger log = LoggerFactory.getLogger(UnifyRejected.class);
    
    /**
     * 
     * Method used for ...
     * Returns an object of type void.
     * Method created on 1 oct. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param pathArchivosRechazados
     */
    public void processLatestRejections(String pathArchivosRechazados) {
	SimpleDateFormat dateFormat = new SimpleDateFormat(Constantes.DATE_ARCHIVO);
	SearchFileInFolder baec = new SearchFileInFolder();
	String[] filesWithError = baec.listContentsFolder(pathArchivosRechazados, Constantes.EXTENSION_CSV);
	String pathRejectedConcentrated = String.format("%s%s%s%s", pathArchivosRechazados,
		Constantes.ARCHIVOS_RECHAZADOS_FINAL, dateFormat.format(new Date()), Constantes.EXTENSION_CSV);
	if (filesWithError.length > Constantes.UNO) {
	    FileWriting rejectedConcentrated = new FileWriting();
	    PrintWriter printWriter = rejectedConcentrated.openingFileWriting(pathRejectedConcentrated);
	    for (int i = Constantes.CERO; i < filesWithError.length; i++) {
		this.writeRejectedConcentrated(pathRejectedConcentrated, filesWithError[i], String.format("%s%s", pathArchivosRechazados, filesWithError[i]), rejectedConcentrated, printWriter);
	    }
	    printWriter.close();
	    rejectedConcentrated.closedFileWrite(printWriter);
	}
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type void.
     * Method created on 1 oct. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param pathRejectedConcentrated
     * @param filesWithError
     * @param pathRejected
     * @param rejectedConcentrated
     * @param printWriter
     */
    private void writeRejectedConcentrated(String pathRejectedConcentrated, String filesWithError, String pathRejected, FileWriting rejectedConcentrated, PrintWriter printWriter) {
	if (!pathRejectedConcentrated.contains(filesWithError)) {
	    try (BufferedReader br = new BufferedReader(new FileReader(pathRejected))) {
		String line =null;
		while ((line = br.readLine()) != null) {
		    rejectedConcentrated.writeInFile(printWriter, line);
		}
	    } catch (Exception e) {
		HubException he = new HubException();
		log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	    }
	    Path directory = Paths.get(pathRejected);
	    try {
		Files.delete(directory);
	    } catch (IOException e) {
		HubException he = new HubException();
		log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	    }
	}
    }

}

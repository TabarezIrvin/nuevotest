/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivale.hub.api.scheduled.constants.Constantes;
import com.sivale.hub.api.scheduled.exception.HubException;

/**
 * Description: This class is used for ...
 * Class created on 16 jul. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class MoveFiles {
    
    static final Logger log = LoggerFactory.getLogger(MoveFiles.class);
    
    /**
     * 
     * Method used for ...
     * Returns an object of type boolean.
     * Method created on 17 jul. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param origen
     * @param destino
     * @return
     */
    public boolean fromTo(String origin, String destination) {
	byte[] buffer = new byte[Constantes.BYTES];
	int size = Constantes.CERO;
	try (InputStream inputStreamOrigen = new FileInputStream(new File(origin));
	    OutputStream outputStreamDestino = new FileOutputStream(new File(destination)) ){
	    while ((size = inputStreamOrigen.read(buffer)) > Constantes.CERO) {
		outputStreamDestino.write(buffer, Constantes.CERO, size);
	    }
	} catch (IOException ioe) {
	    return false;
	}
	Path directory = Paths.get(origin);
	try {
	    Files.delete(directory);
	} catch (IOException e) {
	    HubException he = new HubException();
	    log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	}
	return true;
    }

}

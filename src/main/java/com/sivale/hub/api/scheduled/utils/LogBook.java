/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivale.hub.api.scheduled.constants.Constantes;
import com.sivale.hub.api.scheduled.exception.HubException;

/**
 * Description: This class is used for ...
 * Class created on 25 jul. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class LogBook {
    
    static final Logger log = LoggerFactory.getLogger(LogBook.class);
    
    /**
     * 
     * Method used for ...
     * Returns an object of type boolean.
     * Method created on 25 jul. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param datos
     * @param nombreTabla
     * @return
     */
    public void insertInLogBook(List<String> dataConnection, List<String> dataRegistration) {
	String sql = String.format(Constantes.QUERYPOSTGRESINSERT, dataRegistration.get(Constantes.CERO), new Date(),
		dataRegistration.get(Constantes.UNO), dataRegistration.get(Constantes.DOS),
		dataRegistration.get(Constantes.TRES));
	try {
	    Class.forName(dataConnection.get(Constantes.CERO));
	} catch (ClassNotFoundException e) {
	    HubException he = new HubException();
	    log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	    return;
	}
	try (Connection con = DriverManager.getConnection(dataConnection.get(Constantes.UNO),
		dataConnection.get(Constantes.DOS), dataConnection.get(Constantes.TRES));
		PreparedStatement pstm = con.prepareStatement(sql)) {
	    pstm.execute();
	} catch (SQLException e) {
	    HubException he = new HubException();
	    log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	}
    }

}

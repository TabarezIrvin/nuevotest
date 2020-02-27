/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.utils;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivale.hub.api.scheduled.constants.Constantes;
import com.sivale.hub.api.scheduled.exception.HubException;

/**
 * Description: This class is used for ...
 * Class created on 18 jul. 2019.
 * @author Irvin Tabarez Lopez [irvin.tabarez.eon@gmail.com]
 */
public class InsertInPostgres {
    
    static final Logger log = LoggerFactory.getLogger(InsertInPostgres.class);
    
    private String notExist = "does not exist";
    
    /**
     * 
     * Method used for ...
     * Returns an object of type boolean.
     * Method created on 21 ago. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param datosConeccion
     * @param fields
     * @param nameTable
     * @param validPathFiles
     * @param cron
     * @return
     */
    public boolean insertFile(List<String> datosConeccion, HashMap<Integer, String> fields, String nameTable,
	    String validPathFiles, String rejectedPathFiles) {
	String bdu = "bdu";
	String id = "\"IdBdu\",";
	try {
	    Class.forName(datosConeccion.get(Constantes.CERO));
	} catch (ClassNotFoundException e) {
	    return false;
	}
	boolean reg = false;
	FileReader fileReader = null;
	try (Connection con = DriverManager.getConnection(datosConeccion.get(Constantes.UNO),
		datosConeccion.get(Constantes.DOS), datosConeccion.get(Constantes.TRES))) {
	    CopyManager copyManager = new CopyManager((BaseConnection) con);
	    SearchFileInFolder baec = new SearchFileInFolder();
	    String[] files = baec.listContentsFolder(validPathFiles, Constantes.EXTENSION_CSV);
	    List<String> fallados = new ArrayList<>();
	    long valueInsert = Constantes.CERO;
	    for (int i = Constantes.CERO; i < files.length; i++) {
		//Se agrega try/catch para que si algun copy falla, el proceso continúe con los siguientes y no truene
		try {
		String nombreArchivo = String.format("%s%s", validPathFiles, files[i]);
		fileReader = new FileReader(nombreArchivo);
		String query = null;
		if(nameTable.equalsIgnoreCase(bdu)) {
		    query = String.format(Constantes.QUERYPOSTGRES, nameTable, id+this.obtenfields(fields),
			    Constantes.DELIMITADOR);
		}else {
		    query = String.format(Constantes.QUERYPOSTGRES, nameTable, this.obtenfields(fields),
			    Constantes.DELIMITADOR);
		}
		valueInsert = this.insertDB(copyManager, query, fileReader);
		if(valueInsert<(long)Constantes.UNO) {
		    if(valueInsert==(long)Constantes.CERO) {
			fallados.add(files[i]);
		    }else {
			fileReader.close();
			break;
		    }
		}
		fileReader.close();
		}
		catch(Exception e) {
		    log.error(e.getMessage(), e);
		}
	    }
	    this.mueveYBorrar(validPathFiles, rejectedPathFiles, fallados);
	    reg = (valueInsert>(long)Constantes.UNO_NEG);
	} catch (Exception e) {
	    HubException he = new HubException();
	    log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	} finally {
	    if(fileReader!=null) {
		try {
		    fileReader.close();
		} catch (IOException e) {
		    HubException he = new HubException();
		    log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
		}
	    }
	}
	return reg;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type boolean.
     * Method created on 1 oct. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param datosConeccion
     * @param tableName
     * @return
     */
    public boolean deleteTable(List<String> datosConeccion, String tableName) {
	String sql = String.format(Constantes.QUERYPOSTGRESDELETE, tableName);
	try {
	    Class.forName(datosConeccion.get(Constantes.CERO));
	} catch (ClassNotFoundException e) {
	    return false;
	}
	boolean reg = false;
	PreparedStatement pstm = null;
	try (Connection con = DriverManager.getConnection(datosConeccion.get(Constantes.UNO),
		datosConeccion.get(Constantes.DOS), datosConeccion.get(Constantes.TRES))) {
	    pstm = con.prepareStatement(sql);
	    pstm.execute();
	    pstm.close();
	    reg = true;
	} catch (Exception e) {
	    HubException he = new HubException();
	    log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	} finally {
	    if(pstm!=null) {
		try {
		    pstm.close();
		} catch (SQLException e) {
		    HubException he = new HubException();
		    log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
		}
	    }
	}
	return reg;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type long.
     * Method created on 1 oct. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param copyManager
     * @param query
     * @param fileReader
     * @return
     */
    private long insertDB(CopyManager copyManager, String query, FileReader fileReader) {
	long reg = Constantes.CERO;
	try {
	    reg = copyManager.copyIn(query, fileReader);
	} catch (Exception e) {
	    if (e.getMessage().toUpperCase().contains(notExist.toUpperCase())) {
		reg = Constantes.UNO_NEG;
	    } else {
		log.error(e.getMessage(), e);
		reg = Constantes.DOS_NEG;
	    }
	}
	return reg;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type void.
     * Method created on 1 oct. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param validPathFiles
     * @param rejectedPathFiles
     * @param damaged
     */
    private void mueveYBorrar(String validPathFiles, String rejectedPathFiles, List<String> damaged) {
	SearchFileInFolder baec = new SearchFileInFolder();
	String[] files = baec.listContentsFolder(validPathFiles, Constantes.EXTENSION_CSV);
	 MoveFiles move = new MoveFiles();
	for(int i=Constantes.CERO; i<files.length;i++) {
	    if(damaged.contains(files[i])) {
		move.fromTo(validPathFiles+files[i], rejectedPathFiles+files[i]);
	    }else {
		Path directory = Paths.get(validPathFiles+files[i]);
		try {
		    Files.delete(directory);
		} catch (IOException e) {
		    HubException he = new HubException();
		    log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
		}
	    }
	}
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type String.
     * Method created on 19 jul. 2019, by Irvin Tabarez Lopez [irvin.tabarez.eon@gmail.com]
     * @param fields
     * @return
     */
    private String obtenfields(HashMap<Integer, String> fields) {
	StringBuilder fieldsLine = new StringBuilder();
	for (int i = Constantes.CERO; i < fields.size(); i++) {
	    fieldsLine.append("\"");
	    fieldsLine.append(fields.get(i));
	    fieldsLine.append("\"");
	    fieldsLine.append(Constantes.COMA);
	}
	return fieldsLine.substring(Constantes.CERO, fieldsLine.length() - Constantes.UNO);
    }
    
}

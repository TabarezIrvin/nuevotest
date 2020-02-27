/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.cron;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import com.sivale.hub.api.scheduled.commons.ISchedulerJob;
import com.sivale.hub.api.scheduled.constants.Constantes;
import com.sivale.hub.api.scheduled.constants.ConstantesMensajes;
import com.sivale.hub.api.scheduled.constants.fields.mandatorys.FieldsDefaultKeyMonitorInforma;
import com.sivale.hub.api.scheduled.exception.HubException;
import com.sivale.hub.api.scheduled.utils.BuildExcelFinal;
import com.sivale.hub.api.scheduled.utils.InsertInPostgres;
import com.sivale.hub.api.scheduled.utils.LogBook;
import com.sivale.hub.api.scheduled.utils.MoveFiles;
import com.sivale.hub.api.scheduled.utils.OSUtils;
import com.sivale.hub.api.scheduled.utils.ProcessedRejected;
import com.sivale.hub.api.scheduled.utils.SearchFileInFolder;
import com.sivale.hub.api.scheduled.utils.SubdivideExcelFile;
import com.sivale.hub.api.scheduled.utils.UnifyRejected;

/**
 * Description: This class is used for ...
 * Class created on 1 oct. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
@ISchedulerJob
public class KeyMonitorInformaImp {

    static final Logger log = LoggerFactory.getLogger(KeyMonitorInformaImp.class);
    
    @Value("${ruta.archivo.en.c.win}")
    private String windowsPathC;
    
    @Value("${ruta.archivo.en.c.linux}")
    private String linuxPathC;
    
    @Value("${ruta.archivo.en.python.win}")
    private String windowsPathPython;
    
    @Value("${ruta.archivo.en.python.linux}")
    private String linuxPathPython;
    
    @Value("${sivale.ruta.origen.keymonitor.informa.win}")
    private String windowsOrigin;

    @Value("${sivale.ruta.destino.keymonitor.informa.win}")
    private String windowsDestination;
    
    @Value("${sivale.ruta.origen.keymonitor.informa.linux}")
    private String linuxOrigin;

    @Value("${sivale.ruta.destino.keymonitor.informa.linux}")
    private String linuxDestination;
    
    @Value("${sivale.nombre.tabla.keymonitor.informa}")
    private String tableName;
    
    //Constantes para coneccion a BD--------------------
    @Value("${db.classForName}")
    private String classForName;
    
    @Value("${db.jdbc}")
    private String jdbc;
    
    @Value("${db.usuario}")
    private String user;
    
    @Value("${db.contrasenha}")
    private String password;
    
    private String cronJobName = "cronJobKeymonitorInforma";
    private String pathC = null;
    private String pathPython = null;
    
    @Scheduled(cron = "${cronExpression}")
    public void cronJobKeymonitorInforma() {
	log.info(ConstantesMensajes.LOG_INICIO, tableName);
	long start = System.currentTimeMillis();
	boolean operationPerformed = false;
	int factor = Constantes.DOS;
	String[] routes = this.assignRoutes();
	String origin = routes[Constantes.CERO];
	String destination = routes[Constantes.UNO];
	String pathAcceptedFiles = routes[Constantes.DOS];
	String pathRejectedFiles = routes[Constantes.TRES];
	String[] paths = { routes[Constantes.DOS], routes[Constantes.TRES] };
	FieldsDefaultKeyMonitorInforma fieldsDefaultKeyMonitorInforma = new FieldsDefaultKeyMonitorInforma();
	if (!this.validExistenceOriginDestinationFile(start, origin, destination)) {
	    return;
	}
	SubdivideExcelFile sef = new SubdivideExcelFile();
	sef.excelMasterSection(origin, destination, pathC, pathPython);
	SearchFileInFolder baec = new SearchFileInFolder();
	String[] existingFiles = baec.listContentsFolder(destination, Constantes.EXTENSION_XLSX);
	if (existingFiles != null) {
	    BuildExcelFinal cef = new BuildExcelFinal();
	    cef.setPositionDBFieldTarjeta(Constantes.DIECINUEVE);
	    for (int i = 0; i < existingFiles.length; i++) {
		operationPerformed |= cef.processExcel(destination, existingFiles[i], this.shapeFields(fieldsDefaultKeyMonitorInforma),
			paths, factor);
	    }
	    cef.procesFailed(pathRejectedFiles);
	}
	InsertInPostgres postgres = new InsertInPostgres();
	if (operationPerformed) {
	    operationPerformed = false;
	    operationPerformed |= postgres.insertFile(this.dataForm(), fieldsDefaultKeyMonitorInforma.positionFieldBD(),
		    tableName, pathAcceptedFiles, pathRejectedFiles);
	}
	if (!operationPerformed) {
	    this.insertInBitacora(Constantes.ERROR, ((System.currentTimeMillis() - start) / Constantes.MIL),
		    String.format(ConstantesMensajes.ERROR_BD, tableName), null);
	    return;
	}
	ProcessedRejected rejected = new ProcessedRejected();
	while (rejected.checkRejected(pathRejectedFiles) && operationPerformed) {
	    if (factor == Constantes.CERO) {
		break;
	    }
	    rejected.divideRejectedFiles(pathRejectedFiles, --factor, pathAcceptedFiles);
	    operationPerformed |= postgres.insertFile(this.dataForm(), fieldsDefaultKeyMonitorInforma.positionFieldBD(),
		    tableName, pathAcceptedFiles, pathRejectedFiles);
	}
	if (operationPerformed) {
	    UnifyRejected unificarejected = new UnifyRejected();
	    unificarejected.processLatestRejections(pathRejectedFiles);
	    this.moveSourceFilesToFinalDestination(origin, destination);
	}
	long fin = System.currentTimeMillis();
	this.insertInBitacora(operationPerformed ? Constantes.CORRECTO : Constantes.ERROR,
		((fin - start) / Constantes.MIL), operationPerformed ? null : ConstantesMensajes.ERROR,
		null);
	log.info(ConstantesMensajes.LOG_FIN, tableName, (int) ((fin - start) / Constantes.MIL));
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type List<HashMap>.
     * Method created on 10 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param fieldsRejectionsDayCVV
     * @return
     */
    @SuppressWarnings("rawtypes")
    private List<HashMap> shapeFields(FieldsDefaultKeyMonitorInforma fieldsDefaultKeyMonitorInforma) {
	List<HashMap> fields = new ArrayList<>();
	fields.add(fieldsDefaultKeyMonitorInforma.fieldTypeExcel());
	fields.add(fieldsDefaultKeyMonitorInforma.mappingDBExcel());
	fields.add(fieldsDefaultKeyMonitorInforma.positionFieldBD());
	return fields;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type List<String>.
     * Method created on 10 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @return
     */
    private List<String> dataForm() {
	List<String> datas = new ArrayList<>();
	datas.add(classForName);
	datas.add(jdbc);
	datas.add(user);
	datas.add(password);
	return datas;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type String[].
     * Method created on 10 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @return
     */
    private String[] assignRoutes () {
	String[] routes = new String[Constantes.CUATRO];
	if(OSUtils.isWindows()) {
	    routes[Constantes.CERO]=windowsOrigin;
	    routes[Constantes.UNO]=windowsDestination;
	    routes[Constantes.DOS]=windowsDestination+Constantes.ACEPTADOS+Constantes.SEPARADOR_WIN;
	    routes[Constantes.TRES]=windowsDestination+Constantes.RECHAZADOS+Constantes.SEPARADOR_WIN;
	    pathC = windowsPathC;
	    pathPython = windowsPathPython;
	}else {
	    routes[Constantes.CERO]=linuxOrigin;
	    routes[Constantes.UNO]=linuxDestination;
	    routes[Constantes.DOS]=linuxDestination+Constantes.ACEPTADOS+Constantes.SEPARADOR_OTROS;
	    routes[Constantes.TRES]=linuxDestination+Constantes.RECHAZADOS+Constantes.SEPARADOR_OTROS;
	    pathC = linuxPathC;
	    pathPython = linuxPathPython;
	}
	return routes;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type String[].
     * Method created on 10 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param origin
     * @param destination
     * @return
     */
    private boolean moveSourceFilesToFinalDestination(String origin, String destination) {
	boolean reg = false;
	try {
	    SearchFileInFolder baec = new SearchFileInFolder();
	    String[] existingFilesDestination = baec.listContentsFolder(destination, Constantes.EXTENSION_XLSX);
	    int cont = 0;
	    while (existingFilesDestination != null && cont < existingFilesDestination.length) {
		Path directory = Paths.get(String.format("%s%s", destination, existingFilesDestination[cont]));
		Files.delete(directory);
		cont++;
	    }
	    MoveFiles moveFiles = new MoveFiles();
	    String[] existingFiles = baec.listContentsFolder(origin, Constantes.EXTENSION_XLSX);
	    cont = 0;
	    while (existingFiles != null && cont < existingFiles.length) {
		if (!moveFiles.fromTo(String.format("%s%s", origin, existingFiles[cont]),
			String.format("%s%s", destination, existingFiles[cont]))) {
		    this.insertInBitacora(Constantes.ERROR, Constantes.CERO,
			    String.format(ConstantesMensajes.ERROR_MOVER, cronJobName), null);
		}
		cont++;
	    }
	    reg = true;
	} catch (Exception e) {
	    HubException he = new HubException();
	    log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	}
	return reg;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type boolean.
     * Method created on 10 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param start
     * @param origin
     * @param destination
     * @return
     */
    private boolean validExistenceOriginDestinationFile(long start, String origin, String destination) {
	boolean valid = true;
	SearchFileInFolder baec = new SearchFileInFolder();
	boolean existeorigin = baec.validExistenceFolder(origin);
	boolean existeDestino = baec.validExistenceFolder(destination);
	String[] existingFiles = baec.listContentsFolder(origin, Constantes.EXTENSION_XLSX);
	StringBuilder mensajeError = new StringBuilder();
	if(!existeorigin) {
	    mensajeError.append(String.format(ConstantesMensajes.RUTA_ORIGEN,origin));
	}
	if(!existeDestino) {
	    mensajeError.append(String.format(ConstantesMensajes.RUTA_DESTINO,existeDestino));
	}
	if(existingFiles==null) {
	    mensajeError.append(String.format(ConstantesMensajes.ARCHIVO, tableName));
	}
	if(mensajeError.length()>0) {
	    long fin = System.currentTimeMillis();
	    double total = (fin - start) / (double)Constantes.MIL;
	    this.insertInBitacora(Constantes.ERROR, total, mensajeError.toString(), null);
	    valid=false;
	}
	return valid;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type void.
     * Method created on 10 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param status
     * @param time
     * @param error
     * @param pathFile
     */
    private void insertInBitacora(String status, double time, String error, String pathFile) {
	LogBook bitacora = new LogBook();
	List<String> datosConeccion = new ArrayList<>();
	datosConeccion.add(classForName);
	datosConeccion.add(jdbc);
	datosConeccion.add(user);
	datosConeccion.add(password);
	List<String> datosRegistro = new ArrayList<>();
	datosRegistro.add(cronJobName);
	datosRegistro.add(status);
	datosRegistro.add(time + " segundos");
	datosRegistro.add(error);
	datosRegistro.add(pathFile);
	bitacora.insertInLogBook(datosConeccion, datosRegistro);
    }
    
}

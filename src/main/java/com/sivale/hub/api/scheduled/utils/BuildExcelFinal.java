/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivale.hub.api.scheduled.constants.Constantes;
import com.sivale.hub.api.scheduled.exception.HubException; 

/**
 * Description: This class is used for ...
 * Class created on 17 jul. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class BuildExcelFinal {
    
    static final Logger log = LoggerFactory.getLogger(BuildExcelFinal.class);
    
    private String dateFinal = "yyMMdd";
    private String dateA = "dd/MM/yyyy";
    private String dateB = "dd-MM-yyyy";
    private String expressionRegDate = "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$";
    private String timeStampFinal = "yyMMdd HH:mm:ss";
    private String timeStampA = "dd/mm/yyyy hh:mm:ss";
    private String timeStampB = "dd-mm-yyyy hh:mm:ss";
    private String expressionRegTimeStamp = "^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})(\\s)([0-1][0-9]|2[0-3])(:)([0-5][0-9])(:)([0-5][0-9])$";
    
    private int positionDBFieldCuenta;
    private int positionDBFieldTarjeta;
    private int positionDBFieldExtra;
    
    /**
     * 
     * Constructor.
     */
    public BuildExcelFinal() {
	this.positionDBFieldCuenta=-1;
	this.positionDBFieldTarjeta=-1;
	this.positionDBFieldExtra=-1;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type boolean.
     * Method created on 13 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param pathFiles
     * @param fileName
     * @param fields
     * @param paths
     * @param factor
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public boolean processExcel(String pathFiles, String fileName, List<HashMap> fields,
	    String[] paths, int factor) {
	String pathAcceptedFiles = paths[Constantes.CERO];
	String pathRejectedFiles = paths[Constantes.UNO];
	boolean reg = false;
	HashMap<String, String> fieldsTypeDataExcel = fields.get(Constantes.CERO);
	HashMap<String, Integer> fieldLocationExcel = new MapFieldsPosition().getMapping(fieldsTypeDataExcel,
		pathFiles + fileName);
	if (fieldsTypeDataExcel.size() != fieldLocationExcel.size()) {
	    return false;
	}
	fields.add(fieldLocationExcel);
	SearchFileInFolder baec = new SearchFileInFolder();
	if (!baec.validExistenceFolder(pathAcceptedFiles)) {
	    new File(pathAcceptedFiles).mkdir();
	}
	if (!baec.validExistenceFolder(pathRejectedFiles)) {
	    new File(pathRejectedFiles).mkdir();
	}
	try (Workbook wbRead = new XSSFWorkbook(pathFiles + fileName)) {
	    this.shapeFilesCSV(fileName, fields, wbRead.getSheetAt(Constantes.CERO), paths, factor);
	    reg = true;
	} catch (Exception e) {
	    log.error(e.getMessage());
	    reg = false;
	}
	return reg;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type void.
     * Method created on 1 oct. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param pathRejectedFiles
     */
    public void procesFailed(String pathRejectedFiles) {
	SearchFileInFolder baec = new SearchFileInFolder();
	String[] existingFiles = baec.listContentsFolder(pathRejectedFiles, Constantes.EXTENSION_CSV);
	FileWriting csv = new FileWriting();
	SimpleDateFormat dateFormato = new SimpleDateFormat(Constantes.DATE_ARCHIVO);
	PrintWriter rejected = csv.openingFileWriting(String.format("%s%s%s%s", pathRejectedFiles,
		Constantes.ARCHIVOS_RECHAZADOS_FINAL, dateFormato.format(new Date()),
		Constantes.EXTENSION_CSV));
	File fileRejected = null;
	for (int i = Constantes.CERO; i < existingFiles.length; i++) {
	    fileRejected = new File(pathRejectedFiles + existingFiles[i]);
	    if (fileRejected.length() > 0) {
		try (FileReader fr = new FileReader(pathRejectedFiles + existingFiles[i]);
		    BufferedReader br = new BufferedReader(fr)){
		    String line = null;
		    while ((line = br.readLine()) != null) {
			csv.writeInFile(rejected, line);
		    }
		} catch (Exception e) {
		    //Aqui nunca debe llegar
		    HubException he = new HubException();
		    log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
		}
	    }
	    Path directory = Paths.get(pathRejectedFiles + existingFiles[i]);
	    try {
		Files.delete(directory);
	    } catch (IOException e) {
		HubException he = new HubException();
		log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	    }
	}
	csv.closedFileWrite(rejected);
    }
    
    // S O N A R    . . . . .    R E G L A    S 2 0 9 5
    //Se elimina la regla S2095 de sonar, ya que el negocio necesita que tenga un archivo de rechazados abierto
    //por cada elemento XLSX procesado.
    //Se elimina la regla S2095 de sonar, ya que el objeto que esta ligado al archivo de aceptados se debe abrir
    //y cerrar dependiendo de la cantidad de elementos a ingresar por archivo.
    // S O N A R    . . . . .    R E G L A    S 2 0 9 5
    /**
     * 
     * Method used for ...
     * Returns an object of type void.
     * Method created on 13 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param fileName
     * @param fields
     * @param sheetRead
     * @param paths
     * @param factor
     */
    @SuppressWarnings("rawtypes")
    private void shapeFilesCSV(String fileName, List<HashMap> fields, Sheet sheetRead,
	    String[] paths, int factor) {
	String bdu = "BDU";
	UUID idBdu = null;
	String pathAcceptedFiles = paths[Constantes.CERO];
	String pathRejectedFiles = paths[Constantes.UNO];
	SimpleDateFormat dateFormato = new SimpleDateFormat(Constantes.DATE_ARCHIVO);
	FileWriting csv = new FileWriting();
	PrintWriter accepted = null;
	PrintWriter rejected = null;
	int row = Constantes.UNO;
	int countAccepted = Constantes.CERO;
	accepted = csv.openingFileWriting(String.format("%s%s%s_%010d%s", pathAcceptedFiles,
		fileName.replaceAll(Constantes.EXTENSION_XLSX, ""), dateFormato.format(new Date()), countAccepted,
		Constantes.EXTENSION_CSV));
	rejected = csv.openingFileWriting(String.format("%s%s%s_%010d%s", pathRejectedFiles,
		fileName.replaceAll(Constantes.EXTENSION_XLSX, ""), dateFormato.format(new Date()), countAccepted,
		Constantes.EXTENSION_CSV));
	boolean isBDU = pathAcceptedFiles.toUpperCase().contains(bdu);
	while (row < sheetRead.getPhysicalNumberOfRows()) {
	    if (countAccepted > Constantes.UNO && (countAccepted % Math.pow(Constantes.DIEZ, factor) == Constantes.UNO)) {
		csv.closedFileWrite(accepted);
		accepted = csv.openingFileWriting(String.format("%s%s%s_%010d%s", pathAcceptedFiles,
			fileName.replaceAll(Constantes.EXTENSION_XLSX, ""), dateFormato.format(new Date()),
			countAccepted, Constantes.EXTENSION_CSV));
	    }
	    try {
		if(!isBDU) {
		    csv.writeInFile(accepted, this.processRegistration(this.transformsFields(fields, sheetRead, row)));
		} else {
		    idBdu = UUID.randomUUID();
		    csv.writeInFile(accepted, idBdu.toString()+Constantes.DELIMITADOR+this.processRegistration(this.transformsFields(fields, sheetRead, row)));
		}
	    } catch (Exception e) {
		csv.writeInFile(rejected,
			this.processRegistration(this.getLinkExcel(fields, sheetRead, row)));
		log.error(e.getMessage(), e);
	    }
	    countAccepted++;
	    row++;
	}
	csv.closedFileWrite(accepted);
	csv.closedFileWrite(rejected);
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type Object[].
     * Method created on 13 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param fields
     * @param hojaLectura
     * @param fila
     * @return
     * @throws HubException 
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private Object[] transformsFields(List<HashMap> fields, Sheet hojaLectura, int fila) throws Exception{
	Cell cell = null;
	DataFormatter dataFormatter = new DataFormatter();
	HashMap<String, String> mapBDExcel = fields.get(Constantes.UNO);
	HashMap<Integer, String> positionFieldBD = fields.get(Constantes.DOS);
	HashMap<String, Integer> fieldLocationExcel = fields.get(Constantes.TRES);
	Object[] renglon = new Object[positionFieldBD.size()];
	HashMap<Integer, String> mapTypes = this.getTypesData(fields);
	for (int i = Constantes.CERO; i < positionFieldBD.size(); i++) {
	    cell = hojaLectura.getRow(fila)
		    .getCell(fieldLocationExcel.get(mapBDExcel.get(positionFieldBD.get(i))));
	    if(cell==null) {
		renglon[i] = "";
	    }else if(Constantes.CERO==cell.toString().length()) {
		renglon[i] = "";
	    } else if (Constantes.TIPO_FECHA.equalsIgnoreCase(mapTypes.get(i))) {
		renglon[i] = this.formatDate(cell);
	    } else if (Constantes.TIPO_TIMESTAMP.equalsIgnoreCase(mapTypes.get(i))) {
		renglon[i] = this.formatTimestamp(cell);
	    } else if (Constantes.TIPO_HORA.equalsIgnoreCase(mapTypes.get(i))) {
		ConverterHours convertidorHoras = new ConverterHours();
		renglon[i] = convertidorHoras.getFormat24Hrs(cell);
	    } else if(i==this.positionDBFieldCuenta) {
		positionDBFieldCuenta++;
		//falta conocer un patron definido de una cuenta
	    } else if(i==this.positionDBFieldTarjeta || i==this.positionDBFieldExtra) {
		renglon[i] = this.reviewCard(cell.toString());
	    } else {
		
		renglon[i] = this.checkContent(dataFormatter.formatCellValue(cell), cell);
		//Valida si el campo realmente es numerico, de lo contrario lanza excepcion para que el registro sea enviado a los fallidos
		if(renglon[i]!=null && !renglon[i].toString().trim().isEmpty() && Constantes.TIPO_ENTERO.equalsIgnoreCase(mapTypes.get(i))) {
		    Double doubleCheck = new Double(renglon[i].toString());
		}
	    }
	}
	return renglon;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type Object.
     * Method created on 1 oct. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param cell
     * @return
     */
    private Object formatDate(Cell cell) {
	Object reg = "";
	SimpleDateFormat formato = new SimpleDateFormat(dateFinal);
	Date dateAux = null;
	try {
	    reg = formato.format(cell.getDateCellValue());
	} catch (Exception ex) {
	    String fecha = cell.getStringCellValue();
	    try {
		Pattern pat = Pattern.compile(expressionRegDate);
		Matcher mat = pat.matcher(fecha);
		if (fecha.length() == Constantes.SEIS) {
		    dateAux = new SimpleDateFormat(dateFinal).parse(fecha);
		    reg = formato.format(dateAux);
		} else if (mat.matches()) {
		    String diagonal = "/";
		    dateAux = new SimpleDateFormat(fecha.contains(diagonal) ? dateA : dateB).parse(fecha);
		    reg = formato.format(dateAux);
		} else {
		    // aqui van los otros formatos de fecha
		}
	    } catch (ParseException e) {
		// No debe llegar nunca aqui.
		HubException he = new HubException();
		log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
	    }
	}
	return reg;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type Object.
     * Method created on 1 oct. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param cell
     * @return
     */
    private Object formatTimestamp(Cell cell) {
	Object reg = "";
	SimpleDateFormat formato = new SimpleDateFormat(timeStampFinal);
	try {
	    reg = formato.format(cell.getDateCellValue());
	} catch (Exception ex) {
	    String fecha = cell.getStringCellValue();
	    Pattern pat = Pattern.compile(expressionRegTimeStamp);
	    Matcher mat = pat.matcher(fecha);
	    if (mat.matches()) {
		Date dateAux = null;
		try {
		    dateAux = new SimpleDateFormat(timeStampA).parse(fecha);
		} catch (ParseException e) {
		    try {
			dateAux = new SimpleDateFormat(timeStampB).parse(fecha);
		    } catch (ParseException e1) {
			// No debe llegar nunca aqui.
			HubException he = new HubException();
			log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
		    }
		}
		 reg = formato.format(dateAux);
	    }
	}
	return reg;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type String.
     * Method created on 13 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param car
     * @return
     * @throws HubException
     */
    private String reviewCard(String car) throws HubException {
	String reg = null;
	if (Constantes.CERO == car.length()) {
	    reg = car;
	} else {
	    StringBuilder newCard = new StringBuilder();
	    char[] elements = car.toCharArray();
	    int countNum = Constantes.CERO;
	    for (char element : elements) {
		if ((int) element > Constantes.CUARENTA_Y_SIETE && (int) element < Constantes.CINCUENTA_Y_OCHO) {
		    newCard.append(element);
		    countNum++;
		} else if (countNum > Constantes.SIETE && countNum < Constantes.DOCE) {
		    newCard.append(element);
		}
	    }
	    if(newCard.length()==Constantes.DIECISEIS) {
		reg = newCard.toString();
	    } else {
		throw new HubException("La tarjeta enviada no es valida.");
	    }
	}
	return reg;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type Object[].
     * Method created on 13 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param fields
     * @param hojaLectura
     * @param fila
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private Object[] getLinkExcel(List<HashMap> fields, Sheet hojaLectura, int fila) {
	Cell cell = null;
	HashMap<String, String> mapBDExcel = fields.get(Constantes.UNO);
	HashMap<Integer, String> positionFieldBD = fields.get(Constantes.DOS);
	HashMap<String, Integer> fieldLocationExcel = fields.get(Constantes.TRES);
	Object[] row = new Object[positionFieldBD.size()];
	for (int i = Constantes.CERO; i < positionFieldBD.size(); i++) {
	    cell = hojaLectura.getRow(fila)
		    .getCell(fieldLocationExcel.get(mapBDExcel.get(positionFieldBD.get(i))));
	    row[i] = cell==null? "" : cell.toString();
	}
	return row;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type HashMap<Integer,String>.
     * Method created on 13 sep. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param fields
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private HashMap<Integer, String> getTypesData(List<HashMap> fields){
	HashMap<String, String> fieldTypeExcel = fields.get(Constantes.CERO);
	HashMap<String, String> mapBDExcel = fields.get(Constantes.UNO);
	HashMap<Integer, String> positionFieldBD = fields.get(Constantes.DOS);
	HashMap<Integer, String> types = new HashMap<>();
	for(int i=Constantes.CERO; i<positionFieldBD.size(); i++) {
	    String local = positionFieldBD.get(i);
	    local = mapBDExcel.get(local);
	    local = fieldTypeExcel.get(local);
	    types.put(i, local);
	}
	return types;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type String.
     * Method created on 18 jul. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param content
     * @param cell
     * @return
     */
    private String checkContent(String content, Cell cell) {
	String newCell = "";
	if (cell != null && cell.getCellType().toString().equalsIgnoreCase(Constantes.ESFORMULA)) {
	    try {
		newCell = cell.getStringCellValue();
	    } catch (Exception e) {
		newCell = Double.toString(cell.getNumericCellValue());
		if (newCell.endsWith(Constantes.PUNTO_CERO_UNO) || newCell.endsWith(Constantes.PUNTO_CERO_DOS)
			|| newCell.endsWith(Constantes.PUNTO_CERO_TRES)) {
		    newCell = newCell.substring(Constantes.CERO, newCell.lastIndexOf('.'));
		}
	    }
	} else {
	    newCell = content;
	}
	return newCell;
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type String.
     * Method created on 19 jul. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param registry
     * @return
     */
    private String processRegistration(Object[] registry) {
	StringBuilder line = new StringBuilder();
	for (Object data : registry) {
	    line.append(data.toString().replaceAll("\\|", ","));
	    line.append(Constantes.DELIMITADOR);
	}
	//log.info("Procesando: " + line.toString());
	return line.substring(Constantes.CERO, line.length() - Constantes.UNO);
    }

    public void setPositionDBFieldCuenta(int positionDBFieldCuenta) {
        this.positionDBFieldCuenta = positionDBFieldCuenta;
    }

    public void setPositionDBFieldTarjeta(int positionDBFieldTarjeta) {
        this.positionDBFieldTarjeta = positionDBFieldTarjeta;
    }

    public void setPositionDBFieldExtra(int positionDBFieldExtra) {
        this.positionDBFieldExtra = positionDBFieldExtra;
    }
    
}

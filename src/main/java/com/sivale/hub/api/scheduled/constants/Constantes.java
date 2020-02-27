/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.constants;

/**
 * Description: This class is used for ...
 * Class created on 17 jul. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class Constantes {
    
    private Constantes() {
	
    }

    public static final String TEMPORAL = "_TMP";
    public static final String BD = "_BD";
    public static final String EXTENSION_XLS = ".xls";
    public static final String EXTENSION_XLSX = ".xlsx";
    public static final String EXTENSION_TXT = ".txt";
    public static final String EXTENSION_CSV = ".csv";
    public static final String EXTENSION_EON = ".eon";
    public static final String SEPARADOR_WIN = "\\";
    public static final String SEPARADOR_OTROS = "/";
    public static final String PUNTO = "\\.";
    public static final String ESFORMULA = "FORMULA";
    public static final String ESSTRING = "STRING";
    public static final String ESNUMERIC = "NUMERIC";
    public static final String UTF8 = "UTF-8";
    public static final String ACEPTADOS = "paraBD";
    public static final String RECHAZADOS = "noInsertados";
    public static final String ARCHIVOS_RECHAZADOS_FINAL = "Failed_";
    public static final String ARCHIVO_SUBPROCESADO = "%sarchivoSubProcesado%010d_%010d_%010d.csv";
    public static final String QUERYPOSTGRES = "COPY %s(%s) FROM STDIN DELIMITER '%s' CSV";
    public static final String QUERYPOSTGRESDELETE = "DELETE FROM %s WHERE 1=1";
    public static final String QUERYPOSTGRESINSERT = "INSERT INTO bitacorajob VALUES('%s', '%s', '%s', '%s', '%s')";
    public static final String CORRECTO = "Correcto";
    public static final String ERROR = "Error";
    public static final String DATE_ARCHIVO = "yyyyMMdd";
    public static final String DATE_DATO = "yyMMdd";
    public static final String FILE_C = "pythonRun.exe";
    public static final String FILE_PYTHON = "divisorDeArchivo.py";
    public static final char COMA = ',';
    public static final char DELIMITADOR = '|';
    public static final int BYTES = 1024;
    public static final int DOS_NEG = -2;
    public static final int UNO_NEG = -1;
    public static final int CERO = 0;
    public static final int UNO = 1;
    public static final int DOS = 2;
    public static final int TRES = 3;
    public static final int CUATRO = 4;
    public static final int CINCO = 5;
    public static final int SEIS = 6;
    public static final int SIETE = 7;
    public static final int OCHO = 8;
    public static final int NUEVE = 9;
    public static final int DIEZ = 10;
    public static final int ONCE = 11;
    public static final int DOCE = 12;
    public static final int TRECE = 13;
    public static final int DIECISEIS = 16;
    public static final int DIECIOCHO = 18;
    public static final int DIECINUEVE = 19;
    public static final int CUARENTA_Y_SIETE = 47;
    public static final int CINCUENTA_Y_OCHO = 58;
    public static final int MIL = 1000;
    public static final int CINCO_MIL = 5000;
    public static final int UN_MINUTO = 60000;
    public static final int UN_MINUTO_Y_MEDIO = 9000;
    public static final int TRES_MINUTOS = 180000;
    public static final String TIPO_ENTERO = "Integer";
    public static final String TIPO_FECHA = "Date";
    public static final String TIPO_DINERO = "Money";
    public static final String TIPO_TIMESTAMP = "Timestamp";
    public static final String TIPO_HORA = "Time";
    public static final String PUNTO_CERO_UNO = ".0";
    public static final String PUNTO_CERO_DOS = ".00";
    public static final String PUNTO_CERO_TRES = ".000";

}

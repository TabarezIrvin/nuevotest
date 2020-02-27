/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.constants;

/**
 * Description: This class is used for ...
 * Class created on 12 ago. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class ConstantesMensajes {
    
    private ConstantesMensajes () {
	
    }
    
    public static final String RUTA_ORIGEN = "La ruta \"%s\" indicada como origen no existe.";
    public static final String RUTA_DESTINO = "La ruta \"%s\" indicada como destino no existe.";
    public static final String ARCHIVO = "No existe un archivo valido (XLSX) para poder agregar a la tabla \"%s\"";
    public static final String ERROR_MOVER = "El archivo %s no pudo ser colocado en su detino final.";
    public static final String ERROR_BD = "La tabla \"%s\" no existe o se perdio la conexión a la base de datos.";    
    public static final String ERROR = "Error desconocido";
    public static final String LOG_INICIO = "Se inicio el proceso (carga masiva) para {0}";
    public static final String LOG_FIN = "El proceso (carga masiva para {0} termino con un tiempo de {1}";
    
    
}

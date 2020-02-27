/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.exception;

/**
 * Description: This class is used for ...
 * Class created on 9 sep. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class HubException extends Exception {
    
    /**
     * Attribute type long created on 9 sep. 2019, used for ...
     */
    private static final long serialVersionUID = -2834370288436879458L;
    
    /**
     * 
     * Constructor.
     */
    public HubException () {
	super();
    }
    
    /**
     * 
     * Constructor.
     * @param msg
     */
    public HubException (String msg) {
	super(msg);
    }
    
    /**
     * 
     * Method used for ...
     * Returns an object of type String.
     * Method created on 1 oct. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param originalTrace
     * @return
     */
    public String imprimeErrorExcepcion(StackTraceElement[] originalTrace) {
	StringBuilder excepcionEscuchada = new StringBuilder();
	for (StackTraceElement ste : originalTrace) {
	    excepcionEscuchada.append(ste);
	    excepcionEscuchada.append("\n");
	}
	return excepcionEscuchada.toString();
    }
    
}

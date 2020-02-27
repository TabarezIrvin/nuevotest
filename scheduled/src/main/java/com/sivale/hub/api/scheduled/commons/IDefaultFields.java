/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.commons;

import java.util.HashMap;

/**
 * Description: This class is used for ...
 * Class created on 15 ago. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public interface IDefaultFields {
    
    /**
     * 
     * Method used for ...
     * Returns an object of type HashMap<String,String>.
     * Method created on 15 ago. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @return
     */
    public HashMap<String, String> fieldTypeExcel();
    
    /**
     * 
     * Method used for ...
     * Returns an object of type HashMap<string,String>.
     * Method created on 16 ago. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @return
     */
    public HashMap<String, String> mappingDBExcel();
    
    /**
     * 
     * Method used for ...
     * Returns an object of type HashMap<Integer,String>.
     * Method created on 15 ago. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @return
     */
    public HashMap<Integer, String> positionFieldBD();
    
}

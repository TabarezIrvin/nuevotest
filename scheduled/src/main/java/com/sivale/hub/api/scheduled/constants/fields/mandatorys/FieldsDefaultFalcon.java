/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.constants.fields.mandatorys;

import java.util.HashMap;

import com.sivale.hub.api.scheduled.commons.IDefaultFields;

/**
 * Description: This class is used for ...
 * Class created on 17 sep. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class FieldsDefaultFalcon implements IDefaultFields {

    @Override
    public HashMap<String, String> fieldTypeExcel() {
	HashMap<String, String> mandatory = new HashMap<>();
	mandatory.put("ID de usuario", "String");
	mandatory.put("Fecha", "Date");
	mandatory.put("Hora", "Time");
	mandatory.put("Case Status Type", "String");
	mandatory.put("Lista", "String");
	mandatory.put("Tipo de caso", "String");
	mandatory.put("Cuenta", "Integer");
	mandatory.put("Estado del caso", "String");
	mandatory.put("Número de caso", "Integer");
	mandatory.put("Acciones", "String");
	mandatory.put("Número de caso 2", "String");
	return mandatory;
    }

    @Override
    public HashMap<String, String> mappingDBExcel() {
	HashMap<String, String> relationship = new HashMap<>();
	relationship.put("IDUsuario", "ID de usuario");
	relationship.put("Fecha", "Fecha");
	relationship.put("Hora", "Hora");
	relationship.put("Status", "Case Status Type");
	relationship.put("Lista", "Lista");
	relationship.put("TipoCaso", "Tipo de caso");
	relationship.put("Cuenta", "Cuenta");
	relationship.put("Estado_Del_Caso", "Estado del caso");
	relationship.put("Numero_De_Caso", "Número de caso");
	relationship.put("Acciones", "Acciones");
	relationship.put("Numero_De_Caso_2", "Número de caso 2");
	return relationship;
    }

    @Override
    public HashMap<Integer, String> positionFieldBD() {
	HashMap<Integer, String> position = new HashMap<>();
	position.put(0, "IDUsuario");
	position.put(1, "Fecha");
	position.put(2, "Hora");
	position.put(3, "Status");
	position.put(4, "Lista");
	position.put(5, "TipoCaso");
	position.put(6, "Cuenta");
	position.put(7, "Estado_Del_Caso");
	position.put(8, "Numero_De_Caso");
	position.put(9, "Acciones");
	position.put(10, "Numero_De_Caso_2");
	return position;
    }
    
}

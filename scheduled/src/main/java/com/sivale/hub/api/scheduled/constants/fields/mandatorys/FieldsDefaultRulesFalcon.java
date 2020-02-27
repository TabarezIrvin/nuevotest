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
 * Class created on 29 ago. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class FieldsDefaultRulesFalcon implements IDefaultFields {

    @Override
    public HashMap<String, String> fieldTypeExcel() {
	HashMap<String, String> mandatory = new HashMap<>();
	mandatory.put("Regla", "String");
	mandatory.put("Decisión", "String");
	mandatory.put("Cuenta", "Integer");
	mandatory.put("ID de transacción", "String");
	mandatory.put("Fecha", "Date");
	mandatory.put("Hora", "Time");
	mandatory.put("Modo", "String");
	mandatory.put("Banco", "String");
	return mandatory;
    }

    @Override
    public HashMap<String, String> mappingDBExcel() {
	HashMap<String, String> relationship = new HashMap<>();
	relationship.put("Regla", "Regla");
	relationship.put("Decision", "Decisión");
	relationship.put("Cuenta", "Cuenta");
	relationship.put("IDTransaccion", "ID de transacción");
	relationship.put("Fecha", "Fecha");
	relationship.put("Hora", "Hora");
	relationship.put("Modo", "Modo");
	relationship.put("Banco", "Banco");
	return relationship;
    }

    @Override
    public HashMap<Integer, String> positionFieldBD() {
	HashMap<Integer, String> position = new HashMap<>();
	position.put(0, "Regla");
	position.put(1, "Decision");
	position.put(2, "Cuenta");
	position.put(3, "IDTransaccion");
	position.put(4, "Fecha");
	position.put(5, "Hora");
	position.put(6, "Modo");
	position.put(7, "Banco");
	return position;
    }

}

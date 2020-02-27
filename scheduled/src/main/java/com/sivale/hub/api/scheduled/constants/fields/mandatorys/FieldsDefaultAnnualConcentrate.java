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
 * Class created on 13 sep. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class FieldsDefaultAnnualConcentrate implements IDefaultFields {

    @Override
    public HashMap<String, String> fieldTypeExcel() {
	HashMap<String, String> mandatory = new HashMap<>();
	mandatory.put("CC", "String");
	mandatory.put("BIN", "Integer");
	mandatory.put("PRODUCTO", "String");
	mandatory.put("MES TRXN", "Date");
	mandatory.put("AÑO TRXN", "Integer");
	mandatory.put("FECHA DE PAGO", "Date");
	mandatory.put("SEMANAS", "String");
	mandatory.put("CUENTA", "Integer");
	mandatory.put("TARJETA", "String");
	mandatory.put("CUENTA NUEVA", "Integer");
	mandatory.put("TARJETA NUEVA", "String");
	mandatory.put("MONTO", "Money");
	mandatory.put("CODIGOMOVIMIENTO", "Integer");
	mandatory.put("DESCMOVIMIENTO", "String");
	mandatory.put("FECHATXN", "Date");
	mandatory.put("HORA", "Time");
	mandatory.put("AUTORIZACION", "Integer");
	mandatory.put("AFILIACION", "Integer");
	mandatory.put("NOMBRECOMERCIO", "String");
	mandatory.put("IDGIRO", "Integer");
	mandatory.put("PAIS", "String");
	mandatory.put("MONEDA", "Integer");
	mandatory.put("PEM", "Integer");
	mandatory.put("TAREA", "Integer");
	mandatory.put("SOLICITANTE", "Integer");
	mandatory.put("Considerar", "String");
	return mandatory;
    }

    @Override
    public HashMap<String, String> mappingDBExcel() {
	HashMap<String, String> relationship = new HashMap<>();
	relationship.put("CC", "CC");
	relationship.put("BIN", "BIN");
	relationship.put("PRODUCTO", "PRODUCTO");
	relationship.put("MES_TRXN", "MES TRXN");
	relationship.put("ANIO_TRXN", "AÑO TRXN");
	relationship.put("FECHA_PAGO", "FECHA DE PAGO");
	relationship.put("SEMANAS", "SEMANAS");
	relationship.put("CUENTA", "CUENTA");
	relationship.put("TARJETA", "TARJETA");
	relationship.put("CUENTA_NUEVA", "CUENTA NUEVA");
	relationship.put("TARJETA_NUEVA", "TARJETA NUEVA");
	relationship.put("MONTO", "MONTO");
	relationship.put("CODIGOMOVIMIENTO", "CODIGOMOVIMIENTO");
	relationship.put("DESCMOVIMIENTO", "DESCMOVIMIENTO");
	relationship.put("FECHATXN", "FECHATXN");
	relationship.put("HORA", "HORA");
	relationship.put("AUTORIZACION", "AUTORIZACION");
	relationship.put("AFILIACION", "AFILIACION");
	relationship.put("NOMBRECOMERCIO", "NOMBRECOMERCIO");
	relationship.put("IDGIRO", "IDGIRO");
	relationship.put("PAIS", "PAIS");
	relationship.put("MONEDA", "MONEDA");
	relationship.put("PEM", "PEM");
	relationship.put("TAREA", "TAREA");
	relationship.put("SOLICITANTE", "SOLICITANTE");
	relationship.put("Considerar", "Considerar");
	return relationship;
    }

    @Override
    public HashMap<Integer, String> positionFieldBD() {
	HashMap<Integer, String> position = new HashMap<>();
	position.put(0, "CC");
	position.put(1, "BIN");
	position.put(2, "PRODUCTO");
	position.put(3, "MES_TRXN");
	position.put(4, "ANIO_TRXN");
	position.put(5, "FECHA_PAGO");
	position.put(6, "SEMANAS");
	position.put(7, "CUENTA");
	position.put(8, "TARJETA");
	position.put(9, "CUENTA_NUEVA");
	position.put(10, "TARJETA_NUEVA");
	position.put(11, "MONTO");
	position.put(12, "CODIGOMOVIMIENTO");
	position.put(13, "DESCMOVIMIENTO");
	position.put(14, "FECHATXN");
	position.put(15, "HORA");
	position.put(16, "AUTORIZACION");
	position.put(17, "AFILIACION");
	position.put(18, "NOMBRECOMERCIO");
	position.put(19, "IDGIRO");
	position.put(20, "PAIS");
	position.put(21, "MONEDA");
	position.put(22, "PEM");
	position.put(23, "TAREA");
	position.put(24, "SOLICITANTE");
	position.put(25, "Considerar");
	return position;
    }

}

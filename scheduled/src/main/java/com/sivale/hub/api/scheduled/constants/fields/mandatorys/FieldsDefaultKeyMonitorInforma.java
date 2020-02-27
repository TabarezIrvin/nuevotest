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
 * Class created on 27 sep. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class FieldsDefaultKeyMonitorInforma implements IDefaultFields {

    @Override
    public HashMap<String, String> fieldTypeExcel() {
	HashMap<String, String> mandatory = new HashMap<>();
	mandatory.put("Num", "String");
	mandatory.put("Usuario", "String");
	mandatory.put("LayOut", "String");
	mandatory.put("Formato", "String");
	mandatory.put("Aplicación", "String");
	mandatory.put("Tipo Reg", "String");
	mandatory.put("IP", "String");
	mandatory.put("Fecha", "Date");
	mandatory.put("Hora", "Time");
	mandatory.put("Sesion", "String");
	mandatory.put("Filtro", "String");
	mandatory.put("Mensaje", "String");
	mandatory.put("Estado", "String");
	mandatory.put("Referencia", "String");
	mandatory.put("Condición", "String");
	mandatory.put("Usuario Atn", "String");
	mandatory.put("Estado Observ.", "String");
	mandatory.put("Fecha atn", "Date");
	mandatory.put("Hora atn", "Time");
	mandatory.put("Tarjeta", "String");
	return mandatory;
    }

    @Override
    public HashMap<String, String> mappingDBExcel() {
	HashMap<String, String> relationship = new HashMap<>();
	relationship.put("Num", "Num");
	relationship.put("Usuario", "Usuario");
	relationship.put("LayOut", "LayOut");
	relationship.put("Formato", "Formato");
	relationship.put("Aplicacion", "Aplicación");
	relationship.put("Tipo_Reg", "Tipo Reg");
	relationship.put("IP", "IP");
	relationship.put("Fecha", "Fecha");
	relationship.put("Hora", "Hora");
	relationship.put("Sesion", "Sesion");
	relationship.put("Filtro", "Filtro");
	relationship.put("Mensaje", "Mensaje");
	relationship.put("Estado", "Estado");
	relationship.put("Referencia", "Referencia");
	relationship.put("Condicion", "Condición");
	relationship.put("Usuario_Atn", "Usuario Atn");
	relationship.put("Estado_Observ", "Estado Observ.");
	relationship.put("Fecha_atn", "Fecha atn");
	relationship.put("Hora_atn", "Hora atn");
	relationship.put("Tarjeta", "Tarjeta");
	return relationship;
    }

    @Override
    public HashMap<Integer, String> positionFieldBD() {
	HashMap<Integer, String> position = new HashMap<>();
	position.put(0, "Num");
	position.put(1, "Usuario");
	position.put(2, "LayOut");
	position.put(3, "Formato");
	position.put(4, "Aplicacion");
	position.put(5, "Tipo_Reg");
	position.put(6, "IP");
	position.put(7, "Fecha");
	position.put(8, "Hora");
	position.put(9, "Sesion");
	position.put(10, "Filtro");
	position.put(11, "Mensaje");
	position.put(12, "Estado");
	position.put(13, "Referencia");
	position.put(14, "Condicion");
	position.put(15, "Usuario_Atn");
	position.put(16, "Estado_Observ");
	position.put(17, "Fecha_atn");
	position.put(18, "Hora_atn");
	position.put(19, "Tarjeta");
	return position;
    }

}

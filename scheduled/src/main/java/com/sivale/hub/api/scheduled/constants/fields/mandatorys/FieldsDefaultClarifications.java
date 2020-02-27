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
public class FieldsDefaultClarifications implements IDefaultFields {

    @Override
    public HashMap<String, String> fieldTypeExcel() {
	HashMap<String, String> mandatory = new HashMap<>();
	mandatory.put("TAREA", "Integer");
	mandatory.put("MES", "String");
	mandatory.put("FECHA INGRESO SAC", "Date");
	mandatory.put("FECHA DEL FORMATO", "Date");
	mandatory.put("CUENTA", "String");
	mandatory.put("TARJETA", "String");
	mandatory.put("NUEVA TARJETA", "String");
	mandatory.put("EMPLEADO", "String");
	mandatory.put("NOMBRE DEL CLIENTE", "String");
	mandatory.put("CLAVE CLIENTE", "String");
	mandatory.put("PRODUCTO", "String");
	mandatory.put("MONTO", "Money");
	mandatory.put("NUM MOVIMIENTO", "Integer");
	mandatory.put("MONTO TOTAL", "Money");
	mandatory.put("FECHA TXN", "Date");
	mandatory.put("HORA", "Time");
	mandatory.put("AUTH", "Integer");
	mandatory.put("MCC", "Integer");
	mandatory.put("PEM", "Integer");
	mandatory.put("CANAL DE TRANSACCION", "String");
	mandatory.put("TERMINAL", "Integer");
	mandatory.put("SERVICIO", "String");
	mandatory.put("NOMBRE COMERCIO", "String");
	mandatory.put("AFILIACION", "String");
	mandatory.put("ADQ", "String");
	mandatory.put("REFERENCIA", "String");
	mandatory.put("FOLIO", "Integer");
	mandatory.put("APLICACION", "String");
	mandatory.put("FECHA DE INGRESO PROSA", "Date");
	mandatory.put("CP", "String");
	mandatory.put("CIUDAD", "String");
	mandatory.put("N SAFE", "Integer");
	mandatory.put("N VISA", "Integer");
	mandatory.put("RECLASIFICACION", "String");
	mandatory.put("MOTIVO", "String");
	mandatory.put("CAUSA RECLAMACION", "String");
	mandatory.put("FDE POTENCIAL", "Money");
	mandatory.put("MTO PROTEGIDO", "Money");
	mandatory.put("MTO ANTICIPADO", "Money");
	mandatory.put("MTO RECHAZADO", "Money");
	mandatory.put("MTO RECUPERADO", "Money");
	mandatory.put("QUEB SERVICIO", "Money");
	mandatory.put("TRMT QUEBRANTO", "Money");
	mandatory.put("MTO QUEBRANTO", "Money");
	mandatory.put("TIPO FRAUDE", "String");
	mandatory.put("FECHA DICTAMEN", "Date");
	mandatory.put("DICTAMINO", "String");
	mandatory.put("ESTADO", "String");
	mandatory.put("CONCLUSION", "String");
	mandatory.put("FECHA ABONO", "Date");
	mandatory.put("CP FOLIO ABONO", "String");
	mandatory.put("OBSERVACIONES", "String");
	mandatory.put("TIPO CARTA", "String");
	mandatory.put("ESTATUS FRAUDE", "String");
	mandatory.put("DICTAMEN", "String");
	mandatory.put("MONTO ABONO", "Money");
	mandatory.put("CAUSA RESOLUCION", "String");
	return mandatory;
    }

    @Override
    public HashMap<String, String> mappingDBExcel() {
	HashMap<String, String> relationship = new HashMap<>();
	relationship.put("TAREA", "TAREA");
	relationship.put("MES", "MES");
	relationship.put("FECHA_INGRESO_SAC", "FECHA INGRESO SAC");
	relationship.put("FECHA_DEL_FORMATO", "FECHA DEL FORMATO");
	relationship.put("CUENTA", "CUENTA");
	relationship.put("TARJETA", "TARJETA");
	relationship.put("NUEVA_TARJETA", "NUEVA TARJETA");
	relationship.put("EMPLEADO", "EMPLEADO");
	relationship.put("NOMBRE_DEL_CLIENTE", "NOMBRE DEL CLIENTE");
	relationship.put("CLAVE_CLIENTE", "CLAVE CLIENTE");
	relationship.put("PRODUCTO", "PRODUCTO");
	relationship.put("MONTO", "MONTO");
	relationship.put("NUM_MOVIMIENTO", "NUM MOVIMIENTO");
	relationship.put("MONTO_TOTAL", "MONTO TOTAL");
	relationship.put("FECHA_TXN", "FECHA TXN");
	relationship.put("HORA", "HORA");
	relationship.put("AUTH", "AUTH");
	relationship.put("MCC", "MCC");
	relationship.put("PEM", "PEM");
	relationship.put("CANAL_DE_TRANSACCION", "CANAL DE TRANSACCION");
	relationship.put("TERMINAL", "TERMINAL");
	relationship.put("SERVICIO", "SERVICIO");
	relationship.put("NOMBRE_COMERCIO", "NOMBRE COMERCIO");
	relationship.put("AFILIACION", "AFILIACION");
	relationship.put("ADQ", "ADQ");
	relationship.put("REFERENCIA", "REFERENCIA");
	relationship.put("FOLIO", "FOLIO");
	relationship.put("APLICACION", "APLICACION");
	relationship.put("FECHA_DE_INGRESO_PROSA", "FECHA DE INGRESO PROSA");
	relationship.put("CP", "CP");
	relationship.put("CIUDAD", "CIUDAD");
	relationship.put("N_SAFE", "N SAFE");
	relationship.put("N_VISA", "N VISA");
	relationship.put("RECLASIFICACION", "RECLASIFICACION");
	relationship.put("MOTIVO", "MOTIVO");
	relationship.put("CAUSA_RECLAMACION", "CAUSA RECLAMACION");
	relationship.put("FDE_POTENCIAL", "FDE POTENCIAL");
	relationship.put("MTO_PROTEGIDO", "MTO PROTEGIDO");
	relationship.put("MTO_ANTICIPADO", "MTO ANTICIPADO");
	relationship.put("MTO_RECHAZADO", "MTO RECHAZADO");
	relationship.put("MTO_RECUPERADO", "MTO RECUPERADO");
	relationship.put("QUEB_SERVICIO", "QUEB SERVICIO");
	relationship.put("TRMT_QUEBRANTO", "TRMT QUEBRANTO");
	relationship.put("MTO_QUEBRANTO", "MTO QUEBRANTO");
	relationship.put("TIPO_FRAUDE", "TIPO FRAUDE");
	relationship.put("FECHA_DICTAMEN", "FECHA DICTAMEN");
	relationship.put("DICTAMINO", "DICTAMINO");
	relationship.put("ESTADO", "ESTADO");
	relationship.put("CONCLUSION", "CONCLUSION");
	relationship.put("FECHA_ABONO", "FECHA ABONO");
	relationship.put("CP_FOLIO_ABONO", "CP FOLIO ABONO");
	relationship.put("OBSERVACIONES", "OBSERVACIONES");
	relationship.put("TIPO_CARTA", "TIPO CARTA");
	relationship.put("ESTATUS_FRAUDE", "ESTATUS FRAUDE");
	relationship.put("DICTAMEN", "DICTAMEN");
	relationship.put("MONTO_ABONO", "MONTO ABONO");
	relationship.put("CAUSA_RESOLUCION", "CAUSA RESOLUCION");
	return relationship;
    }

    @Override
    public HashMap<Integer, String> positionFieldBD() {
	HashMap<Integer, String> position = new HashMap<>();
	position.put(0, "TAREA");
	position.put(1, "MES");
	position.put(2, "FECHA_INGRESO_SAC");
	position.put(3, "FECHA_DEL_FORMATO");
	position.put(4, "CUENTA");
	position.put(5, "TARJETA");
	position.put(6, "NUEVA_TARJETA");
	position.put(7, "EMPLEADO");
	position.put(8, "NOMBRE_DEL_CLIENTE");
	position.put(9, "CLAVE_CLIENTE");
	position.put(10, "PRODUCTO");
	position.put(11, "MONTO");
	position.put(12, "NUM_MOVIMIENTO");
	position.put(13, "MONTO_TOTAL");
	position.put(14, "FECHA_TXN");
	position.put(15, "HORA");
	position.put(16, "AUTH");
	position.put(17, "MCC");
	position.put(18, "PEM");
	position.put(19, "CANAL_DE_TRANSACCION");
	position.put(20, "TERMINAL");
	position.put(21, "SERVICIO");
	position.put(22, "NOMBRE_COMERCIO");
	position.put(23, "AFILIACION");
	position.put(24, "ADQ");
	position.put(25, "REFERENCIA");
	position.put(26, "FOLIO");
	position.put(27, "APLICACION");
	position.put(28, "FECHA_DE_INGRESO_PROSA");
	position.put(29, "CP");
	position.put(30, "CIUDAD");
	position.put(31, "N_SAFE");
	position.put(32, "N_VISA");
	position.put(33, "RECLASIFICACION");
	position.put(34, "MOTIVO");
	position.put(35, "CAUSA_RECLAMACION");
	position.put(36, "FDE_POTENCIAL");
	position.put(37, "MTO_PROTEGIDO");
	position.put(38, "MTO_ANTICIPADO");
	position.put(39, "MTO_RECHAZADO");
	position.put(40, "MTO_RECUPERADO");
	position.put(41, "QUEB_SERVICIO");
	position.put(42, "TRMT_QUEBRANTO");
	position.put(43, "MTO_QUEBRANTO");
	position.put(44, "TIPO_FRAUDE");
	position.put(45, "FECHA_DICTAMEN");
	position.put(46, "DICTAMINO");
	position.put(47, "ESTADO");
	position.put(48, "CONCLUSION");
	position.put(49, "FECHA_ABONO");
	position.put(50, "CP_FOLIO_ABONO");
	position.put(51, "OBSERVACIONES");
	position.put(52, "TIPO_CARTA");
	position.put(53, "ESTATUS_FRAUDE");
	position.put(54, "DICTAMEN");
	position.put(55, "MONTO_ABONO");
	position.put(56, "CAUSA_RESOLUCION");
	return position;
    }

}

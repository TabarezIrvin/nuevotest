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
public class FieldsDefaultCpConcentrate implements IDefaultFields {

    @Override
    public HashMap<String, String> fieldTypeExcel() {
	HashMap<String, String> mandatory = new HashMap<>();
	mandatory.put("TAREA", "String");
	mandatory.put("Año", "Integer");
	mandatory.put("FECHA INGRESO SAC", "Date");
	mandatory.put("FECHA DEL FORMATO", "Date");
	mandatory.put("CUENTA", "String");
	mandatory.put("TARJETA", "String");
	mandatory.put("UEVA TARJETA", "String");
	mandatory.put("EMPLEADO", "String");
	mandatory.put("NOMBRE DEL CLIENTE", "String");
	mandatory.put("CLAVE CLIENTE", "Integer");
	mandatory.put("TIPO_CLIENTE", "String");
	mandatory.put("PRODUCTO", "String");
	mandatory.put("MONTO", "Money");
	mandatory.put("NUM MOVIMIENTO", "String");
	mandatory.put("MONTO TOTAL", "String");
	mandatory.put("FECHA TXN", "Date");
	mandatory.put("HORA", "String");
	mandatory.put("AUTH", "Integer");
	mandatory.put("MCC", "Integer");
	mandatory.put("PEM", "Integer");
	mandatory.put("Modo Entrada", "String");
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
	mandatory.put("CP", "Integer");
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
	mandatory.put("CP FOLIO ABONO", "Integer");
	mandatory.put("OBSERVACIONES", "String");
	mandatory.put("TIPO CARTA", "String");
	mandatory.put("ESTATUS FRAUDE", "String");
	mandatory.put("DICTAMEN", "String");
	mandatory.put("MONTO ABONO", "Money");
	mandatory.put("CAUSA RESOLUCION", "String");
	mandatory.put("CODIGO_TRX", "Integer");
	mandatory.put("FECHA", "Date");
	mandatory.put("TARJETA2", "String");
	mandatory.put("BIN", "Integer");
	mandatory.put("MES PAGO", "String");
	mandatory.put("AÑO PAGO", "Integer");
	mandatory.put("Centro Costos", "String");
	mandatory.put("AÑO TRX", "Integer");
	mandatory.put("MES TRX", "String");
	mandatory.put("DIA TRX", "String");
	mandatory.put("Producto Real", "String");
	mandatory.put("Contemplado", "String");
	return mandatory;
    }

    @Override
    public HashMap<String, String> mappingDBExcel() {
	HashMap<String, String> relationship = new HashMap<>();
	relationship.put("TAREA", "TAREA");
	relationship.put("Anio", "Año");
	relationship.put("FECHA_INGRESO_SAC", "FECHA INGRESO SAC");
	relationship.put("FECHA_DEL_FORMATO", "FECHA DEL FORMATO");
	relationship.put("CUENTA", "CUENTA");
	relationship.put("TARJETA", "TARJETA");
	relationship.put("NUEVA_TARJETA", "UEVA TARJETA");
	relationship.put("EMPLEADO", "EMPLEADO");
	relationship.put("NOMBRE_DEL_CLIENTE", "NOMBRE DEL CLIENTE");
	relationship.put("CLAVE_CLIENTE", "CLAVE CLIENTE");
	relationship.put("TIPO_CLIENTE", "TIPO_CLIENTE");
	relationship.put("PRODUCTO", "PRODUCTO");
	relationship.put("MONTO", "MONTO");
	relationship.put("NUM_MOVIMIENTO", "NUM MOVIMIENTO");
	relationship.put("MONTO_TOTAL", "MONTO TOTAL");
	relationship.put("FECHA_TXN", "FECHA TXN");
	relationship.put("HORA", "HORA");
	relationship.put("AUTH", "AUTH");
	relationship.put("MCC", "MCC");
	relationship.put("PEM", "PEM");
	relationship.put("Modo_Entrada", "Modo Entrada");
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
	relationship.put("CODIGO_TRX", "CODIGO_TRX");
	relationship.put("FECHA_ABONO2", "FECHA");
	relationship.put("TARJETA2", "TARJETA2");
	relationship.put("BIN", "BIN");
	relationship.put("MES_PAGO", "MES PAGO");
	relationship.put("ANIO_PAGO", "AÑO PAGO");
	relationship.put("Centro_Costos", "Centro Costos");
	relationship.put("ANIO_TRX", "AÑO TRX");
	relationship.put("MES_TRX", "MES TRX");
	relationship.put("DIA_TRX", "DIA TRX");
	relationship.put("Producto_Real", "Producto Real");
	relationship.put("Contemplado", "Contemplado");
	return relationship;
    }

    @Override
    public HashMap<Integer, String> positionFieldBD() {
	HashMap<Integer, String> position = new HashMap<>();
	position.put(0, "TAREA");
	position.put(1, "Anio");
	position.put(2, "FECHA_INGRESO_SAC");
	position.put(3, "FECHA_DEL_FORMATO");
	position.put(4, "CUENTA");
	position.put(5, "TARJETA");
	position.put(6, "NUEVA_TARJETA");
	position.put(7, "EMPLEADO");
	position.put(8, "NOMBRE_DEL_CLIENTE");
	position.put(9, "CLAVE_CLIENTE");
	position.put(10, "TIPO_CLIENTE");
	position.put(11, "PRODUCTO");
	position.put(12, "MONTO");
	position.put(13, "NUM_MOVIMIENTO");
	position.put(14, "MONTO_TOTAL");
	position.put(15, "FECHA_TXN");
	position.put(16, "HORA");
	position.put(17, "AUTH");
	position.put(18, "MCC");
	position.put(19, "PEM");
	position.put(20, "Modo_Entrada");
	position.put(21, "CANAL_DE_TRANSACCION");
	position.put(22, "TERMINAL");
	position.put(23, "SERVICIO");
	position.put(24, "NOMBRE_COMERCIO");
	position.put(25, "AFILIACION");
	position.put(26, "ADQ");
	position.put(27, "REFERENCIA");
	position.put(28, "FOLIO");
	position.put(29, "APLICACION");
	position.put(30, "FECHA_DE_INGRESO_PROSA");
	position.put(31, "CP");
	position.put(32, "CIUDAD");
	position.put(33, "N_SAFE");
	position.put(34, "N_VISA");
	position.put(35, "RECLASIFICACION");
	position.put(36, "MOTIVO");
	position.put(37, "CAUSA_RECLAMACION");
	position.put(38, "FDE_POTENCIAL");
	position.put(39, "MTO_PROTEGIDO");
	position.put(40, "MTO_ANTICIPADO");
	position.put(41, "MTO_RECHAZADO");
	position.put(42, "MTO_RECUPERADO");
	position.put(43, "QUEB_SERVICIO");
	position.put(44, "TRMT_QUEBRANTO");
	position.put(45, "MTO_QUEBRANTO");
	position.put(46, "TIPO_FRAUDE");
	position.put(47, "FECHA_DICTAMEN");
	position.put(48, "DICTAMINO");
	position.put(49, "ESTADO");
	position.put(50, "CONCLUSION");
	position.put(51, "FECHA_ABONO");
	position.put(52, "CP_FOLIO_ABONO");
	position.put(53, "OBSERVACIONES");
	position.put(54, "TIPO_CARTA");
	position.put(55, "ESTATUS_FRAUDE");
	position.put(56, "DICTAMEN");
	position.put(57, "MONTO_ABONO");
	position.put(58, "CAUSA_RESOLUCION");
	position.put(59, "CODIGO_TRX");
	position.put(60, "FECHA_ABONO2");
	position.put(61, "TARJETA2");
	position.put(62, "BIN");
	position.put(63, "MES_PAGO");
	position.put(64, "ANIO_PAGO");
	position.put(65, "Centro_Costos");
	position.put(66, "ANIO_TRX");
	position.put(67, "MES_TRX");
	position.put(68, "DIA_TRX");
	position.put(69, "Producto_Real");
	position.put(70, "Contemplado");
	return position;
    }

}

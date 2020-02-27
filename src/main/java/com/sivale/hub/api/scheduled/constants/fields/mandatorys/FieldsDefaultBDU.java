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
 * Class created on 11 sep. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class FieldsDefaultBDU implements IDefaultFields {

    @Override
    public HashMap<String, String> fieldTypeExcel() {
	HashMap<String, String> mandatory = new HashMap<>();
	mandatory.put("Banco", "String");
	mandatory.put("Afiliacion", "Integer");
	mandatory.put("Cad Cve", "Integer");
	mandatory.put("Nombre Cad", "String");
	mandatory.put("Cad Gpo", "Integer");
	mandatory.put("Nombre Grupo Cad", "String");
	mandatory.put("Crit Enc", "Integer");
	mandatory.put("Descripcion CritEnc", "String");
	mandatory.put("Cve Bloqueo", "Integer");
	mandatory.put("Categoria", "Integer");
	mandatory.put("Cat Deb", "Integer");
	mandatory.put("Tipo Deb", "String");
	mandatory.put("Nombre", "String");
	mandatory.put("Propietario", "String");
	mandatory.put("Razon Social", "String");
	mandatory.put("Email", "String");
	mandatory.put("RFC", "String");
	mandatory.put("Domicilio", "String");
	mandatory.put("Colonia", "String");
	mandatory.put("CP", "Integer");
	mandatory.put("Lada1", "Integer");
	mandatory.put("Telefono1", "Integer");
	mandatory.put("Lada2", "Integer");
	mandatory.put("Telefono2", "Integer");
	mandatory.put("SIC", "Integer");
	mandatory.put("Descripcion SIC", "String");
	mandatory.put("Pob", "Integer");
	mandatory.put("Descripcion Pob", "String");
	mandatory.put("Edo", "Integer");
	mandatory.put("Nombre Estado", "String");
	mandatory.put("Afil Ant", "Integer");
	mandatory.put("Rec Cve", "Integer");
	mandatory.put("Com Activo", "String");
	mandatory.put("Fec Alta", "Date");
	mandatory.put("Fec Ultmod", "Date");
	mandatory.put("Usr Ultmod", "String");
	mandatory.put("Afil Amex", "Integer");
	return mandatory;
    }

    @Override
    public HashMap<String, String> mappingDBExcel() {
	HashMap<String, String> relationship = new HashMap<>();
	relationship.put("Banco", "Banco");
	relationship.put("Afiliacion", "Afiliacion");
	relationship.put("Cad_Cve", "Cad Cve");
	relationship.put("Nombre_Cad", "Nombre Cad");
	relationship.put("Cad_Gpo", "Cad Gpo");
	relationship.put("Nombre_Grupo_Cad", "Nombre Grupo Cad");
	relationship.put("Crit_Enc", "Crit Enc");
	relationship.put("Descripcion_CritEnc", "Descripcion CritEnc");
	relationship.put("Cve_Bloqueo", "Cve Bloqueo");
	relationship.put("Categoria", "Categoria");
	relationship.put("Cat_Deb", "Cat Deb");
	relationship.put("Tipo_Deb", "Tipo Deb");
	relationship.put("Nombre", "Nombre");
	relationship.put("Propietario", "Propietario");
	relationship.put("Razon_Social", "Razon Social");
	relationship.put("Email", "Email");
	relationship.put("RFC", "RFC");
	relationship.put("Domicilio", "Domicilio");
	relationship.put("Colonia", "Colonia");
	relationship.put("CP", "CP");
	relationship.put("Lada1", "Lada1");
	relationship.put("Telefono1", "Telefono1");
	relationship.put("Lada2", "Lada2");
	relationship.put("Telefono2", "Telefono2");
	relationship.put("SIC", "SIC");
	relationship.put("Descripcion_SIC", "Descripcion SIC");
	relationship.put("Pob", "Pob");
	relationship.put("Descripcion_Pob", "Descripcion Pob");
	relationship.put("Edo", "Edo");
	relationship.put("Nombre_Estado", "Nombre Estado");
	relationship.put("Afil_Ant", "Afil Ant");
	relationship.put("Rec_Cve", "Rec Cve");
	relationship.put("Com_Activo", "Com Activo");
	relationship.put("Fec_Alta", "Fec Alta");
	relationship.put("Fec_Ultmod", "Fec Ultmod");
	relationship.put("Usr_Ultmod", "Usr Ultmod");
	relationship.put("Afil_Amex", "Afil Amex");
	return relationship;
    }

    @Override
    public HashMap<Integer, String> positionFieldBD() {
	HashMap<Integer, String> position = new HashMap<>();
	position.put(0, "Banco");
	position.put(1, "Afiliacion");
	position.put(2, "Cad_Cve");
	position.put(3, "Nombre_Cad");
	position.put(4, "Cad_Gpo");
	position.put(5, "Nombre_Grupo_Cad");
	position.put(6, "Crit_Enc");
	position.put(7, "Descripcion_CritEnc");
	position.put(8, "Cve_Bloqueo");
	position.put(9, "Categoria");
	position.put(10, "Cat_Deb");
	position.put(11, "Tipo_Deb");
	position.put(12, "Nombre");
	position.put(13, "Propietario");
	position.put(14, "Razon_Social");
	position.put(15, "Email");
	position.put(16, "RFC");
	position.put(17, "Domicilio");
	position.put(18, "Colonia");
	position.put(19, "CP");
	position.put(20, "Lada1");
	position.put(21, "Telefono1");
	position.put(22, "Lada2");
	position.put(23, "Telefono2");
	position.put(24, "SIC");
	position.put(25, "Descripcion_SIC");
	position.put(26, "Pob");
	position.put(27, "Descripcion_Pob");
	position.put(28, "Edo");
	position.put(29, "Nombre_Estado");
	position.put(30, "Afil_Ant");
	position.put(31, "Rec_Cve");
	position.put(32, "Com_Activo");
	position.put(33, "Fec_Alta");
	position.put(34, "Fec_Ultmod");
	position.put(35, "Usr_Ultmod");
	position.put(36, "Afil_Amex");
	return position;
    }
    
}

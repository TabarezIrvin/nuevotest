package com.sivale.hub.api.scheduled.constants.fields.mandatorys;

import java.util.HashMap;
import com.sivale.hub.api.scheduled.commons.IDefaultFields;

public class FieldsDefaultRejectionsDayCVV implements IDefaultFields {

    @Override
    public HashMap<String, String> fieldTypeExcel() {
	HashMap<String, String> mandatory = new HashMap<>();
	mandatory.put("Fecha de Trx", "Date");
	mandatory.put("Trx's", "Integer");
	mandatory.put("Trx's Desduplicadas", "Integer");
	return mandatory;
    }

    @Override
    public HashMap<String, String> mappingDBExcel() {
	HashMap<String, String> relationship = new HashMap<>();
	relationship.put("FechaTrx", "Fecha de Trx");
	relationship.put("Trxs", "Trx's");
	relationship.put("TrxsDesduplicadas", "Trx's Desduplicadas");
	return relationship;
    }

    @Override
    public HashMap<Integer, String> positionFieldBD() {
	HashMap<Integer, String> position = new HashMap<>();
	position.put(0, "FechaTrx");
	position.put(1, "Trxs");
	position.put(2, "TrxsDesduplicadas");
	return position;
    }

}

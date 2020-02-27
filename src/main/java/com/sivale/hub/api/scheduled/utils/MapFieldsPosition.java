/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sivale.hub.api.scheduled.constants.Constantes;

/**
 * Description: This class is used for ... 
 * Class created on 17 jul. 2019.
 * 
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class MapFieldsPosition {
    
    /**
     * 
     * Method used for ...
     * Returns an object of type HashMap<String,Integer>.
     * Method created on 17 jul. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param mapFields
     * @param pathFile
     * @return
     */
    public HashMap<String, Integer> getMapping(HashMap<String, String> mapFields, String pathFile) {
	HashMap<String, Integer> mapping = new HashMap<>();
	List<String> fields = new ArrayList<>();
	try (
	    Workbook workbook = new XSSFWorkbook(pathFile)){
	    Sheet sheet = workbook.getSheetAt(Constantes.CERO);
	    Cell cell = null;
	    for(int i = Constantes.CERO; i < sheet.getRow(Constantes.CERO).getPhysicalNumberOfCells(); i++) {
		cell = sheet.getRow(Constantes.CERO).getCell(i);
		fields.add(cell.getStringCellValue());
	    }
	    int i = Constantes.CERO;
	    for (String field : fields) {
		if (mapFields.containsKey(field)) {
		    mapping.put(field, i);
		}
		i++;
	    }
	} catch (Exception e) {
	    mapping = null;
	}
	return mapping;
    }

}

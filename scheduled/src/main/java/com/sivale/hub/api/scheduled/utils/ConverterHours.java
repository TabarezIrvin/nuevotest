/**
 * Copyright (c) 2019 
 * EON IGNITING BUSINESS SAPI de CV
 * Sí Vale México, S.A de C.V.
 */
package com.sivale.hub.api.scheduled.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sivale.hub.api.scheduled.exception.HubException;

/**
 * Description: This class is used for ...
 * Class created on 30 ago. 2019.
 * @author Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
 */
public class ConverterHours {
    
    static final Logger log = LoggerFactory.getLogger(ConverterHours.class);
    
    /**
     * 
     * Method used for ...
     * Returns an object of type String.
     * Method created on 1 oct. 2019, by Gulliver Paredes Aguirres [gulliver.paredes.eon@gmail.com]
     * @param cell
     * @return
     */
    public String getFormat24Hrs(Cell cell) {
		StringBuilder timeReturn = new StringBuilder();
		try {
			Calendar time = Calendar.getInstance();
			time.setTime(cell.getDateCellValue());
			timeReturn.append(String.format("%02d:%02d:%02d", time.get(Calendar.HOUR), time.get(Calendar.MINUTE),
					time.get(Calendar.SECOND)));
		} catch (Exception e) {
			String hour = cell.getStringCellValue();
			String localTime = hour.replace("\\s+", "").replace("\\.", "").toUpperCase();
			boolean isAM = localTime.contains("A");
			boolean isPM = localTime.contains("P");
			if (Integer.parseInt(hour.split(":")[0]) > 12) {
				timeReturn.append(hour.replace("\\s+", "").replace("AM", "").replace("PM", ""));
			} else {
				Date date = null;
				SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
				SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ss a");
				try {
					if (isAM) {
						date = parseFormat.parse(localTime.replace("AM", " AM"));
					} else if (isPM) {
						date = parseFormat.parse(localTime.replace("PM", " PM"));
					} else {
						date = displayFormat.parse(localTime);
					}
				} catch (ParseException pe) {
					HubException he = new HubException();
					log.error(he.imprimeErrorExcepcion(e.getStackTrace()));
				}
				timeReturn.append(displayFormat.format(date));
			}
		}
		return timeReturn.toString();
	}
    
}

package com.sivale.hub.api.scheduled.utils;


/**
 * Description: This class is used for ...
 * Class created on 27 jun 2019.
 * @author Alan Garza Angeles [alan.garza.eon@gmail.com]
 */
public final class OSUtils {
    
    private OSUtils() { }
    
    public static final String getOsName() {
	return System.getProperty("os.name").toLowerCase();
    }

    public static final boolean isWindows() {
	return getOsName().indexOf("win") != -1;
    }

    public static final boolean isUnix() {
	return (getOsName().indexOf("nix") != -1 || getOsName().indexOf("nux") != -1
		|| getOsName().indexOf("aix") != -1);
    }
}

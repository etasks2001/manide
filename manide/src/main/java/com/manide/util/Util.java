package com.manide.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String getDh() {
	String timezone = new SimpleDateFormat("Z").format(new Date());
	timezone = timezone.substring(0, timezone.length() - 2) + ":" + timezone.substring(timezone.length() - 2, timezone.length());
	return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()) + timezone;
    }
}

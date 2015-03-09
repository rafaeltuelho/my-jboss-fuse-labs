package br.net.rafaeltuelho.osgi.time;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

public class Clock {

	DateTime dt = null;
	static final String DTF = new String("dd/MM/yyyy HH:mm:SS z");
	
	public Clock(TimeUtil.TimeZone tz) {
		System.out.println("Using [" + tz.toString() + "] timezone");
		dt = new DateTime(DateTimeZone.forID(tz.toString()));
	}
	
	public String getLocalTime(){
		return dt.toString(DateTimeFormat.forPattern(DTF));
	}

}

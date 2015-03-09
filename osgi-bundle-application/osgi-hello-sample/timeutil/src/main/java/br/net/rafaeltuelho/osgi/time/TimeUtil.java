package br.net.rafaeltuelho.osgi.time;

public class TimeUtil {
	
	public enum TimeZone{
		SAO_PAULO {
			public String toString(){
				return "America/Sao_Paulo";	
			}
		},
		BAHIA {
			public String toString(){
				return "America/Bahia";	
			}
		},
		ACRE {
			public String toString(){
				return "Brazil/Acre";	
			}
		},
	}
	
	public static Clock createClock(TimeZone tz){
		return new Clock(tz);
	}
}

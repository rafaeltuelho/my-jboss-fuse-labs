package br.net.rafaeltuelho.osgi.hello.saopaulo.impl;

import br.net.rafaeltuelho.osgi.hello.saopaulo.HelloSaoPaulo;
import br.net.rafaeltuelho.osgi.time.Clock;
import br.net.rafaeltuelho.osgi.time.TimeUtil;

public class HelloSaoPauloImpl implements HelloSaoPaulo{
	protected Clock localTime = null;
	
	public String getGreeting(){
		return " E dae mano!!! ";
	}

	public Clock getLocalTime(){
		if (localTime == null)
			localTime = TimeUtil.createClock(TimeUtil.TimeZone.SAO_PAULO);
		
		return localTime;
	}
}

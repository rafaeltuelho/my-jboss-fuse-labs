package br.net.rafaeltuelho.osgi.hello.bahia.impl;

import br.net.rafaeltuelho.osgi.hello.bahia.HelloBahia;
import br.net.rafaeltuelho.osgi.time.Clock;
import br.net.rafaeltuelho.osgi.time.TimeUtil;

public class HelloBahiaImpl implements HelloBahia{
	protected Clock localTime = null;
	
	public String getGreeting(){
		return " Oh meu rei!!! ";
	}

	public Clock getLocalTime(){
		if (localTime == null)
			localTime = TimeUtil.createClock(TimeUtil.TimeZone.BAHIA);
		
		return localTime;
	}
}

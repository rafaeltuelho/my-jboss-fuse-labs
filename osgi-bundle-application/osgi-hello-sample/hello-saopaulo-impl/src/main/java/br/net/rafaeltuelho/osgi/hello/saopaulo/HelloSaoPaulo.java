package br.net.rafaeltuelho.osgi.hello.saopaulo;

import br.net.rafaeltuelho.osgi.time.Clock;

public interface HelloSaoPaulo {
	public String getGreeting();

	public Clock getLocalTime();
}

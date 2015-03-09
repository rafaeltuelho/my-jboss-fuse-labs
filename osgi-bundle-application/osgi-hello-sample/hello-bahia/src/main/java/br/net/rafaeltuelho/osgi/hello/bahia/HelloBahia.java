package br.net.rafaeltuelho.osgi.hello.bahia;

import br.net.rafaeltuelho.osgi.time.Clock;

public interface HelloBahia {
	public String getGreeting();

	public Clock getLocalTime();
}

package br.net.rafaeltuelho.osgi.hello.consumer;

import br.net.rafaeltuelho.osgi.hello.bahia.HelloBahia;
import br.net.rafaeltuelho.osgi.hello.saopaulo.HelloSaoPaulo;

public class ConsumerHello {
	protected HelloSaoPaulo helloSaoPaulo = null;
	protected HelloBahia helloBahia = null;

	public void init() {
		if (helloSaoPaulo == null || helloBahia == null) {
			System.out
					.println("Initialization failed. Injected objects are null.");
			return;
		}

		String spGreeting = helloSaoPaulo.getGreeting();
		String spTime = helloSaoPaulo.getLocalTime().getLocalTime();
		System.out.println("\t >>> São Paulo says:" + spGreeting + " at " + spTime);

		String baGreeting = helloBahia.getGreeting();
		String baTime = helloBahia.getLocalTime().getLocalTime();
		System.out.println("\t >>> Bahia says:" + baGreeting + " at " + baTime);
	}

	public HelloSaoPaulo getHelloSaoPaulo() {
		return helloSaoPaulo;
	}

	public void setHelloSaoPaulo(HelloSaoPaulo helloSaoPaulo) {
		this.helloSaoPaulo = helloSaoPaulo;
	}

	public HelloBahia getHelloBahia() {
		return helloBahia;
	}

	public void setHelloBahia(HelloBahia helloBahia) {
		this.helloBahia = helloBahia;
	}
}

package br.net.rafaeltuelho;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
}


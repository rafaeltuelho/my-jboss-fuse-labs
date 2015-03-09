
package br.net.rafaeltuelho;

import javax.jws.WebService;

@WebService(endpointInterface = "br.net.rafaeltuelho.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}


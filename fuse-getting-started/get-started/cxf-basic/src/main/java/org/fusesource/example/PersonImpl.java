package org.fusesource.example;

import javax.jws.WebService;
import javax.xml.ws.Holder;

import org.fusesource.example.types.GetPerson;
import org.fusesource.example.types.GetPersonResponse;

@WebService(serviceName = "PersonService", endpointInterface = "org.fusesource.example.Person")
public class PersonImpl implements Person {

    public void getPerson(Holder<String> personId, Holder<String> ssn, Holder<String> name)
        throws UnknownPersonFault
    {
        if (personId.value == null || personId.value.length() == 0) {
            org.fusesource.example.types.UnknownPersonFault fault = new org.fusesource.example.types.UnknownPersonFault();
            fault.setPersonId(personId.value);
            throw new UnknownPersonFault(null,fault);
        }
        name.value = "Guillaume";
        ssn.value = "000-000-0000";
    }

}

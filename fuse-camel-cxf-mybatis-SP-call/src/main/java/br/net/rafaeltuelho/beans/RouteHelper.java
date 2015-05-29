package br.net.rafaeltuelho.beans;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import br.net.rafaeltuelho.dvdstore.domain.v1.Product;
import br.net.rafaeltuelho.dvdstore.services.v1.SearchByActorResponse;

public class RouteHelper {

	private Logger log = Logger.getLogger(RouteHelper.class);
	
	public SearchByActorResponse fillServiceResponse(List<Product> body){
		SearchByActorResponse response = new SearchByActorResponse();
		response.setMessage("Success!");
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar xmlDate = null;
		try {
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			log.error(e.getMessage(), e);
		}
		
		response.setTime(xmlDate);
		response.getProducts().addAll(body);
		
		log.info("Products List size: " + response.getProducts().size());
		
		return response;
	}
	
}

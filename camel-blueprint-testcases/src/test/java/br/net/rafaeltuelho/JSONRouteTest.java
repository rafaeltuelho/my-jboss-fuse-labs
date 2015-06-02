package br.net.rafaeltuelho;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.json.simple.JSONObject;
import org.junit.Test;

public class JSONRouteTest extends CamelBlueprintTestSupport {
    private boolean debugBeforeMethodCalled;
    private boolean debugAfterMethodCalled;
 	
    @Override
    protected String getBlueprintDescriptor() {
        return "/OSGI-INF/blueprint/camel-jsonpath-test.xml";
    }

    @Test
    public void testRoute() throws Exception {
        // set mock expectations
        getMockEndpoint("mock:programming").expectedMessageCount(1);
 
        // send a message
    	Map booksMap = new LinkedHashMap();
    	List booksList = new LinkedList<>();

    	Map<String, Object> b1 = new LinkedHashMap<>();
        b1.put("isbn", "xxx-xx");
        b1.put("category", "reference");
        b1.put("author", "Nigel Rees");
        b1.put("title", "Sayings of the Century");
        b1.put("price", BigDecimal.valueOf(8.95));

        Map<String, Object> b2 = new LinkedHashMap<>();
        b2.put("isbn", "yyy-yy");
        b2.put("category", "programming");
        b2.put("author", "Rafael Tuelho");
        b2.put("title", "Java 10 in Action");
        b2.put("price", BigDecimal.valueOf(1999.73));

        Map<String, Object> b3 = new LinkedHashMap<>();
        b3.put("isbn", "aaaa-aaa");
        b3.put("category", "commedy");
        b3.put("author", "Someone");
        b3.put("title", "Commedy book vol1");
        b3.put("price", BigDecimal.valueOf(1999.73));

        Map<String, Object> b4 = new LinkedHashMap<>();
        b4.put("isbn", "zzzz-zz");
        b4.put("category", "novel");
        b4.put("author", "Joseph");
        b4.put("title", "A great Novel");
        b4.put("price", BigDecimal.valueOf(1999.73));

        Map<String, Object> b5 = new LinkedHashMap<>();
        b5.put("isbn", "www-ww");
        b5.put("category", "history");
        b5.put("author", "Other one");
        b5.put("title", "Second WAR");
        b5.put("price", BigDecimal.valueOf(1999.73));

        booksList.add(b1);
        booksList.add(b2);
        booksList.add(b3);
        booksList.add(b4);
        booksList.add(b5);
        
        booksMap.put("books", booksList);
        
        JSONObject jsonStore = new JSONObject();
        jsonStore.put("store", booksMap);

        
        System.out.println(jsonStore.toJSONString());
        
        template.sendBody("direct:input", jsonStore.toJSONString());
 
        // assert mocks
        assertMockEndpointsSatisfied();
    }
    
    public static void main(String[] args) {
        // send a message
    	Map booksMap = new LinkedHashMap();
    	List booksList = new LinkedList<>();

    	Map<String, Object> b1 = new LinkedHashMap<>();
        b1.put("isbn", "xxx-xx");
        b1.put("category", "reference");
        b1.put("author", "Nigel Rees");
        b1.put("title", "Sayings of the Century");
        b1.put("price", BigDecimal.valueOf(8.95));

        Map<String, Object> b2 = new LinkedHashMap<>();
        b2.put("isbn", "yyy-yy");
        b2.put("category", "programming");
        b2.put("author", "Rafael Tuelho");
        b2.put("title", "Java 10 in Action");
        b2.put("price", BigDecimal.valueOf(1999.73));

        booksList.add(b1);
        booksList.add(b2);
        
        booksMap.put("books", booksList);
        
        JSONObject jsonStore = new JSONObject();
        jsonStore.put("store", booksMap);
        
        System.out.println(jsonStore.toJSONString());		
	}
}

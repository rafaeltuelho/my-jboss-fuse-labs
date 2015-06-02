# camel-jpa-demo
Project Demo using camel-jpa with OpenJPA implementation to pull a Data Base Entity.

In this demo I used a [H2DB](http://www.h2database.com/html/main.html)

* Download the H2DB binary.
* Start it
```
cd H2DB_HOME/bin
./hs.sh
```
* open the H2 web console: http://localhost:8082/
* connect to a test DB using the following properties:
```
Saved Sttings: Generic H2 (Server)
JDBC URL: jdbc:h2:tcp://localhost/~/var/h2db/test
User Name: sa
Password: **
```

* Create a simple sample DB with a table (eg CUSTOMERS)
Use this GIST to create a [sample H2 DB](https://gist.github.com/rafaeltuelho/f330f9ce75ecfbe99112)


* inside the parent maven project
```
mvn install
cd camel-jpa-blueprint-route/
mvn camel:run -DskipTests
```

The camel route will pull the Customers table every 30s ad print the resultset in the console output

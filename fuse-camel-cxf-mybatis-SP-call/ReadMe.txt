Camel Router Project for Apache CXF contract-first using Blueprint (OSGi)
=========================================================================

This project uses the following features:
 * Camel
 * Blueprint XML
 * CXF SOAP WS
 * Camel MyBatis to access Postgresql Stored Procedures
 * Camel Maven Plugin (camel:run): run the Camel context locally
 * CXF code gen: generates service code from WSDL contract
 * Fabric8 Maven Plugin to deploy the artifact inside a Fuse Fabric
 * Use some CXF Features and Interceptors
 
NOTE: this project depends on the [Dell DVD Store 2 Data Base Sample](http://rafaeltuelho.net.br/2015/05/21/dell-dvd-store-sample-data-base-um-banco-de-dados-pronto-para-testes/)

To build this project use

    `mvn clean install -DskipTests`

To deploy the project in JBoss Fuse Fabric
or Apache Karaf. You need to install the following features first:
```
    mvn fabric8:deploy
```
And the WSDL file for this example at:

    http://localhost:8181/dvdStorea/?wsdl

For more help see the Apache Camel documentation

    http://camel.apache.org/

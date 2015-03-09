
* generate the project from Apache CXF Maven Archetype

```
mvn archetype:generate \
-DgroupId=br.net.rafaeltuelho \
-DartifactId=cxf-contract-first \
-Dversion=0.0.1-SNAPSHOT \
-DarchetypeGroupId=org.apache.cxf.archetype \
-DarchetypeArtifactId=cxf-jaxws-javafirst \
-DarchetypeVersion=3.0.4
```

* build the project

```
mvn install
```

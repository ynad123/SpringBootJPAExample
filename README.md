## SpringBootJPAExample: REST-Backend mit Spring Boot

# Vorbereitungen
Java EE installiert
Mysql installiert —> https://www.mysql.com/de/ 
MysqlWorkBench installiert und auf localhost DB angelegt

Tomcat installieren
- Tomcat local installieren —> Verzeichnis downloaden und entpacken
- In bin: chmod +x .sh
- Dann ./startup


# In Eclipse
spring boot Projekt angelegt entsprechend des Videos:
https://www.youtube.com/watch?v=1ny8-kzmdJE

Diese Projekt ist verfügbar, wenn in Eclipse gestartet —> direkt unter localhost:8080/customer


- Erweiterungen damit CRUD funktionieren nach dem Vorbild von:
- https://www.bezkoder.com/spring-boot-jpa-crud-rest-api/


#Deployment über Tomcat

In Eclipse: in pom.xml Änderungen:
<packaging>war</packaging> auf gleicher Ebene wie parent
<start-class>de.meyerdany.customerapi.CustomerapiApplication</start-class> —> in properties

In CustomerapiApplication
 extends SpringBootServletInitializer  

@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(CustomerapiApplication.class);
	}

Wie in https://www.tutorialspoint.com/spring_boot/spring_boot_tomcat_deployment.htm beschrieben

————
Project clean

Nun war erzeugen:
In eclipse —> auf Project klicken —> rechts —> run as —> maven install

—> in target wird nun war-File generiert

——
War file ggf. umbenennen und kopieren
Von Tomcat aus deployen

Aufruf 
Localhost:8080/namewarfile/customer

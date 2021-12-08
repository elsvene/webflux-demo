# Webflux-Demo: SensorData

Demo-Projekt mit Spring Webflux, MongoDB und Node.js-Publisher

## MongoDB installieren und starten

* MongoDB gemäß Dokumentation installieren: [https://docs.mongodb.com/manual/administration/install-community/](https://docs.mongodb.com/manual/administration/install-community/)

* es wird eine DB `webflux-demo` mit einer Capped Collection `sensors` erwartet (Größe 500000 Bytes) &rarr; ggf. noch anlegen (z.B. per [MongoDB Compass](https://www.mongodb.com/products/compass))

## Mock-Sensoren

Node-Skript `mockSensor/index.js` starten &rarr; das Skript befüllt die Datenbank kontinuierlich mit "Sensordaten", bis es beendet wird

## Webflux-Backend

Das Backend arbeitet mit Spring Webflux, Netty und Thymeleaf. Es kann über die Klasse `/webflux-demo/src/main/java/de/fhdo/webfluxdemo/SensorDataApp.java` oder per `mvn spring-boot:run` gestartet werden.

## Start und Test

* Mock-Sensor und Webflux-Backend starten
* Serverseitig gerenderte View testen: [http://localhost:8080/sensor/list](http://localhost:8080/sensor/list)
* REST-API testen: `curl  -H "Accept: text/event-stream" http://localhost:8080/sensor/api/temperature`

## GraphQL API

* GraphiQL öffnen: [http://localhost:8080/graphiql](http://localhost:8080/graphiql)
* Subscription-Anfrage stellen, z.B.:

	``
	subscription {
		sensorData {
			id
			timestamp
			metadata {
				sensorId
				type
			}
			value
	}
	``

## MongoDB aufräumen

Es können keine Datensätze aus Capped Collections gelöscht werden, daher muss die Collection gedropped und wieder neu angelegt werden!

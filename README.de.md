# Webflux-Demo: SensorData
[![en](https://img.shields.io/badge/lang-en-red.svg)](README.md)
[![de](https://img.shields.io/badge/lang-de-green.svg)](#)

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
* GraphQL-API via [graphiql](https://github.com/graphql/graphiql) (oder ähnlichem Tool) testen

## MongoDB aufräumen

Es können keine Datensätze aus Capped Collections gelöscht werden, daher muss die Collection gedropped und wieder neu angelegt werden!

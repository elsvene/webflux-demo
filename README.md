# Webflux-Demo: SensorData
[![en](https://img.shields.io/badge/lang-en-red.svg)](#)
[![de](https://img.shields.io/badge/lang-de-green.svg)](README.de.md)

Demo-Projekt mit Spring Webflux, MongoDB und Node.js-Publisher


## Install and start MongoDB

* Install MongoDB according to the documentation: [https://docs.mongodb.com/manual/administration/install-community/](https://docs.mongodb.com/manual/administration/install-community/)

* a DB `webflux-demo` with a capped collection `sensors` is expected (size 500000 bytes) &rarr; create if necessary (e.g. via [MongoDB Compass](https://www.mongodb.com/products/compass))

## Mock sensors

Start node script `mockSensor/index.js` &rarr; the script continuously fills the database with "sensor data" until it is terminated

## Webflux backend

The backend works with Spring Webflux, Netty and Thymeleaf. It can be started via the class `/webflux-demo/src/main/java/en/fhdo/webfluxdemo/SensorDataApp.java` or via `mvn spring-boot:run`.

## Start and test

* Start mock sensor and Webflux backend
* Test server-side rendered view: [http://localhost:8080/sensor/list](http://localhost:8080/sensor/list)
* Test GraphQL-API via [graphiql](https://github.com/graphql/graphiql) or another tool of your choice

## Clean up MongoDB

No data records can be deleted from capped collections, so the collection must be dropped and recreated!
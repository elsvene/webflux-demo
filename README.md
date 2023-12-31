# Webflux demo: SensorData
[![en](https://img.shields.io/badge/lang-en-red.svg)](#)
[![de](https://img.shields.io/badge/lang-de-green.svg)](README.de.md)

Demo project with Spring Webflux, MongoDB and Node.js Publisher

## Repository branches

Branches in the repository show different implementation variants:
* `main`: Webflux backend + Server-Sent Events (SSE) + Thymeleaf client
* `websockets-based-implementation`: Webflux backend + Websockets + Thymeleaf client
* `graphql-api-with-subscription`: Webflux backend + Subscription via GraphQL-API
* `vue-frontend`: Webflux backend + Server-Sent Events (SSE) + Vue.js client

## Install and start MongoDB

* Install MongoDB according to the documentation: [https://docs.mongodb.com/manual/administration/install-community/](https://docs.mongodb.com/manual/administration/install-community/)

* A DB `webflux-demo` with a capped collection `sensors` is expected (size 500000 bytes) &rarr; create if necessary (e.g. via [MongoDB Compass](https://www.mongodb.com/products/compass))

## Mock sensors

Start the node script `mockSensor/index.js` &rarr; the script continuously fills the database with "sensor data" until it is terminated

## Webflux backend

The backend works with Spring Webflux, Netty and Thymeleaf. It can be started via the class `/webflux-demo/src/main/java/en/fhdo/webfluxdemo/SensorDataApp.java` or via `mvn spring-boot:run`.

## Start and test

* Start mock sensor and Webflux backend
* Test server-side rendered view: [http://localhost:8080/sensor/list](http://localhost:8080/sensor/list)
* Test REST-API: `curl -H "Accept: text/event-stream" http://localhost:8080/sensor/api/temperature`

## Clean up MongoDB

No data records can be deleted from capped collections, so the collection must be dropped and recreated! 
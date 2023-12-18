# Webflux-Demo: SensorData

Demo-Projekt mit Spring Webflux, MongoDB und Node.js-Publisher

## MongoDB installieren und starten

* MongoDB gemäß Dokumentation installieren: [https://docs.mongodb.com/manual/administration/install-community/](https://docs.mongodb.com/manual/administration/install-community/)

* es wird eine DB `webflux-demo` mit einer Capped Collection `sensors` erwartet (Größe 500000 Bytes) &rarr; ggf. noch anlegen (z.B. per [MongoDB Compass](https://www.mongodb.com/products/compass))

## Mock-Sensoren

Node-Skript `mockSensor/index.js` starten &rarr; das Skript befüllt die Datenbank kontinuierlich mit "Sensordaten", bis es beendet wird

## Webflux-Backend

Das Backend arbeitet mit Spring Webflux und Netty. Es kann über die Klasse `/webflux-demo/src/main/java/de/fhdo/webfluxdemo/SensorDataApp.java` oder per `mvn spring-boot:run` gestartet werden.

## Frontend

Das Frontend basiert auf Vue.js und befindet sich in `/webflux-demo/src/main/vue/vue-frontend`. Initial muss dieses einmal wie folgt eingerichtet werden:

```sh
cd src/main/vue/vue-frontend
npm install
```

Das Frontend kann gestartet werden über:

```sh
npm run dev
```

## Start und Test

* Mock-Sensor und Webflux-Backend starten
* Vue-Frontend starten und testen über die von Vite genannte URL, z.B. [http://localhost:5173/](http://localhost:5173/)
* REST-API testen: `curl  -H "Accept: text/event-stream" http://localhost:8080/sensor/api/temperature`

## MongoDB aufräumen

Es können keine Datensätze aus Capped Collections gelöscht werden, daher muss die Collection gedropped und wieder neu angelegt werden!

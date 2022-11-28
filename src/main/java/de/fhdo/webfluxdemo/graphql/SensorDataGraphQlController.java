package de.fhdo.webfluxdemo.graphql;

import de.fhdo.webfluxdemo.domain.SensorData;
import de.fhdo.webfluxdemo.service.SensorDataService;
import org.reactivestreams.Publisher;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class SensorDataGraphQlController {
    private SensorDataService service;

    public SensorDataGraphQlController(SensorDataService service) {
        this.service = service;
    }

    // Dummy-Query, da GraphQL mind. eine Root-Query will
    @QueryMapping
    public String test() {
        return "Test!";
    }

    @SubscriptionMapping("sensorData")
    public Flux<SensorData> getSensorData() {
        return service.findTemperatureData();
    }
}

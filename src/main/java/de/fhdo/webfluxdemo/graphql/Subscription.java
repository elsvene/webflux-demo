package de.fhdo.webfluxdemo.graphql;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;

import de.fhdo.webfluxdemo.domain.SensorData;
import de.fhdo.webfluxdemo.service.SensorDataService;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;

@Component
public class Subscription implements GraphQLSubscriptionResolver {
	private SensorDataService service;

	public Subscription(SensorDataService service) {
		this.service = service;
	}

	public Publisher<SensorData> getSensorData() {
		return service.findTemperatureData();
	}
}

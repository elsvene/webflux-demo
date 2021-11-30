package de.fhdo.webfluxdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.fhdo.webfluxdemo.domain.SensorData;
import de.fhdo.webfluxdemo.service.SensorDataService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/sensor/api")
public class SensorDataRestController {
	private SensorDataService service;

	@Autowired
	public SensorDataRestController(SensorDataService service) {
		this.service = service;
	}

	@GetMapping("temperature")
	public Flux<SensorData> readSensorData() {
		return service.findTemperatureData();
	}
}

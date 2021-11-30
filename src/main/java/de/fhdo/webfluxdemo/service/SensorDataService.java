package de.fhdo.webfluxdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.fhdo.webfluxdemo.domain.SensorData;
import de.fhdo.webfluxdemo.repository.SensorDataRepository;
import reactor.core.publisher.Flux;

@Service
public class SensorDataService {
	private SensorDataRepository repo;

	@Autowired
	public SensorDataService(SensorDataRepository repo) {
		this.repo = repo;
	}

	public Flux<SensorData> findTemperatureData() {
		return repo.findByType("temperature");
	}
}

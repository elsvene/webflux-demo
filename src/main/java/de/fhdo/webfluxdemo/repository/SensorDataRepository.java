package de.fhdo.webfluxdemo.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import de.fhdo.webfluxdemo.domain.SensorData;
import reactor.core.publisher.Flux;

public interface SensorDataRepository extends ReactiveMongoRepository<SensorData, String> {
	@Query("{ 'metadata.type': ?0 }")
	@Tailable
    Flux<SensorData> findByType(String type);
}

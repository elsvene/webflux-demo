package de.fhdo.webfluxdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;

import de.fhdo.webfluxdemo.domain.SensorData;
import de.fhdo.webfluxdemo.service.SensorDataService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@Component
public class SensorDataWebSocketHandler implements WebSocketHandler {
	private SensorDataService service;
	private ObjectMapper mapper;

	@Autowired
	public SensorDataWebSocketHandler(SensorDataService service, ObjectMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@Override
	public Mono<Void> handle(WebSocketSession session) {
		Flux<String> messages = service.findTemperatureData().map(this::convertToJsonString);
		return session.send(messages.map(session::textMessage))
				.and(session.receive().map(WebSocketMessage::getPayloadAsText).log());
	}

	private String convertToJsonString(SensorData data) {
		String result;
		try {
			result = mapper.writeValueAsString(data);
		} catch (JacksonException e) {
			result = "";
		}
		return result;
	}
}

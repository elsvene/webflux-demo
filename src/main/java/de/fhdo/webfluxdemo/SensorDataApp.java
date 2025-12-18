package de.fhdo.webfluxdemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;

@SpringBootApplication
public class SensorDataApp {

	private final WebSocketHandler webSocketHandler;

    @Autowired
    public SensorDataApp(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    static void main(String[] args) {
		SpringApplication.run(SensorDataApp.class, args);
	}

	@Bean
	public HandlerMapping webSocketHandlerMapping() {
		return new SimpleUrlHandlerMapping(Map.of("/ws/stream", webSocketHandler), 1);
	}
}

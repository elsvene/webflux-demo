package de.fhdo.webfluxdemo.domain;

import java.time.Instant;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sensors")
public class SensorData {
	private String id;
	private Instant timestamp;
	private SensorMetadata metadata;
	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public SensorMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(SensorMetadata metadata) {
		this.metadata = metadata;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SensorData [id=" + id + ", timestamp=" + timestamp + ", metadata=" + metadata + ", value=" + value
				+ "]";
	}
}

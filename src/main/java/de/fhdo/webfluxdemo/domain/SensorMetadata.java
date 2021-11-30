package de.fhdo.webfluxdemo.domain;

public class SensorMetadata {
	private String sensorId;
	private String type;

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SensorMetadata [sensorId=" + sensorId + ", type=" + type + "]";
	}
}
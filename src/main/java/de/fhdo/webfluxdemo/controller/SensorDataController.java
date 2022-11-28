package de.fhdo.webfluxdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;

import de.fhdo.webfluxdemo.service.SensorDataService;

@Controller
@RequestMapping("/sensor")
public class SensorDataController {
	private SensorDataService service;

	@Autowired
	public SensorDataController(SensorDataService service) {
		this.service = service;
	}

	@GetMapping("list")
	public String showList() {
		// Listenseite einfach anzeigen --> Rendering erfolgt per SSE
		return "list";
	}

	@GetMapping("stream")
	public String stream(Model model) {
		// Flux in "ReactiveDataDriverContextVariable" wrappen, damit Thymeleaf
		// datengetrieben arbeitet. Thymeleaf arbeitet somit als Processor, da es
		// einerseits Subscriber fuer die Daten aus dem Flux ist, diese andererseits als
		// Publisher in Form von HTML weiterstreamt. Zudem wird ein Puffer von 10
		// Elementen gesetzt.
		model.addAttribute("sensorData", new ReactiveDataDriverContextVariable(service.findTemperatureData(), 10));

		// nur Inhalte der Tabelle rendern
		return "list :: #sensorData";
	}
}

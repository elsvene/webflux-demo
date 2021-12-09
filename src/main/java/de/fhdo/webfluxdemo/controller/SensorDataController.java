package de.fhdo.webfluxdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sensor")
public class SensorDataController {
	@GetMapping("list")
	public String showList() {
		// Listenseite einfach anzeigen --> Rendering erfolgt per Websocket + DOM-Manipulation
		return "list";
	}
}

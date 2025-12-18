package de.fhdo.webfluxdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sensor")
public class SensorDataController {
	@GetMapping("list")
	public String showList() {
		// Simply display list page --> Rendering is performed via WebSocket + DOM manipulation
        return "list";
	}
}

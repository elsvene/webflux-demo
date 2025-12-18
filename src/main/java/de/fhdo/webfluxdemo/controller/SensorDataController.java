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
        // Simply display list page --> Rendering is performed via SSE
        return "list";
    }

    @GetMapping("stream")
    public String stream(Model model) {
        // Wrap flux in “ReactiveDataDriverContextVariable” so that Thymeleaf
        // works in a data-driven manner. Thymeleaf thus functions as a processor, since it
        // is a subscriber for the data from the flux on the one hand, and on the other hand
        // streams this data as a publisher in the form of HTML. In addition, a buffer of 10 elements is set.
        model.addAttribute("sensorData", new ReactiveDataDriverContextVariable(service.findTemperatureData(), 10));

        // Render only content of the table
        return "list :: #sensorData";
    }
}

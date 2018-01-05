package com.example.calculatorgui.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.List;

@Controller
@EnableDiscoveryClient
@Component
public class GuiController {

    @Autowired
    private DiscoveryClient discoveryClient;

    //RestTemplate rest = new RestTemplateBuilder().rootUri("http://localhost:8080").build();
    RestTemplate rest;

    @GetMapping("/")
    public String getGui(Model model){

        List<ServiceInstance> instances = discoveryClient.getInstances("service-unit-calculator");
        URI uri = instances.get(0).getUri();
        System.out.println("Hallo: " + uri.toString());
        rest = new RestTemplateBuilder().rootUri(uri.toString()).build();
        model.addAttribute("formData", new FormData());
        return "gui";
    }

    @PostMapping("/getWeight")
    public String convertionWeight(Model model, @ModelAttribute FormData formData){
        String rel_url = "/weight/" + formData.getFrom() + "/" + formData.getTo() + "/" +formData.getValue();
        String result = rest.getForObject(rel_url, String.class);
        FormData data = new FormData();
        data.setResultWeight(result);
        model.addAttribute("formData", data);
        return "gui";
    }

    @PostMapping("/getVolume")
    public String convertionVolume(Model model, @ModelAttribute FormData formData){
        String rel_url = "/volume/" + formData.getFrom() + "/" + formData.getTo() + "/" +formData.getValue();
        String result = rest.getForObject(rel_url, String.class);
        FormData data = new FormData();
        data.setResultVolume(result);
        model.addAttribute("formData", data);
        return "gui";
    }

    @PostMapping("/getDistance")
    public String convertionDistance(Model model, @ModelAttribute FormData formData){
        String rel_url = "/distance/" + formData.getFrom() + "/" + formData.getTo() + "/" +formData.getValue();
        String result = rest.getForObject(rel_url, String.class);
        FormData data = new FormData();
        data.setResultDistance(result);
        model.addAttribute("formData", data);
        return "gui";
    }
}

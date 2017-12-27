package com.einheitenumrechner.rechner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
public class CalculatorController {

    @Autowired
    private WeightService weightService;

    @GetMapping("/gewicht/{von}/{in}/{wert}")
    public String gewicht(@PathVariable("von") String from, @PathVariable("in") String to, @PathVariable("wert") Float value){
        return weightService.umrechung(from,to,value);
    }




}

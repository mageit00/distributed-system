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

    @Autowired
    private VolumeService volumeService;

    @Autowired
    private DistanceService distanceService;

    @GetMapping("/weight/{from}/{to}/{value}")
    public String weight(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("value") Float value){
        return weightService.convertion(from,to,value);
    }

    @GetMapping("/volume/{from}/{to}/{value}")
    public String volume(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("value") Float value){
        return volumeService.convertion(from,to,value);
    }

    @GetMapping("/distance/{from}/{to}/{value}")
    public String distance(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("value") Float value){
        return distanceService.convertion(from,to,value);
    }
}

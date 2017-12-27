package com.example.calculatorgui.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@Component
public class GuiController {

    @Value("${server.port}")
    private String port;

    public void test(){
        System.out.println("Port ------------------------------------>" + port);
    }

    RestTemplate rest = new RestTemplateBuilder().rootUri("http://localhost:" + port).build();

    @GetMapping("/get")
    public String getGui(Model model){
        model.addAttribute("formData", new FormData());
        return "gui";
    }

    @PostMapping("/getWeight")
    public String umrechnenG(Model model, @ModelAttribute FormData formData){
        String rel_url = "/gewicht/" + formData.getFrom() + "/" + formData.getTo() + "/" +formData.getValue();
        String result = rest.getForObject(rel_url, String.class);
        FormData data = new FormData();
        data.setResultWeight(result);
        model.addAttribute("formData", data);
        return "gui";
    }

    @PostMapping("/getV")
    public String umrechnenV(Model model, @ModelAttribute FormData formData){
        String rel_url = "/volumen/" + formData.getFrom() + "/" + formData.getTo() + "/" +formData.getValue();
        String result = rest.getForObject(rel_url, String.class);
        FormData data = new FormData();
        data.setResultVolume(result);
        model.addAttribute("formData", data);
        return "gui";
    }

    @PostMapping("/getS")
    public String umrechnenS(Model model, @ModelAttribute FormData formData){
        String rel_url = "/strecke/" + formData.getFrom() + "/" + formData.getTo() + "/" +formData.getValue();
        String result = rest.getForObject(rel_url, String.class);
        FormData data = new FormData();
        data.setResultDistance(result);
        model.addAttribute("formData", data);
        return "gui";
    }
}

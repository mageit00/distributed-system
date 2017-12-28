package com.einheitenumrechner.rechner.controller;

import org.springframework.stereotype.Service;

@Service
public class VolumeService {

    public String convertion (String from, String to, float value){

        if (from.equals(to)){
            return Double.toString(value);
        }
        else if(from.equals("l") && to.equals("bfu")){
            return Double.toString(value * 35.1951);
        }
        else if(from.equals("l") && to.equals("gl")){
            return Double.toString(value * 0.219969);
        }
        else if(from.equals("bfu") && to.equals("l")){
            return Double.toString(value * 0.0284131);
        }
        else if(from.equals("bfu") && to.equals("gl")){
            return Double.toString(value * 0.00625);
        }
        else if(from.equals("gl") && to.equals("l")){
            return Double.toString(value * 4.54609);
        }
        else if(from.equals("gl") && to.equals("bfu")) {
            return Double.toString(value * 160);
        }

        return "Eingabe nicht unterstützt.";
    }
}

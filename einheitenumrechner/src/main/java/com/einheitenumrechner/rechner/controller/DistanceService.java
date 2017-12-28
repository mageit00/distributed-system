package com.einheitenumrechner.rechner.controller;

import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    public String convertion (String from, String to, float value){

        if (from.equals(to)){
            return Float.toString(value);
        }
        else if(from.equals("mm") && to.equals("m")){
            return Float.toString(value / 1000);
        }
        else if(from.equals("mm") && to.equals("km")){
            return Float.toString(value / 1000000);
        }
        else if(from.equals("m") && to.equals("km")){
            return Float.toString(value / 1000);
        }
        else if(from.equals("m") && to.equals("mm")){
            return Float.toString(value * 1000);
        }
        else if(from.equals("km") && to.equals("mm")){
            return Float.toString(value / 1000000);
        }
        else if(from.equals("km") && to.equals("m")) {
            return Float.toString(value * 1000);
        }

        return "Eingabe nicht unterstützt.";
    }
}

package com.einheitenumrechner.rechner.controller;

import org.springframework.stereotype.Service;

@Service
public class WeightService {

    public String test(){
        return "bla";
    }

    public String convertion (String from, String to, float value){

        if (from.equals(to)){
            return Float.toString(value);
        }
        else if(from.equals("g") && to.equals("kg")){
            return Float.toString(value / 1000);
        }
        else if(from.equals("g") && to.equals("t")){
            return Float.toString(value / 1000000);
        }
        else if(from.equals("kg") && to.equals("g")){
            return Float.toString(value * 1000);
        }
        else if(from.equals("kg") && to.equals("t")){
            return Float.toString(value / 1000);
        }
        else if(from.equals("t") && to.equals("g")){
        return Float.toString(value * 1000000);
        }
        else if(from.equals("t") && to.equals("kg")) {
            return Float.toString(value * 1000);
        }

        return "Eingabe nicht unterstützt.";
    }
}

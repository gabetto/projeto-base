package br.edu.ifsudestemg.corrida.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CorridaController {

    @RequestMapping(value ="corrida")
    public String corrida(){
        return "corrida";
    }
}

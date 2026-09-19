package com.app.mult.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MultiplicationController {

    @GetMapping("/mult")
    public Map<String, Object> mult(@RequestParam String op1,@RequestParam String op2){
        Map<String, Object> res = new HashMap<>();

        try{
            double resultado = Double.parseDouble(op1) * Double.parseDouble(op2);
            res.put("resultado", resultado);
            res.put("hostname", InetAddress.getLocalHost().getHostName());
            return res;
        } catch(Exception e){
            res.put("resultado", "op1 ou op2 inválido");
            return res;
        }
    }

}

package com.serviciomedico.consulta.controller;

import org.springframework.web.bind.annotation.RestController;

import com.serviciomedico.consulta.service.ConsultaService;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ConsultaController {

    ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        super();
        this.consultaService = consultaService;
    }

    @GetMapping("sintoma")

    public ResponseEntity<String> consulta(@RequestParam String sintoma) {
        String resultado = consultaService.consultaLlm(sintoma);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

}

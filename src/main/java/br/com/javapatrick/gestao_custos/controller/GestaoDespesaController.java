package br.com.javapatrick.gestao_custos.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gestao")
public class GestaoDespesaController {

    @PostMapping("/create")
    public void create(){

    }
}

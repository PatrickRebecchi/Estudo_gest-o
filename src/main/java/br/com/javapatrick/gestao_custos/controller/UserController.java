package br.com.javapatrick.gestao_custos.controller;

import br.com.javapatrick.gestao_custos.dto.request.UserCadastrarRequest;
import br.com.javapatrick.gestao_custos.dto.request.UserRequest;
import br.com.javapatrick.gestao_custos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/usuarios")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserRequest> buscarUsuarios(){
        return service.buscarUsuario();

    }

    @PostMapping
    public ResponseEntity<UserCadastrarRequest> cadastrar(@RequestBody UserCadastrarRequest dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

}

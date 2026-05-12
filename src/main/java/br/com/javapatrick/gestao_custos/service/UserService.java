package br.com.javapatrick.gestao_custos.service;

import br.com.javapatrick.gestao_custos.dto.request.UserCadastrarRequest;
import br.com.javapatrick.gestao_custos.dto.request.UserRequest;
import br.com.javapatrick.gestao_custos.entity.User;
import br.com.javapatrick.gestao_custos.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public List<UserRequest> buscarUsuario() {
        return converteDados(repository.findAll());
    }

    private List<UserRequest> converteDados(List<User> usuarios) {
        return usuarios.stream()
                .map(f -> new UserRequest(
                        f.getId(),
                        f.getNome(),
                        f.getEmail()
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public UserCadastrarRequest cadastrar(UserCadastrarRequest dto) {
        if (repository.existsByEmail(dto.email())) { // vejo se existe o Email repetido no banco
            throw new RuntimeException("Email já cadastrado!");  // se existi ele retornar o erro falando que já existe
        }
        User u = new User(dto);
        repository.save(u);
        return new UserCadastrarRequest(
                u.getNome(),
                u.getEmail());
    }
}

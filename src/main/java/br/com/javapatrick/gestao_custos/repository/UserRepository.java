package br.com.javapatrick.gestao_custos.repository;


import br.com.javapatrick.gestao_custos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail( String email);

}

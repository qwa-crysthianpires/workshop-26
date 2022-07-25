package br.com.qwa.curso.repositories;

import br.com.qwa.curso.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {

}
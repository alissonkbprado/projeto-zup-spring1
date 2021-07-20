package br.com.zup.orange.projetozupspring1.repository;

import br.com.zup.orange.projetozupspring1.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String userName);
}

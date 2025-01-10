package orlando.admclientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import orlando.admclientes.entities.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}

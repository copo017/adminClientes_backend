package orlando.admclientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import orlando.admclientes.entities.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}

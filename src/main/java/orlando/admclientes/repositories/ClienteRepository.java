package orlando.admclientes.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import orlando.admclientes.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

package orlando.admclientes.services;


import org.hibernate.mapping.Map;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import orlando.admclientes.entities.Cliente;
import orlando.admclientes.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Obtener todos los clientes
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por ID
    public Cliente obtenerPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Crear o guardar un cliente
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public Cliente actualizar(Long id, Cliente cliente) {
        return clienteRepository.findById(id)
                .map(clienteExistente -> {
                    clienteExistente.setNombre(cliente.getNombre());
                    clienteExistente.setEmail(cliente.getEmail());
                    clienteExistente.setTelefono(cliente.getTelefono());
                    clienteExistente.setDireccion(cliente.getDireccion());
                    return clienteRepository.save(clienteExistente);
                })
                .orElse(null);
    }

    // Eliminar un cliente
    public boolean eliminar(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

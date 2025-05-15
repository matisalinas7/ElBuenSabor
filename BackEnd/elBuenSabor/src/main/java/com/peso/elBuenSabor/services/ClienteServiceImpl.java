package com.peso.elBuenSabor.services;

import com.peso.elBuenSabor.entities.Cliente;
import com.peso.elBuenSabor.repositories.BaseRepository;
import com.peso.elBuenSabor.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Cliente> search(String filtro) throws Exception {

        try {

            //List<Cliente> clientes = ClienteRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);

            //List<Cliente> clientes = ClienteRepository.search(filtro);

            List<Cliente> clientes = ClienteRepository.searchNativo(filtro);

            return clientes;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Cliente> clientes = ClienteRepository.searchNativo(filtro, pageable);
            return clientes;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

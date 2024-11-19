package br.com.gerenciamento.service;

import br.com.gerenciamento.model.Vendedor;
import br.com.gerenciamento.repository.VendedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public Vendedor salvarVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public List<Vendedor> listarVendedores() {
        return vendedorRepository.findAll();
    }

    public void excluirVendedor(Long id) {
        vendedorRepository.deleteById(id);
    }
}

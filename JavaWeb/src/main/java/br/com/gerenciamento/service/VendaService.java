package br.com.gerenciamento.service;

import br.com.gerenciamento.model.Venda;
import br.com.gerenciamento.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda salvarVenda(Venda venda) {
        return vendaRepository.save(venda);
        
    }

    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

    public void excluirVenda(Long id) {
        vendaRepository.deleteById(id);
    }

    public Venda buscarPorId(Long id) {
        Optional<Venda> venda = vendaRepository.findById(id);
        if (venda.isPresent()) {
            return venda.get();
        } else {
            throw new IllegalArgumentException("Venda não encontrada com o ID: " + id);
        }
    }
    public Venda atualizarVenda(Long id, Venda venda) {
        Venda vendaExistente = vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        vendaExistente.setNomeCarro(venda.getNomeCarro());
        vendaExistente.setMarcaCarro(venda.getMarcaCarro());
        vendaExistente.setPrecoCarro(venda.getPrecoCarro());
        vendaExistente.setCliente(venda.getCliente());
        return vendaRepository.save(vendaExistente);
    }
}

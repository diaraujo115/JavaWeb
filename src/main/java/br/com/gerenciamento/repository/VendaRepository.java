package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}

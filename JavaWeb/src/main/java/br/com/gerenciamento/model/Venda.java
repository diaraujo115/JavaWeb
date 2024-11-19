package br.com.gerenciamento.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCarro;
    private String marcaCarro;
  
    private BigDecimal precoCarro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

   
    public BigDecimal getComissao() {
   
        return precoCarro.multiply(new BigDecimal("0.05"));
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeCarro() { return nomeCarro; }
    public void setNomeCarro(String nomeCarro) { this.nomeCarro = nomeCarro; }
    public String getMarcaCarro() { return marcaCarro; }
    public void setMarcaCarro(String marcaCarro) { this.marcaCarro = marcaCarro; }
    public BigDecimal getPrecoCarro() { return precoCarro; }
    public void setPrecoCarro(BigDecimal preco) { this.precoCarro = preco; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Vendedor getVendedor() { return vendedor; }
    public void setVendedor(Vendedor vendedor) { this.vendedor = vendedor; }
}

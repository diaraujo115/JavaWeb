package br.com.gerenciamento.controller;

import br.com.gerenciamento.model.Venda;
import br.com.gerenciamento.service.ClienteService;
import br.com.gerenciamento.service.VendaService;
import br.com.gerenciamento.service.VendedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vendas")
public class VendaWebController {

    private final VendaService vendaService;
    private final ClienteService clienteService;
    private final VendedorService vendedorService;

    public VendaWebController(VendaService vendaService, ClienteService clienteService, VendedorService vendedorService) {
        this.vendaService = vendaService;
        this.clienteService = clienteService;
        this.vendedorService = vendedorService;
    }

    @GetMapping
    public String listarVendas(Model model) {
        model.addAttribute("vendas", vendaService.listarVendas());
        return "vendas"; // Nome do template Thymeleaf para listar vendas
    }

    @GetMapping("/novo")
    public String novaVenda(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        model.addAttribute("vendedores", vendedorService.listarVendedores());
        model.addAttribute("venda", new Venda());
        return "form-venda"; // Nome do template Thymeleaf para o formulário de vendas
    }

    @PostMapping
    public String salvarVenda(Venda venda) {
        vendaService.salvarVenda(venda);
        return "redirect:/vendas";
    }

    @GetMapping("/{id}/editar")
    public String editarVenda(@PathVariable Long id, Model model) {
        Venda venda = vendaService.buscarPorId(id);
        model.addAttribute("venda", venda);
        model.addAttribute("clientes", clienteService.listarClientes());
        model.addAttribute("vendedores", vendedorService.listarVendedores());
        return "form-venda"; // Reutilizamos o formulário para edição
    }

    @PostMapping("/{id}/editar")
    public String atualizarVenda(@PathVariable Long id, Venda vendaAtualizada) {
        Venda vendaExistente = vendaService.buscarPorId(id);
        vendaExistente.setNomeCarro(vendaAtualizada.getNomeCarro());
        vendaExistente.setMarcaCarro(vendaAtualizada.getMarcaCarro());
        vendaExistente.setPrecoCarro(vendaAtualizada.getPrecoCarro());
        vendaExistente.setCliente(vendaAtualizada.getCliente());
        vendaExistente.setVendedor(vendaAtualizada.getVendedor());
        vendaService.salvarVenda(vendaExistente);
        return "redirect:/vendas";
    }

    @GetMapping("/{id}/excluir")
    public String excluirVenda(@PathVariable Long id) {
        vendaService.excluirVenda(id);
        return "redirect:/vendas";
    }
}

package br.com.gerenciamento.controller;

import br.com.gerenciamento.model.Vendedor;
import br.com.gerenciamento.service.VendedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vendedores")
public class VendedorController {

    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @GetMapping
    public String listarVendedores(Model model) {
        model.addAttribute("vendedores", vendedorService.listarVendedores());
        return "vendedores"; 
    }

    @GetMapping("/novo")
    public String novoVendedor(Model model) {
        model.addAttribute("vendedor", new Vendedor());
        return "form-vendedor";
    }

    @PostMapping
    public String salvarVendedor(@ModelAttribute Vendedor vendedor) {
        vendedorService.salvarVendedor(vendedor);
        return "redirect:/vendedores"; 
    }

    @GetMapping("/editar/{id}")
    public String editarVendedor(@PathVariable Long id, Model model) {
        model.addAttribute("vendedor", vendedorService.listarVendedores().stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("ID não encontrado")));
        return "form-vendedor";
    }

    @GetMapping("/excluir/{id}")
    public String excluirVendedor(@PathVariable Long id) {
        vendedorService.excluirVendedor(id);
        return "redirect:/vendedores";
    }
}

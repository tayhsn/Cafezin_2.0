
package br.com.senai.projetofinal.projetofinalds2.controller;

import br.com.senai.projetofinal.projetofinalds2.dto.RequisicaoDeCompra;
import br.com.senai.projetofinal.projetofinalds2.model.Pedido;
import br.com.senai.projetofinal.projetofinalds2.model.EStatusPedido;
import br.com.senai.projetofinal.projetofinalds2.repository.PedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tayanne
 */
@Controller
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping
    public String pedidos(Model model) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "pedidos";
    }
    
    @GetMapping("/{status}")
    public String byStatus(@PathVariable("status") String status, Model model){
        List<Pedido> pedidos = pedidoRepository.findByStatus(EStatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "pedidos";
    }
    
    @GetMapping("/update/{status}")
    public String updateByStatus(RequisicaoDeCompra requisicao, @PathVariable("status") String status, Model model){
        Pedido pedido = requisicao.toUpdateStatusPedido(status);
        pedidoRepository.save(pedido);
        
        return "redirect:/pedidos/" + status;
    }
}


package br.com.senai.projetofinal.projetofinalds2.controller;

import br.com.senai.projetofinal.projetofinalds2.dto.RequisicaoDeCompra;
import br.com.senai.projetofinal.projetofinalds2.model.Pedido;
import br.com.senai.projetofinal.projetofinalds2.repository.PedidoRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tayanne
 */
@Controller
@RequestMapping("/comprar")
public class ComprarController {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @GetMapping()
    public String compra(RequisicaoDeCompra requisicao) {
        return "comprar";
    }
    
    @PostMapping("/novo")
    public String novo(@Valid RequisicaoDeCompra requisicao, BindingResult result){
        if(result.hasErrors()) {
            return "comprar";
        } else {
            Pedido pedido = requisicao.toPedido();
            pedidoRepository.save(pedido);
            return "redirect:/pedidos";
        }
    }
    
    
}


package br.com.senai.projetofinal.projetofinalds2.dto;

import br.com.senai.projetofinal.projetofinalds2.model.EStatusPedido;
import br.com.senai.projetofinal.projetofinalds2.model.Pedido;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tayanne
 */
public class RequisicaoDeCompra {
    
    private long id;
    
    @NotBlank
    private String nomeProduto;
    
    @NotNull
    private BigDecimal valorProduto;
    
    @NotBlank
    private String urlProduto;
    
    private String observacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

      
    public Pedido toPedido(){
        Pedido pedido = new Pedido();
        pedido.setObservacao(observacao);
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlProduto(urlProduto);
        pedido.setValorProduto(valorProduto);
        pedido.setStatus(EStatusPedido.AGUARDANDO);
        System.out.println("url:" +urlProduto);
        
        return pedido;
    }
    
    
    public Pedido toUpdateStatusPedido(String status){
        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedido.setObservacao(observacao);
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlProduto(urlProduto);
        pedido.setDataEntrega(LocalDate.now());
        pedido.setValorProduto(valorProduto);
        
        if(status.equals("aprovado")) pedido.setStatus(EStatusPedido.APROVADO);
        else pedido.setStatus(EStatusPedido.ENTREGUE);
        
        return pedido;
    }
}

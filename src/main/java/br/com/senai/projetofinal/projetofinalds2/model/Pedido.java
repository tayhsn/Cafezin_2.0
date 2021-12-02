
package br.com.senai.projetofinal.projetofinalds2.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Tayanne
 */
@Entity
public class Pedido {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Enumerated(EnumType.STRING)
    private EStatusPedido status;
    
    private String nomeProduto;
    private BigDecimal valorProduto;
    private String urlProduto;
    
    private String observacao;
    private LocalDate dataEntrega;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EStatusPedido getStatus() {
        return status;
    }

    public void setStatus(EStatusPedido status) {
        this.status = status;
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

    public void setUrlProduto(String urlImagem) {
        this.urlProduto = urlImagem;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
   
   
    
}

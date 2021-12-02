
package br.com.senai.projetofinal.projetofinalds2.repository;

import br.com.senai.projetofinal.projetofinalds2.model.Pedido;
import br.com.senai.projetofinal.projetofinalds2.model.EStatusPedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tayanne
 */

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    public List<Pedido> findByStatus(EStatusPedido statusPedido);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfabrica.repositories;

import com.myfabrica.entities.ItemPedido;
import com.myfabrica.entities.Pedido;
import java.math.BigDecimal;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dennis
 */
@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Long> {

    public Collection<ItemPedido> findByIdPedido(Pedido pedido);
    
}

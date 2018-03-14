/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfabrica.restcontrollers;

import com.myfabrica.entities.ItemPedido;
import com.myfabrica.entities.Pedido;
import com.myfabrica.repositories.ItemPedidoRepository;
import com.myfabrica.repositories.PrendaRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dennis
 */
@RequestMapping(value="/item_pedido", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class ItemPedidoController {
    
    @Autowired
    protected ItemPedidoRepository repository;
    
    @Autowired
    protected PrendaRepository prendaRepository;
    
    @GetMapping("/find/{id}")
    public ItemPedido find(@PathVariable Long id){
        Optional<ItemPedido> result = repository.findById(id);
        return result.isPresent()? result.get(): null;
    }
    
    @PostMapping("/save")
    public ItemPedido save(@RequestBody ItemPedido itemPedido){
        BigDecimal precioPrenda = prendaRepository.findPrecioFromPrenda(itemPedido.getIdPrenda().getId());
        double total = precioPrenda.doubleValue() * itemPedido.getCantidad();
        itemPedido.setPrecio(new BigDecimal(total));
                
        return repository.save(itemPedido);
    }
    
    @GetMapping("/findByPedido/{idPedido}")
    public Collection<ItemPedido> findByPedido(@PathVariable Long idPedido){
        return (ArrayList<ItemPedido>) repository.findByIdPedido(new Pedido(idPedido));
    }
    
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
    
    
    
}

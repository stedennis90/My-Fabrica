/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfabrica.restcontrollers;

import com.myfabrica.entities.Pedido;
import com.myfabrica.repositories.PedidoRepository;
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
@RequestMapping(value="/pedido", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class PedidoController {
    
    @Autowired
    protected PedidoRepository repository;
    
    @GetMapping("/list")
    public Collection<Pedido> list(){
        return (ArrayList<Pedido>) repository.findAll();        
    }
    
    @GetMapping("/find/{id}")
    public Pedido find(@PathVariable Long id){
        Optional<Pedido> result = repository.findById(id);
        return result.isPresent()? result.get(): null;
    }
    
    @PostMapping("/save")
    public Pedido save(@RequestBody Pedido pedido){
        return repository.save(pedido);
    }
    
    
    
    
}

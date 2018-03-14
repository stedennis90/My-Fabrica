/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfabrica.restcontrollers;

import com.myfabrica.entities.Comprador;
import com.myfabrica.repositories.CompradorRepository;
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
@RequestMapping(value="/comprador", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class CompradorController {
    
    @Autowired
    protected CompradorRepository repository;
    
    
    @GetMapping("/find/{id}")
    public Comprador find(@PathVariable Long id){
        Optional<Comprador> result = repository.findById(id);
        return result.isPresent()? result.get(): null;
    }
    
    @PostMapping("/save")
    public Comprador save(@RequestBody Comprador comprador){
        return repository.save(comprador);
    }
    
    
    
}

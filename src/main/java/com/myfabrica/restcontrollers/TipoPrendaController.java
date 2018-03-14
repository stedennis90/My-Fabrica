/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfabrica.restcontrollers;

import com.myfabrica.entities.TipoPrenda;
import com.myfabrica.repositories.TipoPrendaRepository;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dennis
 */
@RequestMapping(value="/tipo_prenda", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class TipoPrendaController {
    
    @Autowired
    protected TipoPrendaRepository repository;
    
    
    @GetMapping("/list")
    public Collection<TipoPrenda> list(){
        return (ArrayList<TipoPrenda>) repository.findAll();        
    }
    
    
}

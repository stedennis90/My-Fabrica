/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfabrica.restcontrollers;

import com.myfabrica.entities.Prenda;
import com.myfabrica.entities.TipoPrenda;
import com.myfabrica.repositories.PrendaRepository;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dennis
 */
@RequestMapping(value="/prenda", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class PrendaController {
    
    @Autowired
    protected PrendaRepository repository;
    
    
    @GetMapping("/list")
    public Collection<Prenda> list(){
        return (ArrayList<Prenda>) repository.findAll();        
    }
    
    
    @GetMapping("/listByTipoPrenda/{idTipoPrenda}")
    public Collection<Prenda> listByTipoPrenda(@PathVariable Long idTipoPrenda){
        return (ArrayList<Prenda>) repository.findByIdTipoPrenda(new TipoPrenda(idTipoPrenda));
    }
    
    
}

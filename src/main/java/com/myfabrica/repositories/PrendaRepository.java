/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfabrica.repositories;

import com.myfabrica.entities.Prenda;
import com.myfabrica.entities.TipoPrenda;
import java.math.BigDecimal;
import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dennis
 */
@Repository
public interface PrendaRepository extends CrudRepository<Prenda, Long> {
    
    public Collection<Prenda> findByIdTipoPrenda(TipoPrenda tipoPrenda);
    
    @Query(value = "select tp.precio from prenda p "
            + "inner join tipo_prenda tp on tp.id = p.id_tipo_prenda"
            + " where p.id = ?1 ",
            nativeQuery = true)
    public BigDecimal findPrecioFromPrenda(Long idPrenda);
}

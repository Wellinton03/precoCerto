/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.wellinton.precoCerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wellinton.precoCerto.entity.indicador.Indicador;
import java.util.Optional;

/**
 *
 * @author welli
 */
public interface IndicadorRepository extends JpaRepository<Indicador, Long> {
    
        Optional<Indicador> findByDescription(String description);
}

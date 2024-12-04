/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precoCerto.repository;

import com.wellinton.precoCerto.entity.cotacao.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author welli
 */

public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {
    

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.wellinton.precoCerto.entity.cotacao;

import java.time.LocalDateTime;

/**
 *
 * @author welli
 */
public record CotacaoResponseDTO(String description, LocalDateTime dataHora, Double valor) {

    
    public CotacaoResponseDTO(Cotacao cotacao) {
        this(cotacao.getIndicador().getDescription(),
                cotacao.getDataHora(),
                cotacao.getValor()
        );
        
    }
}

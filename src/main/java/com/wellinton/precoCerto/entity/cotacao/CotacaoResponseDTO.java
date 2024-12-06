/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.wellinton.precoCerto.entity.cotacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wellinton.precoCerto.entity.indicador.IndicadorResponseDTO;

import java.time.LocalDateTime;

/**
 *
 * @author welli
 */
public record CotacaoResponseDTO(Long id, IndicadorResponseDTO indicadorResponseDTO, LocalDateTime dataHora, Double valor) {
    
     public CotacaoResponseDTO(Cotacao cotacao) {
        this(
            cotacao.getId(),
            new IndicadorResponseDTO(cotacao.getIndicador()),
            cotacao.getDataHora(),
            cotacao.getValor()
        );
    }
     
     public Long getId() {
         return id;
     }
     
     public IndicadorResponseDTO getIndicadorResponseDTO() {
         return indicadorResponseDTO;
     }
     
     @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
     public LocalDateTime getDataHora() {
         return dataHora;
     }
     
     public Double getValor() {
         return valor;
     }
}

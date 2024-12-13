/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.wellinton.precoCerto.entity.cotacao;
import com.wellinton.precoCerto.entity.indicador.IndicadorDTO;
import java.time.LocalDateTime;

/**
 *
 * @author welli
 */
public class CotacaoDTO {

    private Long id;
    private IndicadorDTO indicadorDTO;
    private LocalDateTime dataHora;
    private Double valor;
    
    public CotacaoDTO() {
        
    }
    
    public CotacaoDTO(Long id, IndicadorDTO indicadorDTO, LocalDateTime dataHora, Double valor) {
        this.id = id;
        this.indicadorDTO = indicadorDTO;
        this.dataHora = dataHora;
        this.valor = valor;
    }
    
     public CotacaoDTO(Cotacao cotacao) {
        this.id = cotacao.getId();
        this.indicadorDTO = new IndicadorDTO(cotacao.getIndicador()); 
        this.dataHora = cotacao.getDataHora();
        this.valor = cotacao.getValor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IndicadorDTO getIndicadorDTO() {
        return indicadorDTO;
    }

    public void setIndicadorDTO(IndicadorDTO indicadorDTO) {
        this.indicadorDTO = indicadorDTO;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        System.out.println(dataHora);
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        System.out.println(valor);
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "CotacaoRequestDTO{" + "id=" + id + ", Indicador=" + indicadorDTO + ", dataHora=" + dataHora + ", valor=" + valor + '}';
    }
    
}

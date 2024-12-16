package com.wellinton.precoCerto.service;

import com.wellinton.precoCerto.entity.cotacao.Cotacao;
import com.wellinton.precoCerto.entity.cotacao.CotacaoDTO;
import com.wellinton.precoCerto.entity.indicador.Indicador;
import com.wellinton.precoCerto.repository.CotacaoRepository;
import com.wellinton.precoCerto.repository.IndicadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CotacaoService{

    @Autowired
    private CotacaoRepository cotacaoRepository;
    
    @Autowired
    private IndicadorRepository indicadorRepository;
    
    @Transactional
    public Cotacao salvar(CotacaoDTO data) {
       Indicador indicador = indicadorRepository.findById(data.getIndicadorDTO().getId())
            .orElseThrow(() -> new IllegalArgumentException("Indicador não encontrado"));

    Cotacao cotacao;

    if (data.getId() != null) { 
        cotacao = cotacaoRepository.findById(data.getId())
                .orElseThrow(() -> new IllegalArgumentException("Cotação não encontrada"));

        cotacao.setIndicador(indicador);
        cotacao.setDataHora(data.getDataHora());
        cotacao.setValor(data.getValor());
    } else { 
        cotacao = new Cotacao(indicador, data.getDataHora(), data.getValor());
    }
        return cotacaoRepository.save(cotacao);
    }
    
    
    @Transactional
    public void excluir(Long id) {
         Cotacao cotacao = this.cotacaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cotação não encontrada"));
                
        cotacaoRepository.delete(cotacao);
    }
    
}
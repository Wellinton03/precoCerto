package com.wellinton.precoCerto.controller;

import com.wellinton.precoCerto.entity.cotacao.CotacaoDTO;
import com.wellinton.precoCerto.repository.CotacaoRepository;
import com.wellinton.precoCerto.service.CotacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/cotacao")
public class CotacaoController {

    @Autowired
    private CotacaoRepository cotacaoRepository;
    
    @Autowired
    private CotacaoService cotacaoService;
    
    @GetMapping("/listar")
    public ResponseEntity listarCotacoes() {
        List<CotacaoDTO> todasCotacoes = this.cotacaoRepository.findAll().stream().map(CotacaoDTO::new).toList();
        return ResponseEntity.ok(todasCotacoes);
        
    }
    
    @PostMapping("/cadastrar")
    public ResponseEntity salvar(@RequestBody @Valid CotacaoDTO data) {
        try {
            System.out.println(data.toString());
            this.cotacaoService.salvar(data);
            return ResponseEntity.ok().build();
            
        } catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/editar")
    public ResponseEntity editar(@RequestBody @Valid CotacaoDTO data) {
        try {
            this.cotacaoService.salvar(data);
            return ResponseEntity.ok().build();
            
        } catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
       try{
        this.cotacaoService.excluir(id);
            return ResponseEntity.ok().build();
            
       }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
       }
        
        
    }
	
}
    









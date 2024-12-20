package com.wellinton.precoCerto.controller;

import com.wellinton.precoCerto.entity.indicador.Indicador;
import com.wellinton.precoCerto.entity.indicador.IndicadorDTO;
import com.wellinton.precoCerto.repository.IndicadorRepository;
import com.wellinton.precoCerto.service.IndicadorService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/indicador")
public class IndicadorController  {

	@Autowired
        private IndicadorRepository indicadorRepository;
        
        @Autowired
        private IndicadorService indicadorService;
	
        @GetMapping("/listar")
        public ResponseEntity listarIndicadores(){
            List<IndicadorDTO> todosIndicadores = this.indicadorRepository.findAll().stream().map(IndicadorDTO::new).toList();
            return ResponseEntity.ok(todosIndicadores);
        }
        
        @GetMapping("/{id}")
        public ResponseEntity buscarIndicador(@PathVariable Long id){
            Indicador indicador = this.indicadorRepository.findById(id)
                    .orElseThrow(()->  new IllegalArgumentException("Indicador não encontrado"));
            
            IndicadorDTO response = new IndicadorDTO(indicador);
            
            return ResponseEntity.ok(response);
        }
        
        @PostMapping("/cadastrar")
        public ResponseEntity salvar(@RequestBody @Valid IndicadorDTO data) {
                try{
                    this.indicadorService.salvar(data);
                    return ResponseEntity.ok().build();
                
                } catch (IllegalArgumentException e){
                    return ResponseEntity.badRequest().build();
                }
            
        }
        
        @PutMapping("/editar")
        public ResponseEntity editar(@RequestBody @Valid IndicadorDTO data) {
              try{
                    this.indicadorService.salvar(data);
                    return ResponseEntity.ok().build();
                
                } catch (IllegalArgumentException e){
                    return ResponseEntity.badRequest().build();
                }
        }
        
        @DeleteMapping("/excluir/{id}")
        public ResponseEntity excluir(@PathVariable Long id) {
                try{
                    this.indicadorService.excluir(id);
                    return ResponseEntity.ok().build();
                } catch (IllegalArgumentException e) {
                    return ResponseEntity.badRequest().body(e.getMessage());
                }
            
        }
}

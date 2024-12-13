/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.wellinton.precoCerto.entity.indicador;

/**
 *
 * @author welli
 */
public class IndicadorDTO {

    private String description;
    private Long id;
    
    public IndicadorDTO(Indicador indicador) {
        this.id = indicador.getId();
        this.description = indicador.getDescription();
}
    
    public IndicadorDTO() {
        
    }

    
    public IndicadorDTO(String description, Long id) {
        this.id = id;
        this.description = description;
}
    
    public IndicadorDTO(String description) {
        this.description = description;
}
    
     public String getDescription() {
        return description;
    }

     
     public Long getId() {
         return id;
     }
     
     public void setDescription(String description) {
         if (description != null) {
            this.description = description.toUpperCase();
        }
     }
     
     public void setId(Long id) {
         this.id = id;
     }

    @Override
    public String toString() {
        return "IndicadorRequestDTO{" + "description=" + description + ", id=" + id + '}';
    }
    
}

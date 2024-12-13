/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.wellinton.precoCerto.entity.user;

/**
 *
 * @author welli
 */
public class LoginDTO {
    
    private String token;
    
    public LoginDTO() {
        
    }

    public LoginDTO(String token){
        this.token = token;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    
    
    
}

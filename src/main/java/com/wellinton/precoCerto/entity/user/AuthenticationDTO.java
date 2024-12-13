/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package com.wellinton.precoCerto.entity.user;

/**
 *
 * @author welli
 */
public class AuthenticationDTO {
    
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;

    
    public AuthenticationDTO(String username, String password, String email, String role){
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    
     public AuthenticationDTO(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public AuthenticationDTO() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthenticationDTO{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role=" + role + '}';
    }
    
    
    
}

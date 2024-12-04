/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precoCerto.entity.user;

/**
 *
 * @author welli
 */
public enum UserRole {
    ADMIN("admin"),
    
    USER("user");
    
    private String role;
    
    UserRole(String role) {
        this.role = role;
    }
    
    public String getRole() {
        return role;
    }
}

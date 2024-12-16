/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wellinton.precoCerto.security;

import com.wellinton.precoCerto.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author welli
 */

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            var token  = this.recoverToken(request);
            if(token != null) {
        var login = tokenService.validateToken(token);
                UserDetails user = usuarioRepository.findByUsername(login);
                System.out.println("user " + user.toString() );
                System.out.println("Roles do usuário: " + user.getAuthorities());
                
                var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                System.out.println("Autenticação criada: " + authentication.getName() + " com authorities: " + authentication.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("SecurityContextHolder setado: " + SecurityContextHolder.getContext().getAuthentication());
                
                System.out.println("Usuário autenticado: " + authentication.getName());
                System.out.println("Roles: " + authentication.getAuthorities());
    }
            filterChain.doFilter(request, response);
    }
    
    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) 
            return null;
        return authHeader.replace("Bearer ", "");
    }
}

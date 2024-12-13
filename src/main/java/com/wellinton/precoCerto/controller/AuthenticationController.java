package com.wellinton.precoCerto.controller;


import com.wellinton.precoCerto.security.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellinton.precoCerto.entity.user.Usuario;
import jakarta.validation.Valid;
import com.wellinton.precoCerto.entity.user.AuthenticationDTO;
import com.wellinton.precoCerto.entity.user.LoginDTO;
import com.wellinton.precoCerto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	
        @Autowired
	private TokenService tokenService;
        
        @Autowired
        private AuthenticationManager authenticationManager;
        
        @Autowired
	private UsuarioService usuarioService;
        
	@PostMapping("/cadastrar")
	public ResponseEntity register(@Valid @RequestBody AuthenticationDTO data) {
		if(data.getUsername() == null || data.getPassword() == null || data.getRole() == null) {
                 
                    return ResponseEntity.badRequest().body("Valores não foram preenchidos corretamente");
                }
                    
                usuarioService.salvarUsuario(data);
                return ResponseEntity.ok().build();
        
        }
        @PostMapping("/login")
        public ResponseEntity login(@Valid @RequestBody AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword());
                var auth = authenticationManager.authenticate(usernamePassword);
                
                var token = tokenService.generatedToken((Usuario) auth.getPrincipal());
                return ResponseEntity.ok(new LoginDTO(token));
	}
}

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
import com.wellinton.precoCerto.entity.user.UserRole;
import com.wellinton.precoCerto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	
        @Autowired
	private TokenService tokenService;
        
        @Autowired
        private AuthenticationManager authenticationManager;
        
         @Autowired
        private UsuarioRepository repository;
        
	@PostMapping("/cadastrar")
	public ResponseEntity register(@Valid @RequestBody AuthenticationDTO data) {
		if(this.repository.findByUsername(data.getUsername()) != null)
                    return ResponseEntity.badRequest().build();
                
                String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
                UserRole role = UserRole.valueOf(data.getRole().toUpperCase());
                System.out.println("Role adicionada " + role); 
                Usuario usuario = new Usuario(data.getUsername(), encryptedPassword, role, data.getEmail());
                
                this.repository.save(usuario);
                
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

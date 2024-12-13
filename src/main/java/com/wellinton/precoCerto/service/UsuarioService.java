package com.wellinton.precoCerto.service;

import com.wellinton.precoCerto.entity.user.AuthenticationDTO;
import com.wellinton.precoCerto.entity.user.UserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellinton.precoCerto.entity.user.Usuario;
import com.wellinton.precoCerto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioService {

	@Autowired
        private UsuarioRepository repository;
	private final PasswordEncoder passEncoder;
	
	public UsuarioService (UsuarioRepository userRepository, PasswordEncoder passEncoder) {
		this.repository = userRepository;
		this.passEncoder = passEncoder;
	}
	
	public Usuario salvarUsuario(AuthenticationDTO data) {
            if(this.repository.findByUsername(data.getUsername()) != null) {
                throw new IllegalStateException("Usuário já existe com o username: " + data.getUsername());
        }
              String encodedPassword = passEncoder.encode(data.getPassword());
              UserRole role = UserRole.valueOf(data.getRole().toUpperCase());
                Usuario usuario = new Usuario(data.getUsername(), data.getEmail(), encodedPassword, role);
                
                return this.repository.save(usuario);
	}
}
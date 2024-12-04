package com.wellinton.precoCerto.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellinton.precoCerto.entity.user.Usuario;
import com.wellinton.precoCerto.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository userRepository;
	private final PasswordEncoder passEncoder;
	
	public UsuarioService (UsuarioRepository userRepository, PasswordEncoder passEncoder) {
		this.userRepository = userRepository;
		this.passEncoder = passEncoder;
	}
	
	public Usuario salvarUsuario(Usuario usuario) {
		
		usuario.setPassword(passEncoder.encode(usuario.getPassword()));
		
		return userRepository.save(usuario);
	}
}
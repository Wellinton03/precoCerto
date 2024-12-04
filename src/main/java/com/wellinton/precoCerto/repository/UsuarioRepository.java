package com.wellinton.precoCerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellinton.precoCerto.entity.user.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	   UserDetails findByUsername(String username);
	
}

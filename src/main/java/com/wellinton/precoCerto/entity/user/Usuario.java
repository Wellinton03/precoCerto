package com.wellinton.precoCerto.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "Usuarios")
public class Usuario implements UserDetails{

    
        public Usuario() {
        }
        
        public Usuario(Long id, String username, String email, String password, UserRole role){
            this.id = id;
            this.username = username;
            this.email = email;
            this.password = password;
            this.role = role;
        }
        
        public Usuario(String username, String password, UserRole role, String email) {
		this.username = username;
		this.password = password;
		this.role = role;
                this.email = email;
	}
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username", unique = true, nullable = false)	
	@NotBlank(message = "O Username é obrigatório")
	@Size(min = 3, max = 10, message = "o username deve ter entre 3 e 10 caracteres")
	private String username;
	
	@Column(name = "email", unique = true, nullable = false)	
	@Email(message = "O Email deve ser válido")
	@NotBlank(message = "O Email é obrigatório")
	private String email;
	
	@Column(name = "password", nullable = false)
	@Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
	@NotBlank(message = "A Senha é obrigatória")
	private String password;
        
        @Enumerated(EnumType.STRING)
        @Column(name = "role", nullable = false)
        private UserRole role;
	
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    }
    
        
        
        
@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
                else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}



	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", role=" + role + '}';
    }
        
        
        
}

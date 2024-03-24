package br.com.pupposoft.fiap.sgp.usuario.config.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.pupposoft.fiap.sgp.usuario.domain.Usuario;

public class UsuarioSecurity implements UserDetails {
	private static final long serialVersionUID = 6233130254209278036L;

	private Long id;
	private String username;
	private String password;
	private List<String> roles;
	
	public UsuarioSecurity(Usuario usuario) {
		id = usuario.getId();
		username = usuario.getEmail();
		password = usuario.getPassword();
		roles = usuario.getRoles();
	}
	
	public Usuario getDomain() {
		return Usuario.builder()
				.id(id)
				.email(username)
				.password(password)
				.roles(roles)
				.build();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r)).toList();
	}

	@Override
	public String getPassword() {
		return password;
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

}

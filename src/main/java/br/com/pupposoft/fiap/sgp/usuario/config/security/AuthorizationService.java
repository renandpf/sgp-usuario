package br.com.pupposoft.fiap.sgp.usuario.config.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.pupposoft.fiap.sgp.usuario.domain.Usuario;
import br.com.pupposoft.fiap.sgp.usuario.gateway.UsuarioRepositoryGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class AuthorizationService implements UserDetailsService {

	private UsuarioRepositoryGateway usuarioRepositoryGateway;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuarioOp = usuarioRepositoryGateway.findByUsername(username);
		
		if(usuarioOp.isPresent()) {
			return new UsuarioSecurity(usuarioOp.get());
		}
		log.warn("Usuário não encontrado: {}", username);
		throw new UsernameNotFoundException(username);
	}

}

package br.com.pupposoft.fiap.sgp.usuario.gateway;

import java.util.Optional;

import br.com.pupposoft.fiap.sgp.usuario.domain.Usuario;

public interface UsuarioRepositoryGateway {

	Optional<Usuario> findByUsername(String username);

	Long salvar(Usuario usuario);
	

}

package br.com.pupposoft.fiap.sgp.usuario.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pupposoft.fiap.sgp.usuario.domain.Usuario;
import br.com.pupposoft.fiap.sgp.usuario.exception.UsuarioJaExisteException;
import br.com.pupposoft.fiap.sgp.usuario.gateway.UsuarioRepositoryGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class CriarUsuarioUseCase {

	private UsuarioRepositoryGateway usuarioRepositoryGateway;

	public Long criar(Usuario usuario) {
		Optional<Usuario> usuarioOp = usuarioRepositoryGateway.findByUsername(usuario.getEmail());

		if(usuarioOp.isPresent()) {
			log.warn("Usuário ja existe com username informado. {}", usuario.getEmail());
			throw new UsuarioJaExisteException();
		}

		return usuarioRepositoryGateway.salvar(usuario);
	}
}


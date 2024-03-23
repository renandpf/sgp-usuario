package br.com.pupposoft.fiap.sgp.usuario.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pupposoft.fiap.sgp.usuario.domain.Usuario;
import br.com.pupposoft.fiap.sgp.usuario.exception.UsuarioNaoEncontradoExcepion;
import br.com.pupposoft.fiap.sgp.usuario.gateway.UsuarioRepositoryGateway;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ObterUsuarioUseCase {

	private UsuarioRepositoryGateway usuarioRepositoryGateway;
	
	public Usuario obterPorUsuarioId(Long userId) {
		Optional<Usuario> usuarioOp =  usuarioRepositoryGateway.findById(userId);
		
		if(usuarioOp.isEmpty()) {
			log.warn("Usuário não encontrado: {}", userId);
			throw new UsuarioNaoEncontradoExcepion();
		}
		
		return null;
	}

}

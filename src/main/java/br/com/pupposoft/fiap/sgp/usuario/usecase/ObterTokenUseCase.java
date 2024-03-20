package br.com.pupposoft.fiap.sgp.usuario.usecase;

import org.springframework.stereotype.Service;

import br.com.pupposoft.fiap.sgp.usuario.domain.Usuario;
import br.com.pupposoft.fiap.sgp.usuario.gateway.TokenGateway;

@Service
public class ObterTokenUseCase {
	
	private TokenGateway tokenGateway;

	public String obter(Usuario usuario) {
		return tokenGateway.getToken(usuario);
	}
	
}

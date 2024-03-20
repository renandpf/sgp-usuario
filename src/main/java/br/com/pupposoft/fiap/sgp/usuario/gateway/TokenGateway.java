package br.com.pupposoft.fiap.sgp.usuario.gateway;

import br.com.pupposoft.fiap.sgp.usuario.domain.Usuario;

public interface TokenGateway {
	
	String getToken(Usuario usuario);

}

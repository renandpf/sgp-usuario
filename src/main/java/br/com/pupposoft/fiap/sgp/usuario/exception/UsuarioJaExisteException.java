package br.com.pupposoft.fiap.sgp.usuario.exception;

import br.com.pupposoft.fiap.starter.exception.SystemBaseException;
import lombok.Getter;

@Getter
public class UsuarioJaExisteException extends SystemBaseException {
	private static final long serialVersionUID = -8176335525249182470L;
	
	private final String code = "sgp.usuarioJaExiste";//NOSONAR
	private final String message = "Ja existe usuário com username informado";//NOSONAR
	private final Integer httpStatus = 422;//NOSONAR

}

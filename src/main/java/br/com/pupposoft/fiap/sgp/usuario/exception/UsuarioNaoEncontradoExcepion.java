package br.com.pupposoft.fiap.sgp.usuario.exception;

import br.com.pupposoft.fiap.starter.exception.SystemBaseException;
import lombok.Getter;

@Getter
public class UsuarioNaoEncontradoExcepion extends SystemBaseException {
	private static final long serialVersionUID = 7523777259462534303L;
	
	private final String code = "sgp.usuarioNaoEncontrado";//NOSONAR
	private final String message = "Usuário não encontrado";//NOSONAR
	private final Integer httpStatus = 404;//NOSONAR
}

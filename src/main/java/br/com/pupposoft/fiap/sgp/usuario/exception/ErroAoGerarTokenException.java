package br.com.pupposoft.fiap.sgp.usuario.exception;

import br.com.pupposoft.fiap.starter.exception.SystemBaseException;
import lombok.Getter;

@Getter
public class ErroAoGerarTokenException extends SystemBaseException {
	private static final long serialVersionUID = 6729291256372725161L;
	
	private final String code = "sgp.erroAoGerarToken";//NOSONAR
	private final String message = "Erro ao gerar o token";//NOSONAR
	private final Integer httpStatus = 500;//NOSONAR
}

package br.com.pupposoft.fiap.sgp.usuario.exception;

import br.com.pupposoft.fiap.starter.exception.SystemBaseException;
import lombok.Getter;

@Getter
public class ErroAoAcessarRepositorioDadosException extends SystemBaseException {
	private static final long serialVersionUID = 7523777259462534303L;
	
	private final String code = "sgp.erroAoAcessarRepositorioDados";//NOSONAR
	private final String message = "Erro ao gerar o repositório de dados";//NOSONAR
	private final Integer httpStatus = 500;//NOSONAR
}

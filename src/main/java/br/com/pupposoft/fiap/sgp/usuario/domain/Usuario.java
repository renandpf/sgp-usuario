package br.com.pupposoft.fiap.sgp.usuario.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Usuario {
	private Long id;
	private String email;
	private String password;
	private List<String> roles;
}

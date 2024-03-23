package br.com.pupposoft.fiap.sgp.usuario.controller.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.pupposoft.fiap.sgp.usuario.domain.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UsuarioJson {
	private Long id;
	private String username; 
	private String password;
	private List<String> roles;
	
	public UsuarioJson(Usuario usuario) {
		id = usuario.getId();
		username = usuario.getEmail();
		roles = usuario.getRoles();
	}
	
	@JsonIgnore
	public Usuario getDomain() {
		return Usuario.builder()
				.id(id)
				.email(username)
				.password(password)
				.roles(roles)
				.build();
	}
}

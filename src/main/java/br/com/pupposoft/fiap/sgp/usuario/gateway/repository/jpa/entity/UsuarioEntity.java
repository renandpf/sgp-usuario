package br.com.pupposoft.fiap.sgp.usuario.gateway.repository.jpa.entity;

import java.util.Arrays;

import br.com.pupposoft.fiap.sgp.usuario.domain.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Usuario")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String role;
	
	public UsuarioEntity(Usuario usuario, String password) {
		this.id = usuario.getId();
		this.username = usuario.getEmail();
		this.password = password;
		this.role = usuario.getRoles().get(0);
	}
	
	public Usuario mapperToDomain() {
		return Usuario.builder()
				.id(id)
				.email(username)
				.password(password)
				.roles(Arrays.asList(role))
				.build();
	}
}

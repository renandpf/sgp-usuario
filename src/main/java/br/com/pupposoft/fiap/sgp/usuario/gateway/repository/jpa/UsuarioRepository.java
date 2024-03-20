package br.com.pupposoft.fiap.sgp.usuario.gateway.repository.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pupposoft.fiap.sgp.usuario.gateway.repository.jpa.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

	Optional<UsuarioEntity> findByUsername(String login);

}

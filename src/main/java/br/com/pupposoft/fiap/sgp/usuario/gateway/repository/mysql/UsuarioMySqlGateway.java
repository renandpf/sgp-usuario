package br.com.pupposoft.fiap.sgp.usuario.gateway.repository.mysql;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.pupposoft.fiap.sgp.usuario.domain.Usuario;
import br.com.pupposoft.fiap.sgp.usuario.exception.ErroAoAcessarRepositorioDadosException;
import br.com.pupposoft.fiap.sgp.usuario.gateway.UsuarioRepositoryGateway;
import br.com.pupposoft.fiap.sgp.usuario.gateway.repository.jpa.UsuarioRepository;
import br.com.pupposoft.fiap.sgp.usuario.gateway.repository.jpa.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class UsuarioMySqlGateway implements UsuarioRepositoryGateway {

	private UsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> findByUsername(String username) {
		try {
			Optional<Usuario> usuarioOp = Optional.empty();		
			
			Optional<UsuarioEntity> usuarioEntityOp = usuarioRepository.findByUsername(username);
			
			if(usuarioEntityOp.isPresent()) {
				Usuario usuarioFound = usuarioEntityOp.get().mapperToDomain();
				usuarioOp = Optional.of(usuarioFound);
			}
			
			return usuarioOp;
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarRepositorioDadosException();
		}
		
	}

	@Override
	public Long salvar(Usuario usuario) {
		try {
			String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());
			
			UsuarioEntity usuarioEntity = new UsuarioEntity(usuario, encryptedPassword);
			
			return usuarioRepository.save(usuarioEntity).getId();
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarRepositorioDadosException();
		}
	}

	@Override
	public Optional<Usuario> findById(Long userId) {
		try {
			Optional<UsuarioEntity> usuarioEntityOp = usuarioRepository.findById(userId);
			if(usuarioEntityOp.isPresent()) {
				UsuarioEntity usuarioEntity = usuarioEntityOp.get();
				return Optional.of(usuarioEntity.mapperToDomain());
			}
			
			return Optional.empty(); 
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarRepositorioDadosException();
		}		
	}
}

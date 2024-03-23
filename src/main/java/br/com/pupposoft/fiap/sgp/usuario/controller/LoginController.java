package br.com.pupposoft.fiap.sgp.usuario.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pupposoft.fiap.sgp.usuario.config.security.UsuarioSecurity;
import br.com.pupposoft.fiap.sgp.usuario.controller.json.UsuarioJson;
import br.com.pupposoft.fiap.sgp.usuario.domain.Usuario;
import br.com.pupposoft.fiap.sgp.usuario.usecase.CriarUsuarioUseCase;
import br.com.pupposoft.fiap.sgp.usuario.usecase.ObterTokenUseCase;
import br.com.pupposoft.fiap.sgp.usuario.usecase.ObterUsuarioUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("usuarios")
@AllArgsConstructor
public class LoginController {
	
	private AuthenticationManager authenticationManager;
	
	private ObterTokenUseCase obterTokenUseCase;
	
	private CriarUsuarioUseCase criarUsuarioUseCase;

	private ObterUsuarioUseCase obterUsuarioUseCase;
	
	@PostMapping("login")
	public String login(@RequestBody UsuarioJson responseJson) {
		log.trace("Start responseJson={}", responseJson);
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(responseJson.getUsername(), responseJson.getPassword());
		Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        
        UsuarioSecurity principal = (UsuarioSecurity) authentication.getPrincipal();
		
		Usuario usuario = principal.getDomain();
		
		String token = obterTokenUseCase.obter(usuario);
		
		log.trace("End token={}", token);
		return token;
	}

	@PostMapping
	public Long salvar(@RequestBody UsuarioJson usuarioJson) {
		log.trace("Start usuarioJson={}", usuarioJson);
		
		Usuario usuario = usuarioJson.getDomain();
		
		Long idUsuario = criarUsuarioUseCase.criar(usuario);
		
		log.trace("End idUsuario={}", idUsuario);
		return idUsuario;
	}
	
	@GetMapping
	public UsuarioJson obterPorUserId(@PathVariable("userId") Long userId) {
		log.trace("Start userId={}", userId);
		
		Usuario usuario = obterUsuarioUseCase.obterPorUsuarioId(userId);
		
		UsuarioJson usuarioJson = new UsuarioJson(usuario);
		
		log.trace("End usuarioJson={}", usuarioJson);
		return usuarioJson;
	}
	
}

package br.com.mai05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mai05.dto.TokenDto;
import br.com.mai05.form.LoginForm;
import br.com.mai05.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService; 
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticarUser(@RequestBody LoginForm loginForm){
		UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();
		//System.out.println("get principal  " + dadosLogin.getPrincipal());
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			//System.out.println(token);
			return ResponseEntity.ok(new TokenDto(token , "Bearer"));			
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}
	}	

}

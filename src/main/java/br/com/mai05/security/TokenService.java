package br.com.mai05.security;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.mai05.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		User userLogado = (User) authentication.getPrincipal();
		System.out.println(userLogado.getUsername());
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API MAI05")
				.setSubject(userLogado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();		
	}

	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);			
		} catch (Exception e) {
			return false;
		}
		
		return false;
	}

	public Long getIdUser(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}
}

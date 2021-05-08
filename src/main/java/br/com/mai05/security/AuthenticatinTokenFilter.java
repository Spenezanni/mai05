package br.com.mai05.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.mai05.model.User;
import br.com.mai05.repository.UserRepository;

public class AuthenticatinTokenFilter extends OncePerRequestFilter {
	

	private TokenService tokenService;
	
	private UserRepository userRepository;
	
	public AuthenticatinTokenFilter(TokenService tokenService, UserRepository userRepository) {
		super();
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request); 
		System.out.println(token);
		boolean valido = tokenService.isTokenValido(token);
		if(valido) {
			autenticar(token);
		}
		
		filterChain.doFilter(request, response);
		
	}

	private void autenticar(String token) {
		Long IdUser = tokenService.getIdUser(token);
		User user = userRepository.findById(IdUser).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String tokenHeader = request.getHeader("Authorization");
		if(tokenHeader == null || tokenHeader.isEmpty() || !tokenHeader.startsWith("Bearer ")) {
		return null;
		}
		return tokenHeader.substring(7, tokenHeader.length());
	}
}
	



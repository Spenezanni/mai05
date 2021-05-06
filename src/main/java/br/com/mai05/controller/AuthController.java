package br.com.mai05.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mai05.form.UserForm;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@PostMapping
	public ResponseEntity<?> autenticarUser(@RequestBody UserForm userForm){
		System.out.println(userForm.getLogin());
		return ResponseEntity.ok().build();
	}

}

package com.logueo.spring.Services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	public boolean verificarContraseña(String passwordplana, String password) {
		
		return BCrypt.checkpw(passwordplana, password);
	}
	

}

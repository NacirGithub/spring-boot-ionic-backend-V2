package com.devprime.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devprime.cursomc.domain.Cliente;
import com.devprime.cursomc.repositories.ClienteRepository;
import com.devprime.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pwrdEnconder;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();

	public void sendNewPassword(String email) {
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) {
			throw new ObjectNotFoundException("Email nao encontrado!");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pwrdEnconder.encode(newPass));
		
		clienteRepository.save(cliente);
		
		emailService.sendNewPasswordEmail(cliente, newPass);
	}
	
	private String newPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}
				
		return new String(vet );
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // gera 1 digito
			return (char) (rand.nextInt(10) + 48);
		}
		else if(opt == 1) {// gera letra Maiuscula
			return (char) (rand.nextInt(26) + 65);
		}
		else {// gera letra minuscula
			return (char) (rand.nextInt(26) + 97 );
		}
	}
}

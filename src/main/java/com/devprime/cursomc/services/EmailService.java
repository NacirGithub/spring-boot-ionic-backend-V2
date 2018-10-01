package com.devprime.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.devprime.cursomc.domain.Pedido;

public interface EmailService  {

	void sendOrderConfirmation(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}

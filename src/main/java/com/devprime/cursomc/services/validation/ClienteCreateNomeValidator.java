package com.devprime.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.devprime.cursomc.domain.enums.TipoCliente;
import com.devprime.cursomc.dto.ClienteNewDTO;
import com.devprime.cursomc.resources.exceptions.FieldMessage;
import com.devprime.cursomc.services.validation.utils.BR;

public class ClienteCreateNomeValidator implements ConstraintValidator<ClienteCreate, ClienteNewDTO> {
	
	@Override
	public void initialize(ClienteCreate ann) {
	}
	

	@Override
	public boolean isValid(ClienteNewDTO objDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if (objDTO.getTipoCliente().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDTO.getCodigoPostal())) {
			list.add(new FieldMessage("codigoPostal", "Codigo Postal invalido"));
		}
		
		if (objDTO.getTipoCliente().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDTO.getCodigoPostal())) {
			list.add(new FieldMessage("codigoPostal", "Codigo Postal 2 invalido "));
		}
		
		// inclua os testes aqui, inserindo erros na lista
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}

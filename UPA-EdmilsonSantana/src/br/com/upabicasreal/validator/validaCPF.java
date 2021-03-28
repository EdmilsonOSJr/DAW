package br.com.upabicasreal.validator;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

@FacesValidator("validaCPF")
public class validaCPF implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		CPFValidator cpfValidator = new CPFValidator();

		String valor = value.toString();

		List<ValidationMessage> erros = cpfValidator.invalidMessagesFor(valor);

		if (erros.size() > 0)
			throw new ValidatorException(new FacesMessage("Cpf inválido."));
	}

}

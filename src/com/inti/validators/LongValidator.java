package com.inti.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "longitudeValidator")
public class LongValidator implements Validator{
    protected static final String LONGITUDE_PATTERN="^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$";


	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Float longitude = (Float) value;
		Pattern mask = null;
		mask = Pattern.compile(LONGITUDE_PATTERN);
		Matcher matcher = mask.matcher(String.valueOf(longitude));
		if(!matcher.matches()) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Please enter a valid longitude");
			message.setSummary("Longitude not valid");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
	}

}

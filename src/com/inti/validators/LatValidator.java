package com.inti.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "latitudeValidator")
public class LatValidator implements Validator{
	protected static final String LATITUDE_PATTERN="^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$";
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Float latitude = (Float) value;
		Pattern mask = null;
		mask = Pattern.compile(LATITUDE_PATTERN);
		Matcher matcher = mask.matcher(String.valueOf(latitude));
		if(!matcher.matches()) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Please enter a valid latitude");
			message.setSummary("Latitude not valid");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
	}
    
}

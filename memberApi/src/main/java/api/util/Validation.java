package api.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import api.model.Member;


@Component
public class Validation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Member.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Member member = null;
		long id = 0;
		if(target instanceof Member)member = (Member)target;
		if(target instanceof Long)id = (Integer)target;
		
		if(id < 0)errors.reject("id", "id is not valid ");
		if(!isValidPostalCode(member.getPostalCode()))errors.reject("postalCode", "postalCode is not valid");
		validate (errors);
		
	}
	
	private boolean isValidPostalCode(String postalCode){
		
		String zipCodePattern = "\\d{5}(-\\d{4})?";
		
		return postalCode.matches(zipCodePattern)? true : false;	
		
	}
	
	public void  validate (Errors errors)throws ValidationException{
		
		if(errors.hasErrors()){
			throw new ValidationException("invalid data...");
		}
	}

}

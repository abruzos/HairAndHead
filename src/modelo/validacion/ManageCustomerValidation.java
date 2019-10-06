package modelo.validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PARA DECLARAR QUE TIPO DE DATO O FORMATO QUE RECIVE 
 * DESDE LA VISTA LOS CONTROLADORES DE GESTIONAR CLIENTE.
 */
public class ManageCustomerValidation
{
	
	// CONSTRUCTOR VACIO
	public ManageCustomerValidation(){}
	
	public boolean validMail(String mail)
	{		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mail);
		return matcher.matches();
	}

	
	
}

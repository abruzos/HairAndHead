package modelo.validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PARA DECLARAR QUE TIPO DE DATO O FORMATO QUE RECIVE 
 * DESDE LA VISTA LOS CONTROLADORES DE PAGO
 */
public class PaymentValidation
{
	
	// CONSTRUCTOR VACIO
	public PaymentValidation(){}
	
	public boolean validNumber(String number)
	{
		String regex = "^[0-9]{1,5}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(number);
		return matcher.matches();
	}
	
}

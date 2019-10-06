package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.CustomerDTO;
import presentacion.vista.PaymentDebtWindow;

public class ControllerPaymentDebt implements ActionListener{
	
	private PaymentDebtWindow _view;
	private CustomerDTO _customer;
	
	public ControllerPaymentDebt(PaymentDebtWindow view, CustomerDTO customer)
	{
		_view = view;
		_customer = customer;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}

}

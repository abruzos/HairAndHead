package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.CustomerDTO;
import presentacion.vista.PaymentPointsWindow;

public class ControllerPaymentPoints implements ActionListener{
	
	private PaymentPointsWindow _view;
	private CustomerDTO _customer;
	
	public ControllerPaymentPoints(PaymentPointsWindow view, CustomerDTO customer)
	{
		_view = view;
		_customer = customer;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}

}

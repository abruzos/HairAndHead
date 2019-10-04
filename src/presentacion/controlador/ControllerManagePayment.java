package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Customer;
import presentacion.vista.ManagePaymentWindow;

public class ControllerManagePayment implements ActionListener{
	
	private ManagePaymentWindow _view;
	private Customer _customer;
	
	public ControllerManagePayment(ManagePaymentWindow view, Customer customer)
	{
		_view = view;
		_customer = customer;
		_view.selectPayment().addActionListener(select -> choosePaymentWindow(select));
	}
	
	// 
	private void choosePaymentWindow(ActionEvent select)
	{
		//...
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{	
	}

}

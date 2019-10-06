package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentacion.vista.PaymentCashWindow;

public class ControllerPaymentCash implements ActionListener{
	
	@SuppressWarnings("unused")
	private PaymentCashWindow _view;
	
	public ControllerPaymentCash(PaymentCashWindow view )
	{
		_view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}

}

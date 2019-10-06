package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentacion.vista.PaymentPointsWindow;

public class ControllerPaymentPoints implements ActionListener{
	
	@SuppressWarnings("unused")
	private PaymentPointsWindow _view;
	
	public ControllerPaymentPoints(PaymentPointsWindow view )
	{
		_view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}

}

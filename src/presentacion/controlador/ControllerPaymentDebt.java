package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentacion.vista.PaymentDebtWindow;

public class ControllerPaymentDebt implements ActionListener{
	
	@SuppressWarnings("unused")
	private PaymentDebtWindow _view;
	
	public ControllerPaymentDebt(PaymentDebtWindow view )
	{
		_view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}

}

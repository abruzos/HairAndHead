package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Customer;
import dto.CustomerDTO;
import presentacion.vista.PaymentCashWindow;

public class ControllerPaymentCash implements ActionListener{
	
	private PaymentCashWindow _viewPaymentCash;
	private CustomerDTO _customer;
	
	public ControllerPaymentCash(PaymentCashWindow view, CustomerDTO customer)
	{
		_viewPaymentCash = view;
		_customer = customer;
		loadInformationClient();
		_viewPaymentCash.getBtnAccept().addActionListener(Pay -> makePayment(Pay));
		_viewPaymentCash.getBtnCancel().addActionListener(Pay -> makePayment(Pay));
//		_viewPaymentCash.getBtnReport().addActionListener(report -> showReport(report));
	}

	private void loadInformationClient()
	{
		_viewPaymentCash.getTxtServiceCost().setText(Customer.CostService(_customer));
		_viewPaymentCash.getTxtDepositedCash().setText(Customer.CurrentDebt(_customer));
	}

	// ACCION DEL BOTON PAGAR.
	private void makePayment(ActionEvent pay)
	{
		int payment = Integer.valueOf(_viewPaymentCash.getTxtDepositedCash().getText());
		int debt = Integer.valueOf(_viewPaymentCash.getTxtCurrentDebt().getText());
		updatePayment(payment);
		updateDebt(debt);
	}

	// ACCIONES QUE REALIZA CON UN PAGO.
	private void updatePayment(int payment)
	{
		//...
	}

	// ACTUALIZA LA DEUDA
	private void updateDebt(int debt) {
		debt = _customer.getDebt().getCost() - debt;
		_customer.getDebt().setCost(debt);
	}
	
	// ACCION DEL BOTON REPORTE.
	private void showReport(ActionEvent report)
	{
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
	}

}

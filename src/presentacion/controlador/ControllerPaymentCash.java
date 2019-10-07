package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import modelo.Customer;
import persistencia.dao.implementacion.PaymentJPA;
import dto.CustomerDTO;
import dto.PaymentDTO;
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
		_viewPaymentCash.getTxtCurrentDebt().setText(Customer.CurrentDebt(_customer));
		_viewPaymentCash.getTxtTotalToPay().setText(String.valueOf(summationServiceAndDebt()));
	}
	
	private int summationServiceAndDebt() 
	{
		int totalToPayment = Integer.valueOf(Customer.CostService(_customer)) + Integer.valueOf(Customer.CurrentDebt(_customer));
		return totalToPayment;
	}
	// ACCION DEL BOTON PAGAR.
	private void makePayment(ActionEvent pay)
	{
		int payment = Integer.valueOf(_viewPaymentCash.getTxtDepositedCash().getText());
//		int debt = Integer.valueOf(_viewPaymentCash.getTxtCurrentDebt().getText());
		updatePayment(payment);
//		updateDebt(debt);
	}

	// ACCIONES QUE REALIZA CON UN PAGO.
	private void updatePayment(int payment)
	{
		PaymentDTO paymentCurrent = new PaymentDTO();
		PaymentJPA payDAO = new PaymentJPA();
		paymentCurrent.setState("Pagado");
		paymentCurrent.setDateTimePay(LocalDateTime.now());
		payDAO.update(paymentCurrent);
	}

	// ACTUALIZA LA DEUDA
//	private void updateDebt(int debt) {
//		debt = _customer.getDebt().getCost() - debt;
//		_customer.getDebt().setCost(debt);
//	}
	
	// ACCION DEL BOTON REPORTE.
//	private void showReport(ActionEvent report)
//	{
//		
//	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
	}

}
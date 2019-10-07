package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import dto.CustomerDTO;
import dto.PaymentDTO;
import modelo.Bag;
import modelo.Customer;
import persistencia.dao.implementacion.PaymentJPA;
import presentacion.vista.PaymentPointsWindow;

public class ControllerPaymentPoints implements ActionListener{
	
	private PaymentPointsWindow _viewPaymentPoints;
	private CustomerDTO _customer;
	private Bag bag;
	
	public ControllerPaymentPoints(PaymentPointsWindow view, CustomerDTO customer)
	{
		_viewPaymentPoints = view;
		_customer = customer;
		loadInformationClient();
		_viewPaymentPoints.getBtnAccept().addActionListener(Pay -> makePayment(Pay));
		_viewPaymentPoints.getBtnCancel().addActionListener(Cancel -> close(Cancel));
	}
	
	private void loadInformationClient()
	{
		_viewPaymentPoints.getTxtServiceCost().setText(Customer.CostService(_customer));
		_viewPaymentPoints.getTxtPointsUsed().setText(Customer.AccumulatedPoints(_customer));
	}
	
	private void makePayment(ActionEvent pay)
	{
		PaymentDTO paymentCurrent = new PaymentDTO();
		PaymentJPA payDAO = new PaymentJPA();
		paymentCurrent.setState("Pagado");
		paymentCurrent.setDateTimePay(LocalDateTime.now());
		payDAO.update(paymentCurrent);
	}

	private void close(ActionEvent cancel)
	{
		_viewPaymentPoints.cerrar();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{

	}
}
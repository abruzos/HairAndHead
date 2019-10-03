package modelo;

import java.util.List;

import dto.PaymentDTO;
import persistencia.dao.implementacion.PaymentJPA;
import persistencia.dao.interfaz.PaymentDAO;


public class Payment 
{
	private PaymentDAO _payment;
	
	public PaymentDAO createPaymentDAO() 
	{
		return new PaymentJPA();
	}

	public void createPayment(PaymentDTO newPayment) throws Exception 
	{
		_payment.create(newPayment);
	}
	
	public void deletePayment(PaymentDTO deletePayment) throws Exception 
	{
		_payment.delete(deletePayment);
	}
	
	//Modificacion de un pago.
	public void updatePayment(PaymentDTO updatePayment) throws Exception 
	{
		_payment.update(updatePayment);
	}
	
	//Retorno de un pago por ID
		public void getPaymentID(long paymentID) throws Exception 
		{
			_payment.byId(paymentID);
		}
	
	//Lista de todos los pagos (DENTRO DEL SISTEMA)
	public List<PaymentDTO> obtainPayments() throws Exception 
	{
		return _payment.all();
	}
	
	// Devuelve la diferencia del Costo (CostoTotalServicio Vs Cartera-Cliente(puntos))
	public int paymentWithPoints(PaymentDTO paymentPoints)
	{
		//List<TurnDTO> turns, CustomerDTO client
		return 0;
	}
	
	// Recibe el pago que tiene una lista de turnos-servicios.
	public int getServiceCost(PaymentDTO listTurn)
	{
		
		return 0;
	}
	
}
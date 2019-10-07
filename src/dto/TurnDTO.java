package dto;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TurnDTO 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	private LocalDateTime _reservationDay;
	private LocalDateTime _serviceDay;
	private String _state;
	
	@ManyToOne
	private ServiceDTO _service;

	@ManyToOne
	private CustomerDTO _customerTurn;
	
	@ManyToOne
	private ProfessionalDTO _professionalt;
	
	@ManyToOne
	private PaymentDTO _turnsPayment;
	
	public TurnDTO (LocalDateTime reservationDay, LocalDateTime serviceDay, String state)
	{
		_reservationDay = reservationDay;
		_serviceDay = serviceDay;
		_state = state;
	}
	
	public TurnDTO() {}

	public LocalDateTime getReservationDay() 
	{
		return _reservationDay;
	}

	public LocalDateTime getServiceDay() 
	{
		return _serviceDay;
	}
		
	public String getState()
	{
		return _state;
	}
	
	public ServiceDTO getService() 
	{
		return _service;
	}
	
	public CustomerDTO getCustomer()
	{
		return _customerTurn;
	}
	
	public ProfessionalDTO getProfessional()
	{
		return _professionalt;
	}
	
	public PaymentDTO getTurnsPayment(PaymentDTO turnsPayment)
	{
		return _turnsPayment;
	}
	
	public void setReservationDay(LocalDateTime reservationDay) 
	{
		_reservationDay = reservationDay;
	}

	public void setServiceDay(LocalDateTime serviceDay) 
	{
		_serviceDay = serviceDay;
	}

	public void setState(String state) 
	{
		_state = state;
	}
	
	public void setService(ServiceDTO service)
	{
		_service = service;
	}
	
	public void setCustomerTurn(CustomerDTO customer) 
	{
		_customerTurn = customer;
	}

	public void setProfessional(ProfessionalDTO professional) 
	{
		_professionalt = professional;
	}
	
	public void setTurnsPayment(PaymentDTO turnsPayment)
	{
		_turnsPayment = turnsPayment;
	}
	
	@Override
	public String toString() {
		return _serviceDay.toString();
	}
}
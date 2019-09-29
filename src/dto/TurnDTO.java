package dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class TurnDTO 
{
	@Id
	@GeneratedValue
	private int _id;
	private LocalDate _reservationDay;
	private LocalDate _serviceDay;
	private String _state;
	
	@OneToOne
	private ServiceDTO _service;

	@ManyToOne
	private CustomerDTO _customer;
	
	public TurnDTO (LocalDate reservationDay, LocalDate serviceDay, String state)
	{
		_reservationDay = reservationDay;
		_serviceDay = serviceDay;
		_state = state;
	}

	public LocalDate getReservationDay() 
	{
		return _reservationDay;
	}

	public LocalDate getServiceDay() 
	{
		return _serviceDay;
	}
	
	public ServiceDTO getService() 
	{
		return _service;
	}
	
	public String getState()
	{
		return _state;
	}
	
	public void setReservationDay(LocalDate reservationDay) 
	{
		_reservationDay = reservationDay;
	}

	public void setServiceDay(LocalDate serviceDay) 
	{
		_serviceDay = serviceDay;
	}

	public void setService(ServiceDTO service)
	{
		_service = service;
	}

	public void setState(String state) 
	{
		_state = state;
	}
}
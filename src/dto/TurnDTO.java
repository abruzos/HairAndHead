package dto;

import java.time.LocalDateTime;
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
	private LocalDateTime _reservationDay;
	private LocalDateTime _serviceDay;
	private String _state;
	
	@OneToOne
	private ServiceDTO _service;

	@ManyToOne
	private CustomerDTO _customer;
	
	public TurnDTO (LocalDateTime reservationDay, LocalDateTime serviceDay, String state)
	{
		_reservationDay = reservationDay;
		_serviceDay = serviceDay;
		_state = state;
	}

	public LocalDateTime getReservationDay() 
	{
		return _reservationDay;
	}

	public LocalDateTime getServiceDay() 
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
	
	public void setReservationDay(LocalDateTime reservationDay) 
	{
		_reservationDay = reservationDay;
	}

	public void setServiceDay(LocalDateTime serviceDay) 
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
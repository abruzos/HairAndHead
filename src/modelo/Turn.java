package modelo;

import java.time.LocalDate;

public class Turn 
{
	private LocalDate _reservationDay;
	private LocalDate _serviceDay;
	private Service _service;
	private String _state;
	
	public Turn (LocalDate reservationDay, LocalDate serviceDay, Service service, String state)
	{
		_reservationDay = reservationDay;
		_serviceDay = serviceDay;
		_service = service;
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
	
	public Service getService() 
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

	public void setService(Service service)
	{
		_service = service;
	}

	public void setState(String state) 
	{
		_state = state;
	}
}
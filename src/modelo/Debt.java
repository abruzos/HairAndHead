package modelo;

import java.time.LocalDate;

public class Debt 
{
	private int _cost;
	private LocalDate _expiration;
	
	public Debt(int cost, LocalDate expiration) 
	{	
		_cost = cost;
		_expiration = expiration;
	}

	public int getCost() 
	{
		return _cost;
	}
	
	public LocalDate getExpiration() 
	{
		return _expiration;
	}

	public void setCost(int cost) 
	{
		_cost = cost;
	}

	public void setExpiration(LocalDate expiration)
	{
		_expiration = expiration;
	}
}
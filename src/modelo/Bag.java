package modelo;

import java.time.LocalDate;

public class Bag 
{
	private int _points;
	private LocalDate _expiration;
	
	public Bag(int points, LocalDate expiration) 
	{
		_points = points;
		_expiration = expiration;
	}

	public int getPoints() {
		return _points;
	}
	
	public LocalDate getExpiration()
	{
		return _expiration;
	}

	public void setPoints(int points)
	{
		_points = points;
	}

	public void setExpiration(LocalDate expiration) 
	{
		_expiration = expiration;
	}
}
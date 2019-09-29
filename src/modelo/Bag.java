package modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bag 
{
	@Id
	@GeneratedValue
	private int _id;
	private int _points;
	private LocalDate _expiration;
	
//	@OneToOne
//	private Customer _customer;
	
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
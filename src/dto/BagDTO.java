package dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BagDTO 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	private int _points;
	private LocalDate _expiration;
		
	public BagDTO(int points, LocalDate expiration) 
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
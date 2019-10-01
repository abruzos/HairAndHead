package dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DebtDTO 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	private int _cost;
	private LocalDate _expiration;

//	@OneToOne
//	private Customer _customer;
	
	public DebtDTO(int cost, LocalDate expiration) 
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
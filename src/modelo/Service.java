package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Service 
{
	@Id
	@GeneratedValue
	private int _id;
	private String _name;
	private int _duration;
	private int _cost;
	
	@ManyToOne
	private Employee _employee;
	
	@OneToOne
	private Service _service;
	
	public Service(String name, int duration, int cost)
	{
		_name = name;
		_duration = duration;
		_cost = cost;
//		_employee = employee;
	}

	public String getName()
	{
		return _name;
	}
	
	public int getDuration() 
	{
		return _duration;
	}
	
	public int getCost() 
	{
		return _cost;
	}
	
	public Employee getEmployee() 
	{
		return _employee;
	}

	public void setName(String name)
	{
		_name = name;
	}

	public void setDuration(int duration) 
	{
		_duration = duration;
	}

	public void setCost(int cost) 
	{
		_cost = cost;
	}

	public void setEmployee(Employee employee) 
	{
		_employee = employee;
	}	
}
package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ServiceDTO 
{
	@Id
	@GeneratedValue
	private int _id;
	private String _name;
	private int _duration;
	private int _cost;
	
	@ManyToOne
	private EmployeeDTO _employee;
	
	@OneToOne
	private ServiceDTO _service;
	
	public ServiceDTO(String name, int duration, int cost)
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
	
	public EmployeeDTO getEmployee() 
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

	public void setEmployee(EmployeeDTO employee) 
	{
		_employee = employee;
	}	
}
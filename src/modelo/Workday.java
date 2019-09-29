package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Workday 
{
	@Id
	@GeneratedValue
	private int _id;
	private String _day;
	private String _since;
	private String _until;
	
	@ManyToOne
	private Employee _employee;
	
	public Workday(String day, String since, String until) 
	{
		_day = day;
		_since = since;
		_until = until;
	}
	
	public Workday() {}

	public String getDay() 
	{
		return _day;
	}

	public String getSince()
	{
		return _since;
	}

	public String getUntil() 
	{
		return _until;
	}

	public void setDay(String day)
	{
		_day = day;
	}

	public void setSince(String since) 
	{
		_since = since;
	}

	public void setUntil(String until)
	{
		_until = until;
	}
	
	public Employee getEmployee()
	{
		return _employee;
	}
	
	public void setEmploye(Employee e)
	{
		this._employee = e;
	}
}
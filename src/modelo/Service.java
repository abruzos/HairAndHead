package modelo;

public class Service 
{
	private String _name;
	private int _duration;
	private int _cost;
	private Employee _employee;
	
	public Service(String name, int duration, int cost, Employee employee)
	{
		_name = name;
		_duration = duration;
		_cost = cost;
		_employee = employee;
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
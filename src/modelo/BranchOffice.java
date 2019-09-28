package modelo;

import java.util.ArrayList;

public class BranchOffice 
{
	private String _name;
	private String _adress;
	private String _location;
	private String _city;
	private String _country;
	private ArrayList<Employee> _emplyees;
	
	public BranchOffice(String name,String adress, String location, String city, String country) 
	{
		_name = name;
		_adress = adress;
		_location = location;
		_location = city;
		_country = country;
		_emplyees = new ArrayList<Employee>();
	}
	
	public BranchOffice() {}
	
	public String getName()
	{
		return _name;
	}

	public String getAdress()
	{
		return _adress;
	}

	public String getLocation() 
	{
		return _location;
	}

	public String getCity()
	{
		return _city;
	}

	public String getCountry() 
	{
		return _country;
	}

	public ArrayList<Employee> get_emplyees() 
	{
		return _emplyees;
	}

	public void setName(String name)
	{
		_name = name;
	}

	public void setAdress(String adress)
	{
		_adress = adress;
	}

	public void setLocation(String location) 
	{
		_location = location;
	}

	public void setCity(String city) 
	{
		_city = city;
	}

	public void setCountry(String country) 
	{
		_country = country;
	}

	public void setEmplyees(ArrayList<Employee> emplyees)
	{
		_emplyees = emplyees;
	}
}
package dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class BranchOfficeDTO 
{
	@Id
	@GeneratedValue
	private int _id;
	private String _name;
	private String _adress;
	private String _location;
	private String _city;
	private String _country;
	
	@OneToMany (mappedBy = "_branchOffice", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<EmployeeDTO> _employees = new ArrayList<>();
	
	public BranchOfficeDTO(String name,String adress, String location, String city, String country) 
	{
		_name = name;
		_adress = adress;
		_location = location;
		_location = city;
		_country = country;
	}
	
	public BranchOfficeDTO() {}
	
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
	
	public List<EmployeeDTO> getEmployees() 
	{
		return _employees;
	}
	
	public void addEmployee(EmployeeDTO e)
	{
		this._employees.add(e);
		e.setBranchOffice(this);
	}

	public void removeEmplyee(EmployeeDTO e)
	{
		this._employees.remove(e);
		e.setBranchOffice(this);
	}
}
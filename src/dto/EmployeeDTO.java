package dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class EmployeeDTO extends PersonDTO
{
	@Id
	@GeneratedValue
	private int _id;
	private String _type;
	private String _state;
	private String _user;
	private String _password;
	
	@ManyToOne
	private BranchOfficeDTO _branchOffice;
	
	@OneToMany (mappedBy = "_employee", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<WorkdayDTO> _workdays = new ArrayList<>();
	
	@OneToMany (mappedBy = "_employee", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<ServiceDTO> _services = new ArrayList<>();
	
		
	public EmployeeDTO(String name, String surname, String age, String mail, String numberPhone,
					String type, String state, String user, String password) 
	{
		super(name, surname, age, mail, numberPhone);
		_type = type;
		_state = state;
		_user = user;
		_password = password;
	}
	
	public EmployeeDTO() {}

	public BranchOfficeDTO getBranchOffice() 
	{
		return _branchOffice;
	}

	public String getType() 
	{
		return _type;
	}

	public String getState() 
	{
		return _state;
	}
	
	public String getUser() 
	{
		return _user;
	}
	
	public String getPassword() 
	{
		return _password;
	}
	
	public void setBranchOffice(BranchOfficeDTO branchOffice) 
	{
		_branchOffice = branchOffice;
	}

	public void setType(String type) 
	{
		_type = type;
	}

	public void setState(String state) 
	{
		_state = state;
	}
	
	public void setUser(String user) 
	{
		_user = user;
	}

	public void setPassword(String password)
	{
		_password = password;
	}	
	
	public List<WorkdayDTO> getWorkdays()
	{
		return _workdays;
	}
	
	public void addWorkday(WorkdayDTO d) 
	{
		this._workdays.add(d);
		d.setEmploye(this);
	}
	
	public void removeWorkday(WorkdayDTO d) 
	{
		this._workdays.remove(d);
		d.setEmploye(this);
	}
	
	public List<ServiceDTO> getServices()
	{
		return _services;
	}
	
	public void addService(ServiceDTO s) 
	{
		this._services.add(s);
		s.setEmployee(this);
	}
	
	public void removeService(ServiceDTO s) 
	{
		this._services.remove(s);
		s.setEmployee(this);
	}
}
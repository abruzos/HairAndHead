package modelo;

public class Employee extends Person
{
	private BranchOffice _branchOffice;
	private String _type;
	private Workday _workday;
	private String _state;
	private Service _service;
	private String _user;
	private String _password;
	
	public Employee(String name, String surname, String age, String mail, String numberPhone,
					BranchOffice branchOffice, String type, Workday workday, String state,
					Service service, String user, String password) 
	{
		super(name, surname, age, mail, numberPhone);
		_branchOffice = branchOffice;
		_type = type;
		_workday = workday;
		_state = state;
		_service = service;
		_user = user;
		_password = password;
	}
	
	public Employee() {}

	public BranchOffice getBranchOffice() 
	{
		return _branchOffice;
	}

	public String getType() 
	{
		return _type;
	}

	public Workday getWorkday() 
	{
		return _workday;
	}

	public String getState() 
	{
		return _state;
	}

	public Service getService()
	{
		return _service;
	}
	
	public String getUser() 
	{
		return _user;
	}
	
	public String getPassword() 
	{
		return _password;
	}
	
	public void setBranchOffice(BranchOffice branchOffice) 
	{
		_branchOffice = branchOffice;
	}

	public void setType(String type) 
	{
		_type = type;
	}

	public void setWorkday(Workday workday)
	{
		_workday = workday;
	}

	public void setState(String state) 
	{
		_state = state;
	}

	public void setService(Service service) 
	{
		_service = service;
	}

	public void setUser(String user) 
	{
		_user = user;
	}

	public void setPassword(String password)
	{
		_password = password;
	}	
}
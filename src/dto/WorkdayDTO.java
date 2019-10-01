package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class WorkdayDTO 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	private String _day;
	private String _since;
	private String _until;
	
	@ManyToOne
	private EmployeeDTO _employee;
	
	@ManyToOne
	private ProfessionalDTO _professional;
	
	public WorkdayDTO(String day, String since, String until) 
	{
		_day = day;
		_since = since;
		_until = until;
	}
	
	public WorkdayDTO() {}

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
	
	public EmployeeDTO getEmployee()
	{
		return _employee;
	}
	
	public ProfessionalDTO getProfessional()
	{
		return _professional;
	}
	
	public void setEmploye(EmployeeDTO e)
	{
		_employee = e;
	}
	
	public void setProfessional(ProfessionalDTO professional)
	{
		_professional = professional;
	}
}
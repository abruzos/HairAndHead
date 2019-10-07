package dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProfessionalDTO extends PersonDTO
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	private String _type;
	private String _state;
	
	@ManyToOne
	private BranchOfficeDTO _branchOfficep;

	@OneToMany (mappedBy = "_professional", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<WorkdayDTO> _workdays = new ArrayList<>();
	
	@OneToMany (mappedBy = "_professionalservice", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<ServiceDTO> _services = new ArrayList<>();
	
	@OneToMany (mappedBy = "_professionalt", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<TurnDTO> _turns = new ArrayList<>();

	public ProfessionalDTO(String name, String surname, String age, String mail, String numberPhone, String type, String state) 
	{
		super(name, surname, age, mail, numberPhone);
		_type = type;
		_state = state;
	}
	
	public ProfessionalDTO() {}
	

	public String getName()
	{
		return super.getName();
	}

	public String getSurname()
	{
		return super.getSurname();
	}

	public String getAge()
	{
		return super.getAge();
	}

	public String getMail() 
	{
		return super.getMail();
	}
	
	public String getNumberPhone()
	{
		return super.getNumberPhone();
	}

	public String getType() 
	{
		return _type;
	}

	public String getState() 
	{
		return _state;
	}
	
	public BranchOfficeDTO getBranchOffice() 
	{
		return _branchOfficep;
	}
	
	public void setName(String name)
	{
		super.setName(name);
	}

	public void setSurname(String surname)
	{
		super.setSurname(surname);
	}

	public void setAge(String age) 
	{
		super.setAge(age);
	}
	
	public void setMail(String mail)
	{
		super.setMail(mail);
	}
	
	public void setNumberPhone(String numberPhone)
	{
		super.set_numberPhone(numberPhone);
	}

	public void setType(String type) 
	{
		_type = type;
	}

	public void setState(String state) 
	{
		_state = state;
	}
	
	public void setBranchOffice(BranchOfficeDTO branchOffice) 
	{
		_branchOfficep = branchOffice;
	}
	
	public List<WorkdayDTO> getWorkdays()
	{
		return _workdays;
	}
	
	public void addWorkday(WorkdayDTO d) 
	{
		this._workdays.add(d);
		d.setProfessional(this);
	}
	
	public void removeWorkday(WorkdayDTO d) 
	{
		this._workdays.remove(d);
		d.setProfessional(this);
	}
	
	public List<TurnDTO> getTurns()
	{
		return _turns;
	}
	
	public void addTurn(TurnDTO t) 
	{
		this._turns.add(t);
		t.setProfessional(this);
	}
	
	public void removeTurn(TurnDTO t) 
	{
		this._turns.remove(t);
		t.setProfessional(this);
	}

	public List<ServiceDTO> getServices()
	{
		return _services;
	}

	public void addService(ServiceDTO s) 
	{
		this._services.add(s);
		s.setProfessional(this);
	}
	
	public void removeService(ServiceDTO s) 
	{
		this._services.remove(s);
		s.setProfessional(this);
	}
	
	@Override
	public String toString() {
		return super.getName();
	}
}
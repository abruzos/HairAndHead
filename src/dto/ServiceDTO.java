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
public class ServiceDTO 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	private String _name;
	private int _duration;
	private int _cost;
	
	@OneToMany (mappedBy = "_service", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<TurnDTO> _turns = new ArrayList<>();

	@ManyToOne
	private ProfessionalDTO _professionalservice;
	
	public ServiceDTO(String name, int duration, int cost)
	{
		_name = name;
		_duration = duration;
		_cost = cost;
	}
	
	public ServiceDTO()
	{	
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

	public List<TurnDTO> getTurns() 
	{
		return _turns;
	}
	
	public void addTurn(TurnDTO t)
	{
		this._turns.add(t);
		t.setService(this);
	}

	public void removeTurn(TurnDTO t)
	{
		this._turns.remove(t);
		t.setService(this);
	}

	public ProfessionalDTO getProfessional() 
	{
		return _professionalservice;
	}
	
	public void setProfessional(ProfessionalDTO p) 
	{
		_professionalservice = p;
	}

	@Override
	public String toString() {
		return _name;
	}
	
}
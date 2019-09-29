package dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CustomerDTO extends PersonDTO
{
	@Id
	@GeneratedValue
	private int _id;
	private String _state;

	@OneToOne
	private DebtDTO _debt;
	@OneToOne
	private BagDTO _bag;

	@OneToMany (mappedBy = "_customer", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<TurnDTO> _turns = new ArrayList<>();

	
	public CustomerDTO(String name, String surname, String age, String mail, String numberPhone,
					String state, DebtDTO debt, BagDTO bag)
	{
		super(name, surname, age, mail, numberPhone);
		_state = state;
		_debt = debt;
	}
	
	public CustomerDTO() {}

	public BagDTO getBag()
	{
		return _bag;
	}
	
	public String getState() 
	{
		return _state;
	}
	
	public DebtDTO getDebt() 
	{
		return _debt;
	}
	
	public void setBag(BagDTO bag)
	{
		_bag = bag;
	}

	public void setState(String state) 
	{
		_state = state;
	}

	public void setDebt(DebtDTO debt) 
	{
		_debt = debt;
	}
}
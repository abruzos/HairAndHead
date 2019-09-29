package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer extends Person
{
	@Id
	@GeneratedValue
	private int _id;
	private String _state;

	@OneToOne
	private Debt _debt;
	@OneToOne
	private Bag _bag;

	@OneToMany (mappedBy = "_customer", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Turn> _turns = new ArrayList<>();

	
	public Customer(String name, String surname, String age, String mail, String numberPhone,
					String state, Debt debt, Bag bag)
	{
		super(name, surname, age, mail, numberPhone);
		_state = state;
		_debt = debt;
	}
	
	public Customer() {}

	public Bag getBag()
	{
		return _bag;
	}
	
	public String getState() 
	{
		return _state;
	}
	
	public Debt getDebt() 
	{
		return _debt;
	}
	
	public void setBag(Bag bag)
	{
		_bag = bag;
	}

	public void setState(String state) 
	{
		_state = state;
	}

	public void setDebt(Debt debt) 
	{
		_debt = debt;
	}
}
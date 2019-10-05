package dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CustomerDTO
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	private String _name;
	private String _surname;
	private String _age;
	private String _mail;
	private String _numberPhone;
	private String _state;


	@OneToOne(cascade = CascadeType.ALL)
	private DebtDTO _debt;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BagDTO _bag;

	@OneToMany (mappedBy = "_customerTurn", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<TurnDTO> _turns = new ArrayList<>();

	@OneToMany (mappedBy = "_customerPayment", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<PaymentDTO> _payments = new ArrayList<>();
	
	public CustomerDTO(String name, String surname, String age, String mail, String numberPhone, String state)
	{
		_name = name;
		_surname = surname;
		_age = age;
		_mail = mail;
		_numberPhone = numberPhone;
		_state = state;
	}
	
	public CustomerDTO() {}
	
	public int getID()
	{
		return _id;
	}
	
	public String getName()
	{
		return _name;
	}

	public String getSurname()
	{
		return _surname;
	}

	public String getAge()
	{
		return _age;
	}

	public String getMail() 
	{
		return _mail;
	}

	public String getNumberPhone()
	{
		return _numberPhone;
	}
	
	public String getState() 
	{
		return _state;
	}

	public BagDTO getBag()
	{
		return _bag;
	}
	
	public DebtDTO getDebt() 
	{
		return _debt;
	}
	
	public void setName(String name)
	{
		_name = name;
	}

	public void setSurname(String surname)
	{
		_surname = surname;
	}

	public void setAge(String age) 
	{
		_age = age;
	}
	
	public void setMail(String mail)
	{
		_mail = mail;
	}
	
	public void setNumberPhone(String numberPhone)
	{
		_numberPhone = numberPhone;
	}
	
	public void setState(String state) 
	{
		_state = state;
	}
	
	public void setBag(BagDTO bag)
	{
		_bag = bag;
	}

	public void setDebt(DebtDTO debt) 
	{
		_debt = debt;
	}
	
	public List<TurnDTO> getTurns() 
	{
		return _turns;
	}
	
	public void addTurn(TurnDTO t)
	{
		this._turns.add(t);
		t.setCustomerTurn(this);
	}

	public void removeTurn(TurnDTO t)
	{
		this._turns.remove(t);
		t.setCustomerTurn(this);
	}
	
	public List<PaymentDTO> getPayments() 
	{
		return _payments;
	}
	
	public void addPayment(PaymentDTO p)
	{
		this._payments.add(p);
		p.setCustomerPayment(this);
	}

	public void removePayment(PaymentDTO p)
	{
		this._payments.remove(p);
		p.setCustomerPayment(this);
	}
	
}
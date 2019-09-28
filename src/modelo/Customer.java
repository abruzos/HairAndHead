package modelo;

public class Customer extends Person
{
	private String _state;
	private Debt _debt;
	private Bag _bag;
	private Turn _turn;
	
	public Customer(String name, String surname, String age, String mail, String numberPhone,
					String state, Debt debt, Bag bag, Turn turn)
	{
		super(name, surname, age, mail, numberPhone);
		_state = state;
		_debt = debt;
		_turn = turn;
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
	
	public Turn getTurn() 
	{
		return _turn;
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

	public void setTurn(Turn turn)
	{
		_turn = turn;
	}	
}